const { MinPriorityQueue } = require("datastructures-js");

class SeatManager {
    constructor (n) {
        this.minHeap = new MinPriorityQueue()
        for(let i = 1; i <= n; i++) {
            this.minHeap.enqueue(i)
        }
        this.reservedSet = new Set()
    }

    reserve() {
        const reserved = this.minHeap.dequeue()
        this.reservedSet.add(reserved)
        return reserved
    }

    unreserve(seatNumber) {
        if(this.reservedSet.has(seatNumber)) {
            this.reservedSet.delete(seatNumber)
            this.minHeap.enqueue(seatNumber)
        }
    }
}
