var canSortArray = function (nums) {
    const n = nums.length
    console.log(nums)

    function countSetBits(elt) {
        let ct = 0
        while (elt > 0) {
            if ((elt & 1) === 1) {
                ct += 1
            }
            elt = elt >> 1
        }
        return ct
    }

    const bitCt = new Map()
    for (let i = 0; i < n; i++) {
        if (!bitCt.has(nums[i])) {
            bitCt.set(nums[i], countSetBits(nums[i]))
        }
    }

    nums.sort((a, b) => {
        if ((a - b) < 0) {
            if (bitCt.get(a) === bitCt.get(b)) {
                return a - b
            }
        }
        return 0
    })

    console.log(nums)
    for(let i = 1; i < n; i++) {
        if(nums[i-1] > nums[i]) {
            return false
        }
    }

    return true
};

let nums

nums = [8, 4, 2, 15, 30, 15]
// nums = [1, 2, 3, 4, 5]
// nums = [3,16,8,4,2]


console.log(canSortArray(nums))