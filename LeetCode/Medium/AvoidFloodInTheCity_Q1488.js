var avoidFloodOld = function(rains) {
    const n = rains.length
    const stack = []
    const filledLakes = new Set()
    const res = []

    for(let i = 0; i < n; i++) {
        if(rains[i] === 0) {
            if(stack.length > 0) {
                const driedLake = stack.pop()
                res.push(driedLake)
                filledLakes.delete(driedLake)
            } else {
                res.push(1)
            }
        } else {
            if(filledLakes.has(rains[i])) {
                return []
            } else {
                stack.push(rains[i])
                res.push(-1)
                filledLakes.add(rains[i])
            }
        }
    }

    return res
};


var avoidFlood = function(rains) {
    const n = rains.length
    const filledLakes = new Map()
    const ans = Array(n).fill(1)
    const sunnyDay = []

    for(let i = 0; i < n; i++) {
        const lake = rains[i]
        if(lake === 0) {
            sunnyDay.push(i)
        } else {
            if(filledLakes.has(lake)) {
                const lastRainDay = filledLakes.get(lake)
                let dryDayIdx = -1
                for(let j = 0; j < sunnyDay.length; j++) {
                    if(lastRainDay < sunnyDay[j]) {
                        dryDayIdx = j
                        break
                    }
                }
                if(dryDayIdx === -1) {
                    return []
                }
                const dryDay = sunnyDay[dryDayIdx]
                ans[dryDay] = lake
                sunnyDay.splice(dryDayIdx, 1)
            }
            ans[i] = -1
            filledLakes.set(lake, i)
        }
    }
    return ans
}


let rains

// rains = [1,2,3,4]
// rains = [1,2,0,0,2,1]
// rains = [1,2,0,1,2]
// rains = [69,0,0,0,69]
// rains = [1,2,3,0,0,2,0,3,1]
rains = [0,1,1]

console.log(avoidFlood(rains))