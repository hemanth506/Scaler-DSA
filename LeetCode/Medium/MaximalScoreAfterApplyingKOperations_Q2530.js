import { PriorityQueue } from "datastructures-js";

var maxKelements = function(nums, k) {
  const n = nums.length
  const maxPq = new PriorityQueue((a,b) => b - a)
  for(let num of nums) maxPq.enqueue(num);
  let score = 0
  for(let i = 1; i <= k; i++) {
    let maxVal = maxPq.dequeue()
    score += maxVal
    maxPq.enqueue(Math.ceil(maxVal / 3))
  }
  return score
};

let nums, k;
// nums = [10,10,10,10,10], k = 5
nums = [1,10,3,3,3], k = 3
console.log(maxKelements(nums, k));