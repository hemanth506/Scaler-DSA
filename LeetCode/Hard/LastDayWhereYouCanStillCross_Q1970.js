var latestDayToCross = function (row, col, cells) { // Binary search + DFS
    const grid = Array.from({ length: row }, () => Array(col).fill(0))
    const n = cells.length
    for (let i = 0; i < n; i++) {
        const [r, c] = cells[i]
        grid[r - 1][c - 1] = i + 1
    }

    function hasPath(day) {
        let visited = Array.from({ length: row }, () => Array(col).fill(false))
        function dfs(i, j) {
            if (i >= row || j >= col || i < 0 || j < 0 || visited[i][j] || grid[i][j] <= day) {
                return false
            }
            if (i === (row - 1)) return true;

            visited[i][j] = true;
            return dfs(i + 1, j) || dfs(i - 1, j) || dfs(i, j + 1) || dfs(i, j - 1)
        }

        for (let c = 0; c < col; c++) {
            if (dfs(0, c)) {
                return true
            }
        }
        return false;
    }

    let lastDay = -1, l = 1, h = n
    while (l <= h) {
        const m = Math.floor((l + h) / 2)
        if (hasPath(m)) {
            lastDay = m;
            l = m + 1
        } else {
            h = m - 1
        }
    }

    return lastDay
};

let row, col, cells;

row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
// row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
// row = 3, col = 3, cells = [[1, 2], [2, 1], [3, 3], [2, 2], [1, 1], [1, 3], [2, 3], [3, 2], [3, 1]]

console.log(latestDayToCross(row, col, cells));