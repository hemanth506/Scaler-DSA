var maxCapacity = function (costs, capacity, budget) { // TLE
    const n = costs.length
    const dp = Array.from({ length: n }, () =>
        Array(budget + 1).fill(-1)
    )
    function solve(i, ct, bud) {
        if (i === n || bud <= 0 || ct === 2) {
            return 0
        }
        if (dp[i][bud] === -1) {
            let skip = solve(i + 1, ct, bud)
            let take = 0;
            if (bud > costs[i]) {
                take = solve(i + 1, ct + 1, bud - costs[i]) + capacity[i]
            }
            const max = Math.max(skip, take)
            dp[i][bud] = max
        }
        return dp[i][bud]
    }

    return solve(0, 0, budget)
};

var maxCapacity = function (costs, capacity, budget) {
    const n = costs.length;

    const machines = [];
    for (let i = 0; i < n; i++) {
        machines.push([costs[i], capacity[i]]);
    }

    machines.sort((a, b) => a[0] - b[0]);

    const maxCapPrefix = Array(n);
    maxCapPrefix[0] = machines[0][1];
    for (let i = 1; i < n; i++) {
        maxCapPrefix[i] = Math.max(maxCapPrefix[i - 1], machines[i][1]);
    }

    let ans = 0;

    for (let i = 0; i < n; i++) {
        if (machines[i][0] < budget) {
            ans = Math.max(ans, machines[i][1]);
        }
    }

    for (let i = 0; i < n; i++) {
        const cost1 = machines[i][0];
        const cap1 = machines[i][1];

        if (cost1 >= budget) break;

        const remaining = budget - cost1 - 1;
        let left = 0, right = i - 1, idx = -1;

        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (machines[mid][0] <= remaining) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (idx !== -1) {
            ans = Math.max(ans, cap1 + maxCapPrefix[idx]);
        }
    }

    return ans;
};


let costs, capacity, budget;
costs = [4, 8, 5, 3], capacity = [1, 5, 2, 7], budget = 8
// costs = [3,5,7,4], capacity = [2,4,3,6], budget = 7
// costs = [2,2,2], capacity = [3,5,4], budget = 5

console.log(maxCapacity(costs, capacity, budget));