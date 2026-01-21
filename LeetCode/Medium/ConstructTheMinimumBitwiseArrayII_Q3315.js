var minBitwiseArray = function (nums) {
    const n = nums.length

    const ans = Array(n).fill(-1)
    for (let idx = 0; idx < n; idx++) {
        
        let val = nums[idx], msbVal = Infinity, i = 1, bitVal = 1
        while (val > 0) {
            if ((val & 1) === 1) {
                let toRemBit = nums[idx] - bitVal
                if ((toRemBit | (toRemBit + 1)) === nums[idx]) {
                    msbVal = Math.min(msbVal, toRemBit);
                }
            }
            val = val >> 1
            bitVal = 1 << i
            i++
        }
        if(msbVal !== Infinity) {
            ans[idx] = msbVal
        }
    }
    return ans
};

let nums;
nums = [101]

console.log(minBitwiseArray(nums));