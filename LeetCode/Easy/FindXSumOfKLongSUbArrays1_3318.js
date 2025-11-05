var findXSum = function(nums, k, x) {
    const n = nums.length
    const hm = new Map()

    function sortFn (a,b) {
        if(a[1] === b[1]) {
            return b[0] - a[0]
        }
        return b[1] - a[1]
    }

    function accumulate(arr) {
        let sum = 0
        for(let i = 0; i < Math.min(x, arr.length); i++) {
            sum += (arr[i][0] * arr[i][1])
        }
        return sum
    }

    for(let i = 0; i < k; i++) {
        hm.set(nums[i], (hm.get(nums[i]) || 0) + 1)
    }

    const res = []
    let arr = Array.from(hm.entries()).sort(sortFn)
    res.push(accumulate(arr))

    for(let j = k, i = 0; j < n; j++, i++) {
        if(hm.get(nums[i]) === 1) {
            hm.delete(nums[i])
        } else {
            hm.set(nums[i], hm.get(nums[i]) - 1)
        }

        hm.set(nums[j], (hm.get(nums[j]) || 0) + 1)

        arr = Array.from(hm.entries()).sort(sortFn)
        res.push(accumulate(arr))
    }

    return res
};

let nums, k, x;

// nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
// nums = [3,8,7,8,7,5], k = 2, x = 2
nums = [9,2,2], k = 3, x = 3

console.log(findXSum(nums, k, x));