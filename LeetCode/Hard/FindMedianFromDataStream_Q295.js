import { PriorityQueue } from "datastructures-js";

class MedianFinder {
    leftMaxPQ = new PriorityQueue((a, b) => b - a)
    rightMinPQ = new PriorityQueue((a,b) => a - b)

    addNum(num) {
        if(this.rightMinPQ.front() <= num || this.rightMinPQ.size() === 0) {
            this.rightMinPQ.enqueue(num)
            const minSize = this.rightMinPQ.size(), maxSize = this.leftMaxPQ.size()
            if(Math.abs(minSize - maxSize) >= 2) {
                this.leftMaxPQ.enqueue(this.rightMinPQ.dequeue())
            }
        } else {
            this.leftMaxPQ.enqueue(num)
            const minSize = this.rightMinPQ.size(), maxSize = this.leftMaxPQ.size()
            if(Math.abs(minSize - maxSize) >= 1) {
                this.rightMinPQ.enqueue(this.leftMaxPQ.dequeue())
            }
        }
    }

    findMedian () {
        const minSize = this.rightMinPQ.size(), maxSize = this.leftMaxPQ.size()
        if(minSize === maxSize) {
            return (this.rightMinPQ.front() + this.leftMaxPQ.front()) / 2
        }
        return this.rightMinPQ.front()
    }
}

const mf = new MedianFinder()
// [7, 3, 5, 2, 9, 1]
mf.addNum(7)
console.log(mf.findMedian());
mf.addNum(3)
mf.addNum(4)
console.log(mf.findMedian());
mf.addNum(5)
console.log(mf.findMedian());