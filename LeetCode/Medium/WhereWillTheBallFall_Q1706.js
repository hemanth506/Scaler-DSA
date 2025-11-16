var findBall = function(grid) {
    const n = grid.length
    const m = grid[0].length
    const res = []

    for(let col = 0; col < m; col++) {
        let i = 0, j = col
        while(true) {
            if(grid[i][j] === 1) {
                if (grid[i][j] === grid[i][j+1]) {
                    if((i+1) === n) {
                        res.push(j+1)
                        break
                    }
                    j++; i++;
                } else if (((j+1) < m && grid[i][j] != grid[i][j+1]) || ((j+1) === m)) {
                    res.push(-1)
                    break
                }
            } else {
                if (grid[i][j] === grid[i][j-1]) {
                    if((i+1) === n) {
                        res.push(j-1)
                        break
                    }
                    j--; i++;
                } else if (((j-1) >= 0 && grid[i][j] != grid[i][j-1]) || ((j-1) < 0)) {
                    res.push(-1)
                    break
                }
            }
        }
    }

    return res
};


let grid;
// grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
// grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
grid = [[-1]]

findBall(grid)