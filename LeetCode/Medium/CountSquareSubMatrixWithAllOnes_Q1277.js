var countSquares = function (matrix) {
    const n = matrix.length
    const m = matrix[0].length
    const maxMatrixSize = Math.min(n, m)
    const prefixSum = Array.from({ length: n }, () => Array(m).fill(0))

    for (let i = 0; i < n; i++) {
        prefixSum[i][0] = matrix[i][0]
        for (let j = 1; j < m; j++) {
            prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j]
        }
    }

    for (let j = 0; j < m; j++) {
        for (let i = 1; i < n; i++) {
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j]
        }
    }

    console.log(prefixSum)
    let count = 0
    for (let i = 1; i <= maxMatrixSize; i++) {
        const requiredSum = i * i
        console.log('-------', requiredSum, '-------')
        for (let r = 0; r < n; r++) {
            for (let c = 0; c < m; c++) {
                const row = r, col = c
                if((row + i - 1) >= n || (col + i - 1) >= m) {
                    continue
                }
                const dest = [row + i - 1, col + i - 1]
                const br = (dest[0] >= n) || (dest[1] >= m) ? 0 : prefixSum[dest[0]][dest[1]]
                const bl = (dest[1] - i) < 0 ? 0 : prefixSum[dest[0]][dest[1] - i]
                const tr = (dest[0] - i) < 0 ? 0 : prefixSum[dest[0] - i][dest[1]]
                const tl = (row - 1) < 0 || (col - 1) < 0 ? 0 : prefixSum[row - 1][col - 1]
                
                const val = br - bl - tr + tl
                console.log('row', row, 'col', col, 'dest', dest, 'val', val, 'br', br, 'bl', bl, 'tr', tr, 'tl', tl)
                if(val === requiredSum) {
                    console.log('matching')
                    count += 1
                }

            }
        }
    }
    console.log('count', count)
    return count

};

let matrix

// matrix = [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]

matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]

countSquares(matrix)