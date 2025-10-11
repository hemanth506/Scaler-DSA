var maximumEnergy = function (energy, k) { // TLE
    const n = energy.length
    let maxEnergy = -Infinity
    for(let i = 0; i < n; i++) {
        let curSum = 0
        for(let j = i; j < n; j += k) {
            curSum += energy[j]
        }
        maxEnergy = Math.max(maxEnergy, curSum)
    }

    console.log(maxEnergy)
    return maxEnergy
}

// working codes
var maximumEnergyDpStack = function (energy, k) {
    const n = energy.length
    const dp = Array.from({ length: n }, () => Array(2).fill(-Infinity))

    function solve(i, j) {
        if (i >= n) {
            return 0
        }

        if (dp[i][j] === -Infinity) {
            if (j === 0) {
                let pickAndJump = energy[i] + solve(i + k, 1)
                let leaveAndMove = -Infinity
                if (i + 1 < n) {
                    leaveAndMove = solve(i + 1, 0)
                }
                dp[i][j] = Math.max(pickAndJump, leaveAndMove)
            } else {
                let pickAndJump = energy[i] + solve(i + k, 1)
                dp[i][j] = pickAndJump
            }
        }

        return dp[i][j]
    }

    const res = solve(0, 0)

    return res
};

var maximumEnergyDpMemo = function (energy, k) {
    const n = energy.length
    const dp = Array.from({ length: n }, () => Array(2).fill(-Infinity))

    for (let i = n - 1; i >= 0; i--) {
        for (let j = 0; j < 2; j++) {
            let pickAndJump = energy[i]
            if (i + k < n) {
                pickAndJump += dp[i + k][1]
            }
            let leaveAndMove = -Infinity
            if (j === 0 && i + 1 < n) {
                leaveAndMove = dp[i + 1][0]
            }
            dp[i][j] = Math.max(pickAndJump, leaveAndMove)
        }
    }
    console.log('dp', dp[0][0])
    return dp[0][0]
};

let energy, k

energy = [5,2,-10,-5,1], k = 3
// energy = [-2, -3, -1], k = 2

console.log(maximumEnergy(energy, k))