var minimizeSum = function(nums) {
    const n = nums.length
    nums.sort((a,b) => a - b)
    return Math.min(nums[n-1] - nums[2], Math.min(nums[n-2] - nums[1], nums[n-3] - nums[0]))
};

let nums;
// nums = [1,4,7,8,5]
// nums = [1,4,3]
// nums = [59,27,9,81,33]
nums = [58,42,8,75,28]


console.log(minimizeSum(nums));