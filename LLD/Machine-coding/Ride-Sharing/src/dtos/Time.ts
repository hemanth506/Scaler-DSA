export class Time {
    private startTime: Date
    private endTime: Date

    constructor(startTime: Date, endTime: Date) {
        this.startTime = startTime
        this.endTime = endTime
    }

    getStartTime() {
        return this.startTime
    }

    getEndTime() {
        return this.endTime
    }
}