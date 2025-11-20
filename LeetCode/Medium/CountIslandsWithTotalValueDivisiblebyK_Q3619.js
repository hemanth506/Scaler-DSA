var countIslands = function (grid, k) {
    const n = grid.length;
    const m = grid[0].length;
    const visited = Array.from({ length: n }, () => Array(m).fill(false));
    console.log(visited);

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (grid[i][j] === 0) {
                visited[i][j] = true
            }
        }
    }

    const dfs = function (i, j) {
        if (i === n || j === m || i < 0 || j < 0 || visited[i][j] === true) {
            return 0
        }

        visited[i][j] = true
        let sum = grid[i][j]
        sum += dfs(i + 1, j)
        sum += dfs(i - 1, j)
        sum += dfs(i, j + 1)
        sum += dfs(i, j - 1)

        return sum
    }

    let ct = 0
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (!visited[i][j]) {
                let res = dfs(i, j)
                if (res % k === 0) {
                    ct++
                }
            }
        }
    }

    return ct
};


let grid, k;
grid = [[0, 2, 1, 0, 0], [0, 5, 0, 0, 5], [0, 0, 1, 0, 0], [0, 1, 4, 7, 0], [0, 2, 0, 0, 8]], k = 5
grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3
console.log(countIslands(grid, k));