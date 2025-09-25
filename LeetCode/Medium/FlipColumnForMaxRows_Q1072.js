var maxEqualRowsAfterFlips = function(matrix) { // TC: O(n * m)
    const n = matrix.length
    const m = matrix[0].length
    const hm = new Map()

    for(let i = 0; i < n; i++) {
        let key = ""
        for(let j = 0; j < m; j++) {
            if(matrix[i][0] === 1) {
                key += "" + (1 - matrix[i][j])
            } else {
                key += "" + matrix[i][j]
            }
        }
        hm.set(key, (hm.get(key) || 0) + 1)
    }


    let maxVal = -Infinity
    for(let values of hm.values()) {
        maxVal = Math.max(maxVal, values)
    }

    return maxVal
}