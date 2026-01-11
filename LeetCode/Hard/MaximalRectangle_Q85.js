var maximalRectangleTLE = function (matrix) {
    const n = matrix.length
    const m = matrix[0].length
    const prefix = Array.from({ length: n }, () => Array(m).fill(0))
    for (let i = 0; i < n; i++) {
        prefix[i][0] = Number(matrix[i][0])
        for (let j = 1; j < m; j++) {
            prefix[i][j] = Number(matrix[i][j]) + prefix[i][j - 1]
        }
    }

    for (let j = 0; j < m; j++) {
        prefix[0][j] = prefix[0][j]
        for (let i = 1; i < n; i++) {
            prefix[i][j] += prefix[i - 1][j]
        }
    }

    console.log(prefix);
    let max = 0
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            for (let x = 0; x <= i; x++) {
                for (let y = 0; y <= j; y++) {
                    const toBe = (i - x + 1) * (j - y + 1)
                    let actual = prefix[i][j]
                    if ((y - 1) >= 0) {
                        actual -= prefix[i][y - 1]
                    }
                    if ((x - 1) >= 0) {
                        actual -= prefix[x - 1][j]
                    }
                    if ((y - 1) >= 0 && (x - 1) >= 0) {
                        actual += prefix[x - 1][y - 1]
                    }
                    if (toBe === actual) {
                        max = Math.max(max, toBe)
                    }
                }
            }
        }
    }
    return max
};

var maximalRectangle = function (matrix) {
    const n = matrix.length
    const m = matrix[0].length
    function getMinLeft(arr) {
        const leftMinArr = Array(m).fill(-1)
        const stk = []
        for (let i = 0; i < m; i++) {
            while (stk.length > 0 && arr[stk.at(-1)] >= arr[i]) {
                stk.pop()
            }
            if (stk.length > 0) {
                leftMinArr[i] = stk.at(-1)
            }
            stk.push(i)
        }
        return leftMinArr
    }

    function getMinRight(arr) {
        const rightMinArr = Array(m).fill(m)
        const stk = []
        for (let i = m - 1; i >= 0; i--) {
            while (stk.length > 0 && arr[stk.at(-1)] >= arr[i]) {
                stk.pop()
            }
            if (stk.length > 0) {
                rightMinArr[i] = stk.at(-1)
            }
            stk.push(i)
        }
        return rightMinArr
    }

    function calculateMaxRectangle(arr) {
        console.log(arr);
        const minLeft = getMinLeft(arr)
        const minRight = getMinRight(arr)
        let max = 0
        for (let i = 0; i < m; i++) {
            const len = minRight[i] - minLeft[i] - 1
            let mat = len * arr[i]
            max = Math.max(max, mat)
        }
        return max
    }


    const prefix = Array.from({ length: 2 }, () => Array(m).fill(0))
    let maxMatrix = 0
    prefix[0] = [...matrix[0]].map(Number)
    let getMaxRect = calculateMaxRectangle(prefix[0])
    maxMatrix = Math.max(maxMatrix, getMaxRect)
    console.log(prefix[0])
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < m; j++) {
            prefix[1][j] = matrix[i][j] === '0' ? 0 : prefix[0][j] + Number(matrix[i][j])
        }
        getMaxRect = calculateMaxRectangle(prefix[1])
        maxMatrix = Math.max(maxMatrix, getMaxRect)
        prefix[0] = [...prefix[1]]
        prefix[1].fill(0)
    }
    return maxMatrix
}
let matrix;
// matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]
matrix = [["1"]]
console.log(maximalRectangle(matrix));