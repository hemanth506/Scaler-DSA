var maximumCandies = function(candies, k) {
    const n = candies.length
    function solve(mid) {
        let curK = 0
        for(let i = 0; i < n; i++) {
            curK += Math.floor(candies[i] / mid)
        }
        return curK >= k
    }

    let maxCandies = 0
    let l = 0; h = Math.max(...candies)
    while(l <= h) {
        let m = Math.floor((l+h) / 2)
        if(solve(m)) {
            maxCandies = m
            l = m + 1
        } else {
            h = m - 1
        }
    }
    return maxCandies
};

let candies, k;
// candies = [5,8,6], k = 3
candies = [2,5], k = 11

console.log(maximumCandies(candies, k));