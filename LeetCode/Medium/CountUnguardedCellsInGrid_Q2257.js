var countUnguarded = function (n, m, guards, walls) {
    const grid = Array.from({ length: n }, () => Array.from({ length: m }, () => Array(4).fill(false)))
    const guardWallSet = new Set([...guards.map((a) => a[0] + "_" + a[1]), ...walls.map((a) => a[0] + "_" + a[1])])
    const guarded = new Set()
    for (let guard of guards) {
        let [x, y] = guard

        for (let d = x + 1; d < n; d++) {
            const key = d + "_" + y
            if (guardWallSet.has(key) || grid[d][y][0] === true) break;
            grid[d][y][0] = true;
            guarded.add(key);
        }

        for (let u = x - 1; u >= 0; u--) {
            const key = u + "_" + y
            if (guardWallSet.has(key) || grid[u][y][1] === true) break;
            grid[u][y][1] = true;
            guarded.add(key);
        }

        for (let r = y + 1; r < m; r++) {
            const key = x + "_" + r
            if (guardWallSet.has(key) || grid[x][r][2] === true) break;
            grid[x][r][2] = true;
            guarded.add(key);
        }

        for (let l = y - 1; l >= 0; l--) {
            const key = x + "_" + l
            if (guardWallSet.has(key) || grid[x][l][3] === true) break;
            grid[x][l][3] = true;
            guarded.add(key);
        }
    }

    return (n * m) - guarded.size - guardWallSet.size;
};


let n, m, guards, walls;

m = 4, n = 6, guards = [[0, 0], [1, 1], [2, 3]], walls = [[0, 1], [2, 2], [1, 4]]
// m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
console.log(countUnguarded(m, n, guards, walls));