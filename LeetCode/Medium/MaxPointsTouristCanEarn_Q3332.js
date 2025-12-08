var maxScore = function (n, k, stayScore, travelScore) {
    const dp = Array.from({length: k}, () => Array(n).fill(-1))
    
    function solve(day, city) {
        if (day === k) {
            return 0
        }
        if (dp[day][city] === -1) {
            let max = -Infinity
            for (let i = 0; i < n; i++) {
                let score = 0
                if (city === i) {
                    score = stayScore[day][i]
                } else {
                    score = travelScore[city][i]
                }
                const earn = solve(day + 1, i) + score
                max = Math.max(max, earn)
            }
            dp[day][city] = max
        }
        return dp[day][city]
    }

    let maxFromEachPoints = -Infinity
    for (let j = 0; j < n; j++) {
        maxFromEachPoints = Math.max(maxFromEachPoints, solve(0, j))
    }
    return maxFromEachPoints
};

let n, k, stayScore, travelScore;

// n = 2, k = 1, stayScore = [[2,3]], travelScore = [[0,2],[1,0]]
n = 3, k = 2, stayScore = [[3, 4, 2], [2, 1, 2]], travelScore = [[0, 2, 1], [2, 0, 4], [3, 2, 0]]

maxScore(n, k, stayScore, travelScore)