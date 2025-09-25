var minCost = function(nums) {
    const n = nums.length
    const dp = new Map()

    function solve(i, j) {
        const k = j + 1
        if(j >= n || k >= n) {
            // console.log(i, j, k)
            if(k === n) {
                return Math.max(nums[i], nums[j])
            }
            return nums[i]
        }

        const key = i+"_"+j+"_"+k
        console.log('key', key)
        if(!dp.has(key)) {
            const case1 = solve(k, k + 1) + Math.max(nums[i], nums[j])
            const case2 = solve(i, k + 1) + Math.max(nums[j], nums[k])
            const case3 = solve(j, k + 1) + Math.max(nums[i], nums[k])
            console.log(case1, case2, case3)
            const minVal = Math.min(case1, case2, case3)
            console.log('minVal', minVal)
            dp.set(key, minVal)
        }
        return dp.get(key)
    }
    const res = solve(0, 1)
    console.log('res', res)
    return res
};

let nums;

nums = [6,2,8,4]
// nums = [2,1,3,3]

minCost(nums)