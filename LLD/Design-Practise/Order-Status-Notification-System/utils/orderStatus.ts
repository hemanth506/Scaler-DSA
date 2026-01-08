export const OrderStatus = {
    CREATED: 'CREATED',
    CONFIRMED: 'CONFIRMED',
    SHIPPED: 'SHIPPED',
    DELIVERED: 'DELIVERED',
    CANCELLED: 'CANCELLED',
}
export type OrderStatus = (typeof OrderStatus)[keyof typeof OrderStatus]

export interface IOrderStatusEvent {
    orderId: string
    userId: string
    oldStatus: OrderStatus | null
    newStatus: OrderStatus
    timeStamp: number
    eventId: string
}

export interface IOrderData {
    key: string,
    value: IOrderStatusEvent
}

export interface IOrderStatusSubscriber {
    orderStatusChanged(data: IOrderData): void
}

