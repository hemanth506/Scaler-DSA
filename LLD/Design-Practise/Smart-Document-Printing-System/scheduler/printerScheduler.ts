import type { Decorator } from "../decorator/utils.ts";
import { Priority } from "../utils/printer-utils.ts";

export interface Scheduler {
    schedule(decorators: Decorator[], priority: Priority): void
}

export class PrinterScheduler implements Scheduler {
    private highQueue: Decorator[][] = []
    private midQueue: Decorator[][] = []
    private lowQueue: Decorator[][] = []

    schedule(decorators: Decorator[], priority: Priority): void {
        this.strategyPushByPriority(decorators, priority)
        this.runNext()
    }
    private strategyPushByPriority(decorators: Decorator[], priority: Priority) {
        switch (priority) {
            case Priority.HIGH:
                this.highQueue.push(decorators)
                break;
            case Priority.MEDIUM:
                this.midQueue.push(decorators)
                break;
            case Priority.LOW:
                this.lowQueue.push(decorators)
                break;
            default:
                this.lowQueue.push(decorators)
                break;
        }
        return
    }

    private runNext(): void {
        const job =
            this.highQueue.shift() ??
            this.midQueue.shift() ??
            this.lowQueue.shift()
        if (!job) {
            console.log("No Printer is available for your requirement ;(")
            return
        }

        const executed = this.executeJob(job)
        if(!executed) {
            this.runNext()
        }
    }

    private executeJob(decorators: Decorator[]): boolean {
        for (const decorator of decorators) {
            if (this.isAllAvailable(decorator)) {
                console.log(decorator.print());
                return true
            }
        }
        return false
    }

    private isAllAvailable(decorator: Decorator): boolean {
        let decor: Decorator | undefined = decorator
        while (decor) {
            if (!decor.isOnline) return false
            const innerDecor = decor.getInner()
            decor = innerDecor
        }
        return true
    }
}