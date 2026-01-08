import { Order } from "./models/Order.ts";
import type { IOrderStatusRepository } from "./repository/orderStatus.repository.ts";
import { OrderStatusRepository } from "./repository/orderStatus.repository.ts";
import { AnalyticsService } from "./service/analytics.service.ts";
import { AuditService } from "./service/audit.service.ts";
import { EventBus } from "./service/eventBus.service.ts";
import type { IEventBus } from "./service/eventBus.service.ts";
import { NotificationService } from "./service/notification.service.ts";
import { AdminService, OrderService } from "./service/order.service.ts";
import { OrderStatusService } from "./service/orderStatus.service.ts";
import type { IOrderStatusService } from "./service/orderStatus.service.ts";
import type { IOrderStatusSubscriber } from "./utils/orderStatus.ts";

const eventBus: IEventBus = new EventBus()
const analyticsService: IOrderStatusSubscriber = new AnalyticsService()
const auditService: IOrderStatusSubscriber = new AuditService()
const notService: IOrderStatusSubscriber = new NotificationService()
eventBus.registerSubscriber(notService)
eventBus.registerSubscriber(auditService)
eventBus.registerSubscriber(analyticsService)

const osRepo: IOrderStatusRepository = new OrderStatusRepository()
const orderStatusService: IOrderStatusService = new OrderStatusService(osRepo, eventBus)
const orderService = new OrderService(orderStatusService)


const order: Order = orderService.orderCreated(crypto.randomUUID())
orderService.orderConfirmed(order)


const adminService = new AdminService(orderStatusService)
adminService.orderShipped(order)

console.log('Final status', order.getStatus());