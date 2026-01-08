import type { IOrderStatusSubscriber, IOrderData } from "../utils/orderStatus.ts";

export class AuditService implements IOrderStatusSubscriber {
    orderStatusChanged(data: IOrderData): void {
        console.log(`Handle ${data.value.newStatus} event in Audit Service from data`)
    }
}