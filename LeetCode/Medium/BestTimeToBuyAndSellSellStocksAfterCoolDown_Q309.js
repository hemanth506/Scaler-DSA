var maxProfit = function(prices) {
    const n = prices.length
    // if(n === 1) return 0;
    const dp = Array.from({length: n}, () => Array(2).fill(-1))

    function solve(i, toBuy) {
        if(i >= n) {
            return 0
        }

        if(dp[i][toBuy] === -1) {
            let res
            if(toBuy === 1) {
                let buy = solve(i+1, 0) - prices[i]
                let skipBuy = solve(i+1, 1)
                res = Math.max(buy, skipBuy)
            } else {
                let sell = solve(i+2, 1) + prices[i]
                let skipSell = solve(i+1, 0)
                res = Math.max(sell, skipSell)
            }
            dp[i][toBuy] = res
        }

        return dp[i][toBuy]
    }

    const maxProfitVal = solve(0, 1) 
    console.log(maxProfitVal);
    return maxProfitVal
};

let prices;
// prices = [1,2,3,0,2]
prices = [1]
// prices = [1,2]

maxProfit(prices)