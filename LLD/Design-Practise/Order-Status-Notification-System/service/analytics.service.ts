import type { IOrderStatusSubscriber, IOrderData } from "../utils/orderStatus.ts"

export class AnalyticsService implements IOrderStatusSubscriber {
    orderStatusChanged(data: IOrderData): void {
        console.log(`Handle ${data.value.newStatus} event in Analytics Service from data`)
    }
}