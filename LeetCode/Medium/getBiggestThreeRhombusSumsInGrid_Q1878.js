var getBiggestThree = function(grid) {
    const n = grid.length;
    const m = grid[0].length;
    const hs = new Set();

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            hs.add(grid[i][j]);
        }
    }

    for (let dist = 1; ; dist++) {
        if (dist > n - 1) break;
        if (2 * dist > m - 1) break;

        for (let i = dist; i + dist < n; i++) {
            for (let j = 0; j + 2 * dist < m; j++) {

                const ei = i, ej = j; 
                const ni = i - dist, nj = j + dist;
                const wi = i, wj = j + 2 * dist;
                const si = i + dist, sj = j + dist;

                if (ni < 0 || si >= n || wj >= m || sj >= m) continue;

                let sum = 0;

                for (let k = 0; k <= dist; k++) {
                    const x = ei - k;
                    const y = ej + k;
                    sum += grid[x][y];
                }

                for (let k = 0; k <= dist; k++) {
                    const x = ni + k;
                    const y = nj + k;
                    sum += grid[x][y];
                }

                for (let k = 0; k <= dist; k++) {
                    const x = wi + k;
                    const y = wj - k;
                    sum += grid[x][y];
                }

                for (let k = 0; k <= dist; k++) {
                    const x = si - k;
                    const y = sj - k;
                    sum += grid[x][y];
                }

                let edges = grid[ei][ej] +  grid[ni][nj] + grid[wi][wj] + grid[si][sj];
                sum -= edges
                hs.add(sum);
            }
        }
    }
    const arr = [...hs].sort((a,b) => b - a);
    return arr.slice(0, 3);
};




let grid;

grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]

getBiggestThree(grid)

