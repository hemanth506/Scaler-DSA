var specialTriplets = function(nums) {
    const n = nums.length
    const hmR = new Map()
    const hmL = new Map()

    for(let i = 0; i < n; i++) {
        hmR.set(nums[i], (hmR.get(nums[i]) || 0) + 1);
    }


    let ct = 0;
    for(let i = 0; i < n; i++) {
        if(hmR.has(nums[i]) && hmR.get(nums[i]) - 1 > 0) {
            hmR.set(nums[i], hmR.get(nums[i]) - 1);
        } else {
            hmR.delete(nums[i])
        }

        const doubleJ = nums[i] * 2
        if(hmR.has(doubleJ) && hmL.has(doubleJ)) {
            ct += (hmR.get(doubleJ) * hmL.get(doubleJ))
        }

        hmL.set(nums[i], (hmL.get(nums[i]) || 0) + 1)
    }
    return ct;
};

let nums;
// nums = [6,3,6]
nums = [0,1,0,0]
// nums = [8,4,2,8,4]
console.log(specialTriplets(nums));