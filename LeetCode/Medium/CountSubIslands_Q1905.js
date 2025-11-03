var countSubIslands = function(grid1, grid2) {
    const n = grid1.length
    const m = grid1[0].length
    const visited = Array.from({length: n}, () => Array(m).fill(false))

    function dfs(i, j) {
        if(i === n || j === m || i < 0 || j < 0 || grid2[i][j] === 0 || visited[i][j] === true) {
            return true
        }
        
        visited[i][j] = true

        let isSub = true
        if(grid1[i][j] === 0) {
            isSub =  false
        }

        let top = dfs (i - 1, j)
        let bottom = dfs (i + 1, j)
        let left = dfs (i, j - 1)
        let right = dfs (i, j + 1)

        return isSub && top && bottom && left && right 
    }

    let ct = 0
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(grid2[i][j] === 1 && visited[i][j] === false) {
                if(dfs(i, j)) {
                    ct++;
                }
            }
        }
    }

    return ct
};

let grid1, grid2

// grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]

console.log(countSubIslands(grid1, grid2));