var maxProfit = function(prices, strategy, k) {
    const n = prices.length
    const all = Array(n).fill(0)
    const prefix = Array(n).fill(0)
    const suffix = Array(n).fill(0)
    all[0] = prices[0]; 
    prefix[0] = strategy[0] * prices[0]; 
    suffix[n-1] = strategy[n-1] * prices[n-1];

    for(let i = 1, j = n - 2; i < n; i++, j--) {
        prefix[i] = prefix[i-1] + (strategy[i] * prices[i])
        suffix[j] = suffix[j+1] + (strategy[j] * prices[j])
        all[i] = all[i-1] + prices[i]
    }
    console.log('prefix', prefix);
    console.log('suffix', suffix);
    console.log('all', all);


    let maxP = prefix[n-1]
    let tempR = -1 + k
    for(let l = -1, r = tempR; l < n - k; l++, r++) {
        const left = l === -1 ? 0 : prefix[l]
        const midHalf = all[r] - all[r-(k/2)]
        const right = r === n - 1? 0 : suffix[r + 1]
        console.log(left, midHalf, right);
        maxP = Math.max(maxP, (left + midHalf + right))
    }
    return maxP;
};

let prices, strategy, k;

// prices = [4,2,8], strategy = [-1,0,1], k = 2
// prices = [5,4,3], strategy = [1,1,0], k = 2
// prices = [4, 2, 6, 3, 5, 1], strategy = [-1, 0, 1, -1, 0, 1], k = 2
prices = [5, 1, 4, 6, 2, 7, 3, 8], strategy = [-1, 0, 1, -1, 0, 1, -1, 0], k = 4
// prices = [5, 8], strategy = [-1, -1], k = 2


console.log(maxProfit(prices, strategy, k));