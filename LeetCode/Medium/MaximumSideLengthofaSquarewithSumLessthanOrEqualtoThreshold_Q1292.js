var maxSideLength = function (mat, threshold) {
    const n = mat.length
    const m = mat[0].length

    for (let i = 0; i < n; i++) {
        for (let j = 1; j < m; j++) {
            mat[i][j] += mat[i][j - 1]
        }
    }

    for (let j = 0; j < m; j++) {
        for (let i = 1; i < n; i++) {
            mat[i][j] += mat[i - 1][j]
        }
    }

    function check(side) {
        let idxSide = side - 1
        for (let i = idxSide; i < n; i++) {
            for (let j = idxSide; j < m; j++) {

                let left = (i - side) >= 0 ? mat[i - side][j] : 0
                let top = (j - side) >= 0 ? mat[i][j - side] : 0
                let cross = ((i - side) >= 0 && (j - side) >= 0) ? mat[i - side][j - side] : 0

                let curSum = mat[i][j] - left - top + cross
                if(curSum <= threshold) {
                    return true
                }
            }
        }
        return false
    }

    let l = 1, h = Math.min(n, m), side = 0
    while (l <= h) {
        let m = Math.floor((l + h) / 2)
        if (check(m)) {
            side = m
            l = m + 1
        } else {
            h = m - 1
        }
    }

    return side
};

let mat, threshold;
// mat = [[1, 1, 3, 2, 4, 3, 2], [1, 1, 3, 2, 4, 3, 2], [1, 1, 3, 2, 4, 3, 2]], threshold = 4
mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
console.log(maxSideLength(mat, threshold));