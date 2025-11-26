var numberOfPaths = function (grid, k) { // TC = O(N * M * K), SC = O(N * M * K)
    const n = grid.length
    const m = grid[0].length
    const dp = Array.from({ length: n }, () => Array.from({ length: m }, () => Array(k).fill(-1)))
    const MOD = 1000000007
    function solve(i, j, sum) {
        if ((i === n - 1) && (j === m - 1)) {
            sum += grid[i][j]
            if ((sum % k) === 0) {
                return 1
            }
            return 0
        }
        if ((i >= n) || (j >= m)) {
            return 0
        }

        if (dp[i][j][sum] === -1) {
            const down = solve(i + 1, j, (sum + grid[i][j]) % k)
            const right = solve(i, j + 1, (sum + grid[i][j]) % k)
            const ct = (down + right) % MOD
            dp[i][j][sum] = ct
        }
        return dp[i][j][sum];
    }

    return solve(0, 0, 0)
};

let grid, k;

grid = [[5, 2, 4], [3, 0, 5], [0, 7, 2]], k = 3
// grid = [[0,0]], k = 5
// grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1

console.log(numberOfPaths(grid, k));