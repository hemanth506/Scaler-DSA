var maxFrequency = function(nums, k, numOperations) {
    const n = nums.length

    nums.sort((a,b) => a - b)

    const freqMap = new Map()
    for(let num of nums) {
        freqMap.set(num, (freqMap.get(num) || 0) + 1)
    }

    function count(element) {
        let left = -1, right = -1;
        let l = 0, h = n-1
        let lowerBound = element - k
        let upperBound = element + k

        while (l <= h) {
            let m = Math.floor((l+h)/2)
            if(nums[m] >= lowerBound) {
                left = m
                h = m - 1
            } else {
                l = m + 1
            }
        }

        l = 0, h = n-1
        while (l <= h) {
            let m = Math.floor((l+h)/2)
            if(nums[m] <= upperBound) {
                right = m
                l = m + 1
            } else {
                h = m - 1
            }
        }

        let total = right - left + 1
        let freq = freqMap.get(element) || 0
        let modification = total - freq
        return freq + Math.min(modification, numOperations)
    }

    let ans = 1
    for(let i = 0; i < n; i++) {
        ans = Math.max(ans, count(nums[i]))
        ans = Math.max(ans, count(nums[i] - k))
        ans = Math.max(ans, count(nums[i] + k))
    }

    return ans
};