var countTrapezoids = function(points) {
    const MOD = 1000000007n;

    const hm = new Map();
    for (let [_, y] of points) {
        hm.set(y, (hm.get(y) || 0) + 1);
    }

    const arr = [...hm.values()];
    const m = arr.length;

    // Inverse of 2, will solve the overflow issue
    const inv2 = (MOD + 1n) / 2n;
    const pointsCount = (p) => {
        return (((p % MOD) * ((p + 1n) % MOD)) % MOD * inv2) % MOD;
    };

    let suffix = new Array(m).fill(0n);
    let prev = 0n;
    for (let i = m - 1; i >= 0; i--) {
        const p = BigInt(arr[i]) - 1n;
        suffix[i] = (pointsCount(p) + prev) % MOD;
        prev = suffix[i];
    }

    let ct = 0n;
    for (let i = 0; i < m - 1; i++) {
        const ip = pointsCount(BigInt(arr[i]) - 1n);
        const jp = suffix[i + 1];
        ct = (ct + (ip * jp) % MOD) % MOD;
    }

    return Number(ct);
};


let points;

// points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
// points = [[0,0],[1,0],[0,1],[2,1]]
points = [[0,0],[1,0],[2,1],[3,1],[4,1],[5,1],[1,2],[2,2],[3,2]]
console.log(countTrapezoids(points));