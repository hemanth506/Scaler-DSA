var maxFrequency = function(nums, k, numOperations) {
    const n = nums.length
    const maxVal = Math.max(...nums)

    nums.sort((a,b) => a - b)

    const freq = new Map();
    for (let num of nums) {
        freq.set(num, (freq.get(num) || 0) + 1);
    }

    function bisect_left(elt) {
        let l = 0, h = n-1
        while (l <= h) {
            let m = Math.floor((l+h)/2)
            if(nums[m] >= elt) {
                h = m - 1
            } else {
                l = m + 1
            }
        }
        return l
    }
    function bisect_right(elt) {
        let l = 0, h = n-1
        while (l <= h) {
            let m = Math.floor((l+h)/2)
            if(nums[m] <= elt) {
                l = m + 1
            } else {
                h = m - 1
            }
        }
        return l
    }

    let ans = 1
    for(let target = nums[0]; target <= maxVal; target++) {
        const left = bisect_left(target-k)
        const right = bisect_right(target+k)

        const ops = right - left - ((freq.get(target) || 0))
        const val = (freq.get(target) || 0) + Math.min(numOperations, ops)
        ans = Math.max(ans, val)

    }
    return ans
};