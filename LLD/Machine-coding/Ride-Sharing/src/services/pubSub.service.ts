
export type Callback = (data: any) => void

export class PubSubService {
    private topics: Map<string, Callback[]>

    constructor() {
        this.topics = new Map()
    }

    subscribe(topic: string, listener: Callback) {
        if(!this.topics.has(topic)) {
            this.topics.set(topic, [])
        }

        this.topics.get(topic)?.push(listener)
    }

    publish(topic: string, data?: any) {
        const listeners = this.topics.get(topic) || []
        for(let listener of listeners) {
            listener(data)
        }
    }
}