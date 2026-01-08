import { Order } from "../models/Order.ts";
import { OrderStatus } from "../utils/orderStatus.ts";
import type { IOrderStatusService } from "./orderStatus.service.ts";

export class OrderService {
    oss: IOrderStatusService
    constructor(oss: IOrderStatusService) {
        this.oss = oss
    }
    orderCreated(userId: string): Order {
        const order = new Order(crypto.randomUUID(), userId, null)
        this.triggerStatusUpdateEvent(OrderStatus.CREATED, order)
        return order
    }
    orderConfirmed(order: Order): void {
        this.triggerStatusUpdateEvent(OrderStatus.CONFIRMED, order)
    }
    orderShipped(order: Order): void {
        this.triggerStatusUpdateEvent(OrderStatus.SHIPPED, order)
    }
    orderDelivered(order: Order): void {
        this.triggerStatusUpdateEvent(OrderStatus.DELIVERED, order)
    }
    orderCancelled(order: Order): void {
        this.triggerStatusUpdateEvent(OrderStatus.CANCELLED, order)
    }
    private triggerStatusUpdateEvent(newStatus: OrderStatus, order: Order) {
        this.oss.handleStatusUpdateEvent(newStatus, order)
    }
}

export class AdminService extends OrderService {
    constructor(oss: IOrderStatusService) {
        super(oss)
    }
}
