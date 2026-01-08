import { Order } from "../models/Order.ts";
import type { IOrderStatusRepository } from "../repository/orderStatus.repository.ts";
import type { IOrderStatusEvent } from "../utils/orderStatus.ts";
import { OrderStatus } from "../utils/orderStatus.ts";
import type { IEventBus } from "./eventBus.service.ts";

const AllowedTransitions: Record<OrderStatus, Set<OrderStatus>> = {
    CREATED: new Set(['CONFIRMED', 'CANCELLED']),
    CONFIRMED: new Set(['SHIPPED', 'CANCELLED']),
    SHIPPED: new Set(['DELIVERED']),
    DELIVERED: new Set([]),
    CANCELLED: new Set([]),
}

export interface IOrderStatusService {
    handleStatusUpdateEvent(newStatus: OrderStatus, order: Order): void
}

export class OrderStatusService implements IOrderStatusService {
    osRepo: IOrderStatusRepository
    ebService: IEventBus
    constructor(osRepo: IOrderStatusRepository, ebService: IEventBus) {
        this.osRepo = osRepo
        this.ebService = ebService
    }
    handleStatusUpdateEvent(newStatus: OrderStatus, order: Order) {
        const oldStatus: OrderStatus | null = order.getStatus()
        if (!this.isValidTransition(oldStatus, newStatus)) {
            throw new Error("Invalid transaction")
        }

        order.setStatus(newStatus)

        const key = order.orderId + "_" + order.userId
        const value: IOrderStatusEvent = {
            orderId: order.getOrderId(),
            userId: order.getUserId(),
            oldStatus,
            newStatus,
            timeStamp: Date.now(),
            eventId: crypto.randomUUID()
        }
        this.osRepo.save({ key, value })
        this.ebService.notify({ key, value })
    }
    private isValidTransition(oldStatus: OrderStatus | null, newStatus: OrderStatus): boolean {
        if (oldStatus === OrderStatus.CREATED && oldStatus === newStatus) return true;
        if (oldStatus === null) {
            return newStatus === OrderStatus.CREATED
        }
        return AllowedTransitions[oldStatus].has(newStatus)
    }
}