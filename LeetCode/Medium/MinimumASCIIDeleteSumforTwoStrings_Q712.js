var minimumDeleteSum = function(s1, s2) {
    const n = s1.length, m = s2.length;
    const dp = Array.from({length: n}, () => Array(m).fill(-1))
    function solve(i, j) {
        if(i >= n && j >= m) { return 0; }
        if(i >= n) {
            let sum = 0
            for(let rem = j; rem < m; rem++) {
                sum += s2[rem].charCodeAt(0)
            }
            return sum
        }
        if(j >= m) {
            let sum = 0
            for(let rem = i; rem < n; rem++) {
                sum += s1[rem].charCodeAt(0)
            }
            return sum
        }

        if(dp[i][j] === -1) {
            let moveBoth = Infinity
            if(s1[i] === s2[j]) {
                moveBoth = solve(i+1, j+1)
            }

            let moveJ = solve(i, j+1) + s2[j].charCodeAt(0)
            let moveI = solve(i+1, j) + s1[i].charCodeAt(0)
            let minVal = Math.min(moveBoth, moveI, moveJ)
            dp[i][j] = minVal
        }
        return dp[i][j]
    }

    return solve(0, 0)
};

let s1, s2;

// s1 = "sea", s2 = "eat"
s1 = "delete", s2 = "leet"
console.log(minimumDeleteSum(s1, s2));