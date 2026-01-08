import type { IOrderStatusSubscriber, IOrderData } from "../utils/orderStatus.ts";

export class NotificationService implements IOrderStatusSubscriber {
    orderStatusChanged(data: IOrderData): void {
        console.log(`Handle ${data.value.newStatus} event in Notification Service from data`)
    }
}