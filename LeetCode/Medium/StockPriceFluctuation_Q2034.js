class StockPrice {
    constructor() {
        this.map = new Map();
        this.minHeap = new PriorityQueue((x, y) => x[1] - y[1]);
        this.maxHeap = new PriorityQueue((x, y) => y[1] - x[1]);
        this.latestTimestamp = 0;
    }

    update(timestamp, price) {
        this.map.set(timestamp, price);
        this.latestTimestamp = Math.max(this.latestTimestamp, timestamp);
        this.minHeap.enqueue([timestamp, price]);
        this.maxHeap.enqueue([timestamp, price]);
    }

    current() {
        return this.map.get(this.latestTimestamp);
    }

    maximum() {
        while (this.maxHeap.front()[1] !== this.map.get(this.maxHeap.front()[0])) {
            this.maxHeap.dequeue();
        }
        return this.maxHeap.front()[1];
    }

    minimum() {
        while (this.minHeap.front()[1] !== this.map.get(this.minHeap.front()[0])) {
            this.minHeap.dequeue();
        }
        return this.minHeap.front()[1];
    }
}