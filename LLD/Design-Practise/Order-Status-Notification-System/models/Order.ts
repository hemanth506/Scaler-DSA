import { OrderStatus } from "../utils/orderStatus.ts"

export class Order {
    orderId: string
    userId: string
    status: OrderStatus | null
    constructor(orderId: string, userId: string, status: OrderStatus | null) {
        this.orderId = orderId
        this.userId = userId
        this.status = status
    }
    getStatus() { return this.status }
    setStatus(status: OrderStatus) {
        this.status = status
    }
    getUserId() { return this.userId }
    getOrderId() { return this.orderId }
}