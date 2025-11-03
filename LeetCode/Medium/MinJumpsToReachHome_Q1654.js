var minimumJumpsTLE = function(forbidden, a, b, x) { // TLE approach failed in Testcase 95/96
    const forbidSet = new Set(forbidden)
    const dp = new Map()
    const LIMIT = 6000

    function solve(pos, posSet, direction) {
        if(pos === x) {
            return 0
        }

        if(forbidSet.has(pos) || pos < 0 || pos >= LIMIT) {
            return Infinity
        }

        const key = pos + "_"+ direction
        if(!dp.has(key)) {
            let forward = Infinity
            const inc = pos+a
            if(!posSet.has(inc)) {
                const fSet = new Set(posSet)
                fSet.add(inc)
                let fVal = solve(inc, fSet, 'forward')
                forward = fVal === Infinity ? Infinity : (fVal + 1)
            }

            let backward = Infinity
            const dec = pos-b
            if(!posSet.has(dec) && direction !== 'backward') {
                const bSet = new Set(posSet)
                bSet.add(dec)
                let bVal = solve(dec, bSet, 'backward')
                backward = bVal === Infinity ? Infinity : (bVal + 1)
            }

            dp.set(key, Math.min(forward, backward))
        }

        return dp.get(key)
    }

    const res = solve(0, new Set(), 'forward')
    console.log(res);

    return res === Infinity ? -1 : res
};

var minimumJumps = function(forbidden, a, b, x) { // optimized approach TC = O(Limit * 2), SC = O(1000 + (Limit * 2) + (Limit * 2))
    const LIMIT = 6000
    const forbidSet = new Set(forbidden)
    const dp = new Map()
    const visited = new Set()

    function solve(pos, direction) {
        if(pos === x) {
            return 0
        }

        if(forbidSet.has(pos) || pos < 0 || pos >= LIMIT) {
            return Infinity
        }

        const key = pos + "_"+ direction
        if(visited.has(key)) {
            return Infinity
        }
        visited.add(key)

        if(!dp.has(key)) {
            let fVal = solve(pos+a, 'forward')
            let forward = fVal === Infinity ? Infinity : (fVal + 1)

            let backward = Infinity
            if(direction !== 'backward') {
                let bVal = solve(pos-b, 'backward')
                if(bVal !== Infinity) {
                    backward =  bVal + 1
                }
            }

            dp.set(key, Math.min(forward, backward))
        }

        return dp.get(key)
    }

    const res = solve(0, 'forward')

    return res === Infinity ? -1 : res
};


let forbidden, a, b, x;

// forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
// forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
// forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
// forbidden = [15], a = 10, b = 5, x = 25
forbidden = [162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98]
a = 29
b = 98
x = 80
minimumJumps(forbidden, a, b, x)