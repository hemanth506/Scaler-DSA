var findLatestStep = function (arr, m) {
    const n = arr.length
    let latestStep = -1
    const endMap = new Map()
    const startMap = new Map()
    const sizeCount = new Map()

    function inc(ct) {
        sizeCount.set(ct, (sizeCount.get(ct) || 0) + 1)
    }

    function dec(ct) {
        sizeCount.set(ct, (sizeCount.get(ct) || 0) - 1)
    }


    for (let i = 0; i < n; i++) {
        const cur = arr[i] - 1
        const left = cur - 1
        const right = cur + 1
        let curCt, startVal, endVal
        if (!endMap.has(left) && !startMap.has(right)) {
            curCt = 1
            inc(curCt)

            startVal = endVal = cur
        } else if (endMap.has(left) && !startMap.has(right)) {
            const [start, ct] = endMap.get(left)
            dec(ct)
            
            startMap.delete(start)
            endMap.delete(left)

            curCt = ct + 1
            inc(curCt)

            startVal = start; endVal = cur
        } else if (!endMap.has(left) && startMap.has(right)) {
            const [end, ct] = startMap.get(right)
            dec(ct)

            endMap.delete(end)
            startMap.delete(right)

            curCt = ct + 1
            inc(curCt)

            startVal = cur; endVal = end
        } else {
            const [end, endCt] = startMap.get(right)
            const [start, startCt] = endMap.get(left)
            dec(endCt)
            dec(startCt)

            startMap.delete(right)
            endMap.delete(right)
            endMap.delete(left)
            startMap.delete(left)

            curCt = endCt + startCt + 1
            inc(curCt)

            startVal = start; endVal = end
        }
        
        startMap.set(startVal, [endVal, curCt])
        endMap.set(endVal, [startVal, curCt])

        if (sizeCount.get(m) > 0) {
            latestStep = i + 1
        }
    }

    return latestStep
};

let arr, m

arr = [3,5,1,2,4], m = 1
// arr = [3,1,5,4,2], m = 2
// arr = [2, 1], m = 2

console.log(findLatestStep(arr, m))