var maxPartitionsAfterOperations = function(s, k) {
    const n = s.length
    const dpMap = new Map()
    const aCode = 'a'.charCodeAt(0)

    function countBit(mask) {
        let ct = 0
        while(mask > 0) {
            if((mask & 1) === 1) {
                ct += 1
            }
            mask = mask >> 1
        }
        return ct
    }

    function solve(i, bitMask, canChange) {
        if(i === n) {
            return 1
        }

        const key = i+"_"+bitMask+"_"+canChange
        if(!dpMap.has(key)) {
            let maxCt = -Infinity
            let pos = s[i].charCodeAt(0) - aCode
            let newMask = bitMask | (1 << pos)
            let bitCt = countBit(newMask)
            if(bitCt > k) {
                maxCt = Math.max(maxCt, 1 + solve(i+1, (1 << pos), canChange))
            } else {
                maxCt = Math.max(maxCt, solve(i+1, newMask, canChange))
            }

            if(canChange === 1) {
                for(let p = 0; p < 26; p++) {
                    let mask = bitMask | (1 << p)
                    let innerBitCt = countBit(mask)
                    if(innerBitCt > k) {
                        maxCt = Math.max(maxCt, 1 + solve(i+1, (1 << p), 0))
                    } else {
                        maxCt = Math.max(maxCt, solve(i+1, mask, 0))
                    }
                }
            }
            dpMap.set(key, maxCt)
        }

        return dpMap.get(key)
    }
    
    return solve(0, 0, 1)
};

let s, k;

s = "accca", k = 2


console.log(maxPartitionsAfterOperations(s, k));