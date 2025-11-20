var combinationSum2DP = function(candidates, target) { // DP => TC = O(2^n * n), SC = O(2^n * n)
    const n = candidates.length
    const hs = new Set()
    const dp = new Set()
    const finalArr = []

    const solve = function (i, sum, arr) {
        if(sum === target) {
            let str = arr.join('_')
            if(!hs.has(str)) {
                finalArr.push(arr)
                hs.add(str)
            }
            return
        }

        if((sum > target) || (i === n)) {
            return
        }

        const key = i + "_" + sum + '_' + arr.join('_');
        if(!dp.has(key)) {
            solve(i+1, sum, arr)
            const tempArr = [...arr]
            tempArr.push(candidates[i])
            solve(i+1, sum + candidates[i], tempArr)

            dp.add(key)
        }

        return
    }
    candidates.sort((a,b) => a - b)
    solve(0, 0, [])
    return finalArr
};


var combinationSum2 = function(candidates, target) { // Backtracking => TC = O(2^n * n), SC = O(n)
    const n = candidates.length
    const finalArr = []

    const solve = function (start, sum, arr) {
        if(sum === target) {
            finalArr.push([...arr])
            return
        }

        if(sum > target) {
            return
        }

        for (let i = start; i < n; i++) {
            if(i > start && candidates[i] === candidates[i-1]) continue;

            arr.push(candidates[i])
            solve(i+1, sum + candidates[i], arr)
            arr.pop()
        }

        return
    }
    candidates.sort((a,b) => a - b)
    solve(0, 0, [])
    return finalArr
};



let candidates, target;

candidates = [10,1,2,7,6,1,5], target = 8
// candidates = [2,5,2,1,2], target = 5

console.log(combinationSum2DP2(candidates, target));