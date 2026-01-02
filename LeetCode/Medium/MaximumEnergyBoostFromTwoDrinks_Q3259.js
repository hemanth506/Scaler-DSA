var maxEnergyBoostRecursive = function(energyDrinkA, energyDrinkB) {
    const n = energyDrinkA.length
    let dp = Array.from({length: n}, () => Array(2).fill(-1))

    function solve(i, arrId) {
        if(i >= n) return 0;

        if(dp[i][arrId] === -1) {
            let arr = energyDrinkB
            if(arrId === 0) arr = energyDrinkA;
            
            const same = solve(i+1, arrId) + arr[i]
            const another = solve(i+2, 1 - arrId) + arr[i]
            dp[i][arrId] = Math.max(same, another)
        }
        return dp[i][arrId]
    }

    return Math.max(solve(0, 0), solve(0, 1))
};

var maxEnergyBoost = function (energyDrinkA, energyDrinkB) { // Iterative
    let n = energyDrinkA.length;
    let dpA = Array.from({ length: n }).fill(0);
    let dpB = Array.from({ length: n }).fill(0);

    dpA[0] = energyDrinkA[0];
    dpB[0] = energyDrinkB[0];

    for (let i = 1; i < n; i++) {
        dpA[i] = dpA[i - 1] + energyDrinkA[i];
        dpB[i] = dpB[i - 1] + energyDrinkB[i];

        if (i > 1) {
            dpA[i] = Math.max(dpA[i], dpB[i - 2] + energyDrinkA[i]);
            dpB[i] = Math.max(dpB[i], dpA[i - 2] + energyDrinkB[i]);
        }
    }

    return Math.max(dpA[n - 1], dpB[n - 1]);
};

let energyDrinkA, energyDrinkB
// energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]

console.log(maxEnergyBoost(energyDrinkA, energyDrinkB));