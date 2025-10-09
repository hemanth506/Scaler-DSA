var coinChange = function(coins, amount) {
    const n = coins.length
    const dp = new Map()

    function solve(i, amt) {
        if(amt === amount) {
            return 0
        }

        if(amt > amount || i === n) {
            return Infinity
        }

        const str = i+"_"+amt
        if(!dp.has(str)) {
            const leave = solve(i+1, amt)
            const pick = solve(i, amt + coins[i]) + 1
            const val = Math.min(pick, leave)
            dp.set(str, val)
        }
        return dp.get(str)
    }

    const result = solve(0, 0)
    return result === Infinity ? -1 : result
};

let coins, amount
// coins = [1,2,5], amount = 11
// coins = [2], amount = 3
coins = [1], amount = 0

console.log(coinChange(coins, amount))