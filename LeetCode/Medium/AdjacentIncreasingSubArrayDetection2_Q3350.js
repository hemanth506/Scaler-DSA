var maxIncreasingSubarrays = function(nums) {
    const n = nums.length

    function helper(m) {
        let p1 = 0, p2 = m, p1ct = 0, p2ct = 0
        while (p2 < n) {
            if(p1ct === 0 || nums[p1] > nums[p1 - 1]) {
                p1ct += 1
            } else { p1ct = 1 }

            if(p2ct === 0 || nums[p2] > nums[p2 - 1]) {
                p2ct += 1
            } else { p2ct = 1 }

            if(p1ct >= m && p2ct >= m) {
                return true
            }
            p1++; p2++;
        }
        return false
    }

    let l = 0, h = n - 1, maxLen = 1
    while(l <= h) {
        let m = Math.floor((l+h) / 2)
        if(helper(m)) {
            maxLen = m
            l = m + 1
        } else {
            h = m - 1
        }
    }

    return maxLen
};

let nums;
// nums = [2,5,7,8,9,2,3,4,3,1]
nums = [1,2,3,4,4,4,4,5,6,7]

console.log(maxIncreasingSubarrays(nums));