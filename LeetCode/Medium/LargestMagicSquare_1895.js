var largestMagicSquare = function (grid) {
    const n = grid.length
    const m = grid[0].length

    function isValid(bri, brj, tli, tlj, k) {
        let sum = null
        for (let iter = 0; iter <= k; iter++) {
            let curSum = 0
            for (let idx = tlj; idx <= brj; idx++) { curSum += grid[tli + iter][idx]; }
            if (sum !== null && curSum !== sum) { return false }
            sum = curSum
        }

        for (let iter = 0; iter <= k; iter++) {
            let curSum = 0
            for (let idx = tli; idx <= bri; idx++) { curSum += grid[idx][tlj + iter] }
            if (curSum !== sum) { return false }
            sum = curSum
        }

        let cross1 = 0
        for (let iter = 0; iter <= k; iter++) { cross1 += grid[tli + iter][tlj + iter] }
        if (cross1 !== sum) { return false }

        let cross2 = 0
        for (let iter = 0; iter <= k; iter++) { cross2 += grid[tli + iter][brj - iter] }
        return cross2 === sum
    }


    let maxK = 1
    for (let k = 1; k <= Math.min(n, m); k++) {
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                if ((i - k) >= 0 && (j - k) >= 0 && isValid(i, j, i - k, j - k, k)) {
                    maxK = Math.max(maxK, k + 1)
                }
            }
        }
    }
    return maxK
};
let grid;

// grid = [[7, 1, 4, 5, 6], [2, 5, 1, 6, 4], [1, 5, 4, 3, 2], [1, 2, 7, 3, 4]]
grid = [[5, 1, 3, 1], [9, 3, 3, 1], [1, 3, 3, 8]]

console.log(largestMagicSquare(grid));