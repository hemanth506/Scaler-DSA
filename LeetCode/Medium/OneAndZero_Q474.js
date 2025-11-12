var findMaxForm = function(strs, m, n) {
    const len = strs.length
    strs.sort((a,b) => a.length - b.length)

    const strCtArr = Array.from({length: len}, () => Array(2).fill(0))
    for(let idx = 0; idx < len; idx++) {
        for(let i = 0; i < strs[idx].length; i++) {
            const charNum = Number(strs[idx][i])
            strCtArr[idx][charNum]++
        }
    }

    let ct = 0
    for(let idx = 0; idx < len; idx++) {
        if(strCtArr[idx][0] <= m && strCtArr[idx][1] <= n) {
            ct++
            m -= strCtArr[idx][0]
            n -= strCtArr[idx][1]
        }
    }
    console.log(ct);
    return ct
};

var findMaxForm = function(strs, m, n) {
    const len = strs.length

    const strCtArr = Array.from({length: len}, () => Array(2).fill(0))
    for(let idx = 0; idx < len; idx++) {
        for(let i = 0; i < strs[idx].length; i++) {
            const charNum = Number(strs[idx][i])
            strCtArr[idx][charNum]++
        }
    }

    const dp = new Map()

    function solve(i, iM, iN) {
        if(i === len || (iM === 0 && iN === 0)) {
            return 0;
        }
        

        const key = i + "_" + iM + "_" + iN
        if(!dp.has(key)) {
            const [zero, one] = strCtArr[i]
            let take = 0;
            if((iM - zero) >= 0 && (iN - one) >= 0) {
                take = solve(i + 1, iM - zero, iN - one) + 1
            }
            let skip = solve(i+1, iM, iN);
            let max = Math.max(take, skip)
            dp.set(key, max)
        }

        return dp.get(key)
    }

    const res = solve(0, m, n)
    console.log(res, dp);
    return res
}


let strs, m, n;

// strs = ["10","0001","111001","1","0"], m = 5, n = 3
// strs = ["10","0","1"], m = 1, n = 1
strs = ["00011","00001","00001","0011","111"], m = 8, n = 5

findMaxForm(strs, m, n)