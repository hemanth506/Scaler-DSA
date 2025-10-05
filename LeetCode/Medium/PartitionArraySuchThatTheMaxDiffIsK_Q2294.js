var partitionArray = function (nums, k) {
    const n = nums.length
    let ctSeq = 0
    nums.sort((a,b) => a - b)
    console.log(nums)

    let p1 = 0, p2 = 1
    while (p2 < n) {
        if(nums[p2] - nums[p1] > k) {
            p1 = p2
            ctSeq += 1
        } 
        p2++
    }
    console.log(ctSeq)
    return ctSeq
};

let nums, k

nums = [3, 6, 1, 2, 5], k = 2
nums = [5,16,3,20,9,20,16,19,6], k = 4

partitionArray(nums, k)
