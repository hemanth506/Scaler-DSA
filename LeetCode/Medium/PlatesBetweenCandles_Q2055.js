var platesBetweenCandles = function(s, queries) {
    const n = s.length
    const m = queries.length
    const tableArr = s.split("")
    const hm = new Map()

    let plates = 0
    for(let i = 0; i < n; i++) {
        if(tableArr[i] === '*') {
            plates += 1
        } else {
            hm.set(i, plates)
        }
    }

    let prevCandle = -1, nextCandle = -1;
    const candlePos = Array.from({length: n}, () => Array(2).fill(-1))
    for(let i = 0, j = n - 1; i < n ; i++, j--) {
        if(tableArr[i] === '*') {
            candlePos[i][0] = prevCandle
        } else {
            prevCandle = i
        }

        if(tableArr[j] === '*') {
            candlePos[j][1] = nextCandle
        } else {
            nextCandle = j
        }
    }

    console.log(candlePos)
    const res = []
    for(let i = 0; i < m; i++) {
        const [left, right] = queries[i]
        let val
        if(tableArr[left] === '*' && tableArr[right] === '|') {
            val = Math.abs(hm.get(right) - hm.get(candlePos[left][1]))
        } else if (tableArr[left] === '|' && tableArr[right] === '*') {
            val = Math.abs(hm.get(left)- hm.get(candlePos[right][0]))
        } else if (tableArr[left] === '|' && tableArr[right] === '|') {
            val = Math.abs(hm.get(left) - hm.get(right))
        } else if (tableArr[left] === '*' && tableArr[right] === '*') {
            if(candlePos[left].join("_") === candlePos[right].join("_")) {
                val = 0
            } else {
                val = Math.abs(hm.get(candlePos[left][1]) - hm.get(candlePos[right][0]))
            }
        }
        res.push(val)
    }

    console.log(res)
    return res
};

let s, queries;

s = "**|**|***|", queries = [[2,5],[5,9]]
// s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]

console.log(platesBetweenCandles(s, queries))