var stoneGameII = function(piles) {
    const n = piles.length
    const dp = Array.from({length: 3}, () => new Map())
    console.log('dp', dp)
    
    function solve(i, j, M) {
        if(j >= n) {
            return 0
        }

        const str = i+"_"+j+"_"+M
        console.log('str', str)
        if(!dp[i].has(str)) {
            const times = Math.min(j + (M * 2), n)
            let sum = 0, maxVal = i === 1 ? -Infinity : Infinity
            for(let k = 0; k + j < times; k++) {
                sum += piles[j + k]
                if(i === 1) {
                    maxVal = Math.max(maxVal, solve(3-i, j + k + 1, Math.max(k+1, M)) + sum)
                } else {
                    maxVal = Math.min(maxVal, solve(3-i, j + k + 1, Math.max(k+1, M)))
                }
            }
            dp[i].set(str, maxVal)
        }
        return dp[i].get(str)
    }

    const res = solve(1, 0, 1)
    console.log("dp", dp)
    console.log('res', res)
    return res
};
let piles;

// piles = [2,7,9,4,4]
piles = [1,2,3,4,5,100]

stoneGameII(piles)