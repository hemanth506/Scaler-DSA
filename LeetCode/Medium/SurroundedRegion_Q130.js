var solve = function(board) {
    const n = board.length
    const m = board[0].length

    const visited = Array.from({length: n}, () => Array(m).fill(0))

    function dfs(i, j) {
        if(i === n || j === m || i < 0 || j < 0 || visited[i][j] === 0) {
            return;
        }

        visited[i][j] = 0

        dfs(i+1, j)
        dfs(i-1, j)
        dfs(i, j+1)
        dfs(i, j-1)
    }

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(board[i][j] === 'O') {
                visited[i][j] = 1 
            }
        }
    }

    for(let j = 0; j < m; j++) {
        if(visited[0][j] === 1) {
            dfs(0, j)
        }
    }

    for(let j = 0; j < m; j++) {
        if(visited[n-1][j] === 1) {
            dfs(n-1, j)
        }
    }

    for(let i = 0; i < n; i++) {
        if(visited[i][0] === 1) {
            dfs(i, 0)
        }
    }

    for(let i = 0; i < n; i++) {
        if(visited[i][m-1] === 1) {
            dfs(i, m-1)
        }
    }

    console.log(board);
    console.log(visited);

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(visited[i][j] === 1) {
                board[i][j] = 'X'
            }
        }
    }
    console.log(board);
}

let board;
board = [['X','X','X','O','X'], ['X','X','O','X','X'], ['X','O','O','X','X'], ['O','X','X','O','O'], ['X','X','O','X','X']]
surroundedRegion(board)