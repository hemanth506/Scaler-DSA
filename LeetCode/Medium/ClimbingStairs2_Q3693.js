var climbStairsRecursion = function (n, costs) { // Recursion
    const dp = Array(n).fill(-1)

    function solve(i) {
        if (i >= n) return 0;

        if (dp[i] === -1) {
            let one = Infinity, two = Infinity, three = Infinity;

            let j = i + 1
            if (j <= n) one = solve(j) + costs[i] + ((j - i) ** 2);

            j = i + 2
            if (j <= n) two = solve(j) + costs[i + 1] + ((j - i) ** 2);

            j = i + 3
            if (j <= n) three = solve(j) + costs[i + 2] + ((j - i) ** 2);

            dp[i] = Math.min(one, two, three)
        }
        return dp[i]
    }
    solve(0)
    console.log(dp);
    return 
};

var climbStairs = function (n, costs) {
    const dp = Array(n+3).fill(0)
    for (let i = n - 1; i >= 0; i--) {
        let one = Infinity, two = Infinity, three = Infinity;
        let j = i + 1
        if (j <= n) one = dp[j] + costs[i] + ((j - i) ** 2);

        j = i + 2
        if (j <= n) two = dp[j] + costs[i + 1] + ((j - i) ** 2);

        j = i + 3
        if (j <= n) three = dp[j] + costs[i + 2] + ((j - i) ** 2);

        dp[i] = Math.min(one, two, three)
    }
    return dp[0]
};

let n, costs;

n = 4, costs = [1,2,3,4]
// n = 4, costs = [5,1,6,2]
// n = 3, costs = [9, 8, 3]
console.log(climbStairs(n, costs));