import { PriorityQueue } from "datastructures-js";

var halveArray = function(nums) {
    const maxHeap = new PriorityQueue((a,b) => b - a)
    let total = nums.reduce((prev, cur) => prev + cur, 0)

    function divideIntoHalf(num) {
        let byTwo = num / 2;
        if(byTwo === 0) return byTwo;
        let roundTo2Dec = byTwo.toFixed(2)
        return parseFloat(roundTo2Dec)
    }
    const half = divideIntoHalf(total)

    nums.forEach(num => {
        maxHeap.enqueue(num)
    });

    let op = 0
    while(total > half) {
        const top = maxHeap.dequeue()
        const topHalf = divideIntoHalf(top)
        if(topHalf !== 0) {
            total -= topHalf
            maxHeap.enqueue(topHalf)
        } else {
            total -= top
        }
        op++
    }

    return op;
};
let nums;

// nums = [5,19,8,1]
nums = [3,8,20]

console.log(halveArray(nums));