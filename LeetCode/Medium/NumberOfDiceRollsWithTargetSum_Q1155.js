var numRollsToTarget = function(n, k, target) {
    const dp = new Map()
    const MOD = 1000000007
    function solve(target, n) {
        if(target < 0) return 0;

        if(n === 0) {
            if(target === 0) return 1;
            return 0
        }
        const key = target+"_"+n
        if(!dp.has(key)) {
            let sum = 0
            for(let i = 1; i <= k; i++) {
                sum = (sum % MOD) + (solve(target - i, n - 1) % MOD)
            }
            dp.set(key, sum)
        }
        return dp.get(key) % MOD
    }
    return solve(target, n) % MOD
};

let n, k, target;
// n = 1, k = 6, target = 3
// n = 2, k = 6, target = 7
// n = 30, k = 30, target = 500
n = 20, k = 19, target = 233
console.log(numRollsToTarget(n, k, target));