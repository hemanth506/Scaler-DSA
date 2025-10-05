var maxDistance = function (s, k) {
    const n = s.length;

    const allPossibilities = [
        {
            maxPole: "N",
            minPole: "S",
            maxSide: "E",
            minSide: "W",
        },
        {
            maxPole: "N",
            minPole: "S",
            maxSide: "W",
            minSide: "E",
        },
        {
            maxPole: "S",
            minPole: "N",
            maxSide: "E",
            minSide: "W",
        },
        {
            maxPole: "S",
            minPole: "N",
            maxSide: "W",
            minSide: "E",
        },
    ];

    const mapDist = {
        N: [0, 1],
        S: [0, -1],
        W: [-1, 0],
        E: [1, 0],
    };

    let globalMaxDist = 0;
    for (let pos = 0; pos < 4; pos++) {
        const { minPole, maxPole, minSide, maxSide } = allPossibilities[pos];
        let maxDist = 0;
        let remaining = k;
        let actualDist = [0, 0]
        for (let i = 0; i < n; i++) {
            let curDir = s.charAt(i);
            if (remaining > 0 && (curDir === minPole || curDir === minSide)) {
                if (curDir === minPole) {
                    curDir = maxPole;
                } else if (curDir === minSide) {
                    curDir = maxSide;
                }
                remaining--;
            }
            let increaseX = actualDist[0] + mapDist[curDir][0];
            let increaseY = actualDist[1] + mapDist[curDir][1];
            actualDist = [increaseX, increaseY];
            const curDist = Math.abs(actualDist[0]) + Math.abs(actualDist[1]);
            maxDist = Math.max(maxDist, curDist);
        }
        globalMaxDist = Math.max(globalMaxDist, maxDist)
    }

    console.log("globalMaxDist", globalMaxDist);

    return globalMaxDist;
};

let s, k;

// s = "NWSE", k = 1
// s = "NSWWEW", k = 3

(s = "ENNSW"), (k = 1);

maxDistance(s, k);
