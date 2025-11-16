var findLongestChain = function (pairs) { // O(N * N)
    const n = pairs.length
    pairs.sort((a, b) => {
        if (a[0] === b[0]) {
            return a[1] - b[1]
        }
        return a[0] - b[0]
    })
    console.log(pairs);

    const dp = Array.from({ length: n + 1 }, () => Array(n + 1).fill(-1));

    function solve(prevIdx, idx) {
        if(idx === n) {
            return 0
        }

        if(dp[prevIdx + 1][idx] === -1) {
            let take = 0, leave = 0
            if(prevIdx === -1 || pairs[prevIdx][1] < pairs[idx][0]) {
                take = solve(idx, idx + 1) + 1
            }
            leave = solve(prevIdx, idx + 1)
            let max = Math.max(take, leave)
            dp[prevIdx + 1][idx] = max
        }

        return dp[prevIdx + 1][idx]
    }
    

    const res = solve(-1, 0)
    return res
};

var findLongestChain = function (pairs) { // O(N)
    pairs.sort((a, b) => a[1] - b[1])
    console.log(pairs);
    let res = [pairs[0]]
    for(let i = 1; i < pairs.length; i++) {
        const [_, right] = res.at(-1)
        if(right < pairs[i][0]) {
            res.push(pairs[i]);
        }
    }
    console.log(res);
    return res.length
};

let pairs

// pairs = [[1, 2], [2, 3], [3, 4]];
// pairs = [[1,2],[7,8],[4,5]]
pairs = [[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]

console.log(findLongestChain(pairs));