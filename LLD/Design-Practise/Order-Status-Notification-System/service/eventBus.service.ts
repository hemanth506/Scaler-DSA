import type { IOrderData, IOrderStatusSubscriber } from "../utils/orderStatus.ts"

export interface IEventBus {
    registerSubscriber(subscriber: IOrderStatusSubscriber): void
    unRegisterSubscriber(subscriber: IOrderStatusSubscriber): void
    notify(data: IOrderData): void
}

export class EventBus implements IEventBus {
    private subscribers: Set<IOrderStatusSubscriber> = new Set()
    registerSubscriber(subscriber: IOrderStatusSubscriber) {
        this.subscribers.add(subscriber)
    }

    unRegisterSubscriber(subscriber: IOrderStatusSubscriber) {
        this.subscribers.delete(subscriber)
    }

    notify(data: IOrderData) {
        for (let sub of this.subscribers) {
            try {
                sub.orderStatusChanged(data)
            } catch (e) {
                console.log(`Error occured while notifying`, data);
            }
        }
    }
}