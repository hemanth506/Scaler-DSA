var tictactoe = function(moves) {
    const grid = Array.from({length: 3}, () => Array(3).fill(" "))

    function validateRow() {
        for(let i = 0; i < 3; i++) {
            if(grid[i][0] === "") {
                continue
            }
            let curChar = grid[i][0]
            if(curChar === grid[i][1] && curChar === grid[i][2]) {
                return [true, curChar]
            }
        }
        return [false, '']
    }

    function validateColumn() {
        for(let i = 0; i < 3; i++) {
            if(grid[0][i] === " ") {
                continue
            }
            let curChar = grid[0][i]
            if(curChar === grid[1][i] && curChar === grid[2][i]) {
                return [true, curChar]
            }
        }
        return [false, '']
    }

    function validateDiagonal() {
        if(grid[0][0] !== " ")
        if(grid[0][0] === grid[1][1] && grid[0][0] === grid[2][2]) {
            return [true, grid[0][0]]
        }

        if(grid[0][2] === grid[1][1] && grid[0][2] === grid[2][0]) {
            return [true, grid[0][2]]
        }
        return [false, '']
    }
    
    for(let i = 0; i < moves.length; i++) {
        if(i % 2 === 0) {
            grid[moves[i][0]][moves[i][1]] = 'X'
        } else {
            grid[moves[i][0]][moves[i][1]] = 'O'
        }
    }

    console.log('grid', grid)

    const [rResult, rChar] = validateRow()
    if(rResult === true) {
        return rChar === 'X' ? 'A' : 'B'
    }
    console.log('Check 1')
    const [cResult, cChar] = validateColumn()
    if(cResult === true) {
        return cChar === 'X' ? 'A' : 'B'
    }
    console.log('Check 2')
    const [dResult, dChar] = validateDiagonal()
    if(dResult === true) {
        return dChar === 'X' ? 'A' : 'B'
    }
    console.log('Check 3')

    return 'DRAW'
};

let moves;

moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]

console.log(tictactoe(moves))