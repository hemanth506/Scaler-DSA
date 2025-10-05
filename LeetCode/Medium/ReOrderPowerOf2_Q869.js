var reorderedPowerOf2 = function(n) {
    if(n <= 2) {
        return true
    }
    function getHm(tn) {
        const map = new Map()
        let mod = 10
        while (tn > 0) {
            let val = Math.floor(tn % mod)
            map.set(val, (map.get(val) || 0) + 1)
            tn = Math.floor(tn / mod)
        }

        return map
    }
    const actualMap = getHm(n)
    for(let i = 0; i < 30; i++) {
        const tempActualMap = new Map(actualMap)
        console.log(tempActualMap)
        const curVal = 2 << i
        console.log('curVal', curVal)
        const curMap = getHm(curVal)

        for(let [key, value] of tempActualMap.entries()) {
            if(curMap.has(key)) {
                if(curMap.get(key) !== value) {
                    break
                } else {
                    curMap.delete(key)
                    tempActualMap.delete(key)
                }
            } else {
                break
            }
        }

        console.log(tempActualMap, curMap)
        if(tempActualMap.size === 0 && curMap.size === 0) {
            return true
        }
    }

    return false
};


let n

n = 1

console.log(reorderedPowerOf2(n))