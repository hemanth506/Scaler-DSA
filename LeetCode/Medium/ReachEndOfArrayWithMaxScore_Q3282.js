var findMaximumScore = function (nums) {
    const n = nums.length
    function maxIndexToRight() {
        const res = Array(n).fill(n - 1)
        const stk = []
        let i = n - 1
        while (i >= 0) {
            while (stk.length > 0 && nums[stk[stk.length - 1]] <= nums[i]) {
                stk.pop()
            }
            if (stk.length > 0) {
                res[i] = stk[stk.length - 1]
            }

            stk.push(i)
            i--
        }
        console.log(res)

        return res
    }

    const maxToRight = maxIndexToRight()

    let maxScore = 0
    let i = 0
    while (i < n-1) {
        maxScore += (maxToRight[i] - i) * nums[i]
        i = maxToRight[i]
    }

    console.log('maxScore', maxScore)

    return maxScore
};

let nums;

// nums = [1,3,1,5]
nums = [4,3,1,3,2]

findMaximumScore(nums)