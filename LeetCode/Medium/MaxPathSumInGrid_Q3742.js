var maxPathScore = function (grid, k) { // TLE -> Recursive approach
    const n = grid.length
    const m = grid[0].length
    const dp = new Map()
    const cost = [0, 1, 1]
    let reached = false

    function solve(i, j, c) {
        if (i >= n || j >= m) return -Infinity;
        if (c < cost[grid[i][j]]) return -Infinity
        if (i === (n - 1) && j === (m - 1)) {
            reached = true;
            return grid[i][j];
        }

        const key = `${i}_${j}_${c}`
        if (!dp.has(key)) {
            if (c >= cost[grid[i][j]]) {
                let r = solve(i, j + 1, c - cost[grid[i][j]]) + grid[i][j]
                let d = solve(i + 1, j, c - cost[grid[i][j]]) + grid[i][j]
                if (r === d && r === -Infinity) {
                    dp.set(key, r)
                } else {
                    dp.set(key, Math.max(r, d))
                }
            }
        }
        return dp.get(key)
    }

    const res = solve(0, 0, k)
    console.log(res, reached);
    return !reached ? -1 : res;
};

var maxPathScore = function (grid, k) { // iterative approach
    const n = grid.length;
    const m = grid[0].length;
    const cost = [0, 1, 1];

    const dpArr = Array.from({ length: n }, () =>
        Array.from({ length: m }, () =>
            Array(k + 1).fill(-Infinity)
        )
    );

    for (let c = cost[grid[n - 1][m - 1]]; c <= k; c++) {
        dpArr[n - 1][m - 1][c] = grid[n - 1][m - 1];
    }

    // Fill DP bottom-up
    for (let i = n - 1; i >= 0; i--) {
        for (let j = m - 1; j >= 0; j--) {
            for (let c = 0; c <= k; c++) {

                if (i === n - 1 && j === m - 1) continue; // skip base cell

                if (c < cost[grid[i][j]]) {
                    dpArr[i][j][c] = -Infinity;
                    continue;
                }

                const reducedCost = c - cost[grid[i][j]];

                let r = -Infinity, d = -Infinity;

                if (j + 1 < m && dpArr[i][j + 1][reducedCost] !== -Infinity) {
                    r = dpArr[i][j + 1][reducedCost] + grid[i][j];
                }

                if (i + 1 < n && dpArr[i + 1][j][reducedCost] !== -Infinity) {
                    d = dpArr[i + 1][j][reducedCost] + grid[i][j];
                }

                dpArr[i][j][c] = Math.max(r, d);
            }
        }
    }

    const result = dpArr[0][0][k];
    return result === -Infinity ? -1 : result;

};

let grid, k;
// grid = [[0, 1], [2, 0]], k = 1
// grid = [[0, 1], [1, 2]], k = 1
// grid = [[0, 1, 0], [2, 2, 0], [1, 0, 0]], k = 1
// grid = [[0, 1, 0], [2, 0, 0], [1, 0, 0]], k = 1
grid = [[0, 1, 0], [2, 2, 0], [1, 0, 0]], k = 2
// grid = [[0, 1, 1, 1, 0], [0, 1, 0, 2, 0], [0, 1, 2, 2, 1], [1, 0, 0, 2, 0], [2, 0, 1, 1, 2], [2, 1, 0, 2, 2], [1, 0, 0, 0, 1], [1, 2, 2, 1, 0], [2, 0, 0, 0, 0], [0, 1, 2, 2, 0], [1, 0, 2, 1, 2], [0, 1, 1, 1, 2], [0, 0, 2, 1, 1], [0, 1, 1, 1, 2], [1, 0, 0, 0, 1], [2, 0, 1, 0, 0], [2, 1, 0, 2, 2], [2, 1, 2, 0, 2], [1, 1, 2, 2, 2], [1, 2, 2, 0, 0], [0, 0, 1, 0, 2], [0, 1, 2, 2, 0], [0, 1, 2, 1, 1], [2, 2, 0, 2, 2], [1, 0, 1, 0, 0], [0, 1, 2, 1, 1], [1, 2, 2, 2, 0], [1, 2, 2, 2, 0], [0, 1, 2, 0, 2], [2, 1, 2, 2, 0], [1, 0, 0, 1, 2], [1, 2, 1, 2, 0], [2, 1, 2, 2, 0], [2, 2, 1, 1, 1], [0, 1, 1, 1, 0], [2, 1, 2, 1, 1], [2, 2, 2, 1, 2], [0, 0, 1, 2, 2], [1, 2, 2, 1, 0], [2, 1, 0, 1, 2], [1, 2, 0, 1, 1], [0, 1, 2, 1, 2], [0, 0, 0, 0, 2], [1, 0, 1, 2, 2], [0, 2, 2, 0, 1], [2, 0, 1, 2, 0], [2, 0, 0, 1, 1], [2, 0, 0, 0, 0], [2, 2, 0, 0, 0], [1, 1, 1, 2, 0], [0, 2, 0, 1, 1], [2, 1, 0, 1, 0], [2, 1, 2, 0, 0], [1, 2, 0, 2, 1], [2, 2, 1, 2, 2], [1, 0, 1, 0, 2], [1, 0, 0, 2, 1], [1, 2, 0, 1, 0], [2, 1, 2, 2, 0], [2, 0, 2, 0, 1], [1, 1, 1, 1, 0], [1, 0, 2, 2, 0], [1, 2, 0, 2, 1], [0, 1, 0, 0, 2], [0, 1, 0, 1, 2], [0, 1, 1, 0, 0]],
//     k = 43




maxPathScore(grid, k)
