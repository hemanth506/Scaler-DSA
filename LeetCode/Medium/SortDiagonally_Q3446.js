var sortMatrix = function(grid) {
    const n = grid.length
    console.log(grid)

    // middle
    let arr = []
    for(let i = 0; i < n; i++) {
        arr.push(grid[i][i])
    }
    arr.sort((a,b) => b - a)
    for(let i = 0; i < n; i++) {
        grid[i][i] = arr[i]
    }

    // bottom
    for(let i = 1; i < n; i++) {
        let j = 0, k = i
        let bottom = []
        while(k < n) {
            bottom.push(grid[k][j])
            k++, j++
        }
        bottom.sort((a,b) => b - a)

        j = 0, k = i, bn = bottom.length, bi = 0
        while(bi < bn) {
            grid[k][j] = bottom[bi]
            k++, j++, bi++
        }
    }

    // upper
    for(let i = 1; i < n; i++) {
        let j = 0, k = i
        let bottom = []
        while(k < n) {
            bottom.push(grid[j][k])
            k++, j++
        }
        bottom.sort((a,b) => a - b)

        j = 0, k = i, bn = bottom.length, bi = 0
        while(bi < bn) {
            grid[j][k] = bottom[bi]
            k++, j++, bi++
        }
    }

    console.log(grid)
    return grid
};
let grid;

grid = [[1,7,3],[9,8,2],[4,5,6]]

sortMatrix(grid)

/**
 * [ [ 1, 7, 3 ], 
 *   [ 9, 8, 2 ], 
 *   [ 4, 5, 6 ] ]
 */


/**
 * [ [ 8, 2, 3 ], 
 *   [ 9, 6, 7 ], 
 *   [ 4, 5, 1 ] ]
 */