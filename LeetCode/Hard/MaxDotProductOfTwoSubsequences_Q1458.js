var maxDotProduct = function (nums1, nums2) {
    const n = nums1.length
    const m = nums2.length
    const dp = Array.from({ length: n }, () => Array(m).fill(-1))
    function solve(i, j) {
        if (i === n || j === m) {
            return -Infinity;
        }

        if (dp[i][j] === -1) {
            const moveBoth = solve(i + 1, j + 1)
            const pickBoth = ((moveBoth < 0) ? 0 : moveBoth) + (nums1[i] * nums2[j])
            const skipI = solve(i + 1, j)
            const skipJ = solve(i, j + 1)
            dp[i][j] = Math.max(pickBoth, skipI, skipJ)
        }
        return dp[i][j]
    }
    return solve(0, 0)
};

let nums1, nums2
nums1 = [2,1,-2,5], nums2 = [3,0,-6]
// nums1 = [3,-2], nums2 = [2,-6,7]
// nums1 = [-1,-1], nums2 = [1,1]
// nums1 = [-5, -1, -2], nums2 = [3, 3, 5]

console.log(maxDotProduct(nums1, nums2));