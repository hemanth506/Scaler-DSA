import type { IOrderStatusEvent, IOrderData } from "../utils/orderStatus.ts"

export interface IOrderStatusRepository {
    save(data: IOrderData): void
    getDataByKey(key: string): IOrderStatusEvent[] | undefined
}
export class OrderStatusRepository implements IOrderStatusRepository{
    private db: Map<string, IOrderStatusEvent[]>
    constructor() {
        this.db = new Map<string, IOrderStatusEvent[]>()
    }
    save(data: IOrderData) {
        if(!this.db.has(data.key)) {
            this.db.set(data.key, [])
        }
        this.db.get(data.key)!.push(data.value)
        console.log('Saved in DB', this.db.get(data.key));
    }
    getDataByKey(key: string) {
        return this.db.get(key)
    }
}