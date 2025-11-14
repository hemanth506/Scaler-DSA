var minCostRecursion = function (n, m, waitCost) {
    const dp = Array.from({ length: n }, () => Array(m).fill(-1))

    function solve(i, j) {
        if (i === n || j === m) {
            return Infinity
        }

        if (i === (n - 1) && j === (m - 1)) {
            return (i + 1) * (j + 1)
        }

        if (dp[i][j] === -1) {

            let ec = (i + 1) * (j + 1)

            let r = solve(i, j + 1)
            let d = solve(i + 1, j)

            let wc = (i === 0 && j === 0) ? 0 : waitCost[i][j];
            dp[i][j] = Math.min(r, d) + ec + wc;
        }

        return dp[i][j]
    }
    return solve(0, 0)
};

var minCost = function (n, m, waitCost) { // Iterative
    const dp = Array.from({ length: n }, () => Array(m).fill(-1))

    for (let i = n - 1; i >= 0; i--) {
        for (let j = m - 1; j >= 0; j--) {
            let ec = (i + 1) * (j + 1)

            if (i === (n - 1) && j === (m - 1)) {
                dp[i][j] = ec
            } else {
                let r = ((j + 1) === m) ? Infinity : dp[i][j + 1]
                let d = ((i + 1) === n) ? Infinity : dp[i + 1][j]

                let wc = (i === 0 && j === 0) ? 0 : waitCost[i][j];
                dp[i][j] = Math.min(r, d) + ec + wc;
            }
        }
    }
    return dp[0][0]
};

let m, n, waitCost;
// m = 1, n = 2, waitCost = [[1, 2]]
// m = 2, n = 2, waitCost = [[3, 5], [2, 4]]
m = 2, n = 3, waitCost = [[6,1,4],[3,2,5]]

minCost(m, n, waitCost)