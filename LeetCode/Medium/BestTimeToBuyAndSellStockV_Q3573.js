// TLE - Tried to solve using 2 states and inner loop
var maximumProfit = function (prices, k) { 
    const n = prices.length
    const dp = Array.from({ length: n }, () => Array.from({ length: 2 }, () => Array(k + 1).fill(-1)))

    function solve(i, state, k) {
        if (i >= n || k === 0) return 0;

        if (dp[i][state][k] === -1) {
            let stateMax = -Infinity
            const tempK = k - 1;
            if (state === 0) {
                const skipBuy = solve(i + 1, state, k)
                let maxBuy = -Infinity;
                for (let j = i + 1; j < n; j++) {
                    const profit = Math.abs(prices[j] - prices[i])
                    const curBuy = solve(j + 1, 1 - state, tempK) + profit
                    maxBuy = Math.max(maxBuy, curBuy)
                }
                stateMax = Math.max(maxBuy, skipBuy)
            } else {
                const skipSell = solve(i + 1, state, k)
                let maxSell = -Infinity;
                for (let j = i + 1; j < n; j++) {
                    const profit = Math.abs(prices[i] - prices[j])
                    const curSell = solve(j + 1, 1 - state, tempK) + profit
                    maxSell = Math.max(maxSell, curSell)
                }
                stateMax = Math.max(maxSell, skipSell)
            }
            dp[i][state][k] = stateMax
        }
        return dp[i][state][k]
    }

    return solve(0, 0, k)
};

// 3 states, [nothing, buy and shortSell], no inner loop.
var maximumProfit = function (prices, k) {
    const n = prices.length
    const dp = Array.from({ length: n }, () => Array.from({ length: 3 }, () => Array(k + 1).fill(-1)))

    function solve(i, state, k) {
        if (i === n) {
            return state === 0 ? 0 : -Infinity;
        }
        if (k === 0 && state !== 0) return -Infinity;

        if (dp[i][state][k] === -1) {
            let stateMax = -Infinity
            const nothing = solve(i + 1, state, k)

            if (state === 0) {
                const buy = solve(i + 1, 2, k) - prices[i]
                const shortSell = solve(i + 1, 1, k) + prices[i]
                stateMax = Math.max(nothing, buy, shortSell)
            } else if (state === 1) {
                const buy = solve(i + 1, 0, k - 1) - prices[i]
                stateMax = Math.max(nothing, buy)
            } else {
                const shortSell = solve(i + 1, 0, k - 1) + prices[i]
                stateMax = Math.max(nothing, shortSell)
            }
            dp[i][state][k] = stateMax
        }
        return dp[i][state][k]
    }

    return solve(0, 0, k)
};



let prices, k;

prices = [1, 7, 9, 8, 2], k = 2
prices = [12, 16, 19, 19, 8, 1, 19, 13, 9], k = 3
// prices = [14,6], k = 1

console.log(maximumProfit(prices, k));