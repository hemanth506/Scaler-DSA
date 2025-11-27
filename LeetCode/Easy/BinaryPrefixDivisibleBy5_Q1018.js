var prefixesDivBy5 = function(nums) {
    const n = nums.length
    let val = 0
    for(let i = 0; i < n; i++) {
        val = (val % 5) + nums[i];
        let res = (val % 5) === 0 ? true : false;
        nums[i] = res
        val *= 2
    }

    return nums
};

let nums;

// nums = [0,1,1]
nums = [1,1,1]

prefixesDivBy5(nums)