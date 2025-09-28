var maxRectangleArea = function (points) {
    const n = points.length
    if (n < 4) {
        return -1;
    }

    let maxArea = -Infinity

    const pointSet = new Set();
    for (const [x, y] of points) {
        pointSet.add(`${x}_${y}`);
    }

    for (let i = 0; i < n; i++) {
        const [blx, bly] = points[i] // bottom left
        const blStr = blx + "_" + bly
        for (let j = i + 1; j < n; j++) {
            const [trx, tryy] = points[j] // top right
            const trStr = trx + "_" + tryy
            if (blx === trx || bly === tryy) {
                continue
            }

            const tlStr = blx + '_' + tryy
            const brStr = trx + '_' + bly
            if (pointSet.has(tlStr) && pointSet.has(brStr)) {
                const currentArea = Math.abs((trx - blx) * (tryy - bly));

                let pointExist = false
                const minX = Math.min(blx, trx);
                const maxX = Math.max(blx, trx);
                const minY = Math.min(bly, tryy);
                const maxY = Math.max(bly, tryy);

                for (let l = 0; l < n; l++) {
                    const [chx, chy] = points[l] // check points

                    const chStr = chx + "_" + chy
                    if (blStr === chStr || trStr === chStr || tlStr === chStr || brStr === chStr) {
                        continue
                    }
                    if (minX <= chx && chx <= maxX && minY <= chy && chy <= maxY) {
                        pointExist = true
                        break
                    }
                }
                if (!pointExist) {
                    maxArea = Math.max(maxArea, currentArea)
                }
            }


        }
    }

    return maxArea === -Infinity ? -1 : maxArea
};

let points;

// points = [[80,98],[21,55],[80,55],[21,98],[69,85]]

// points = [[96,44],[23,72],[96,72],[23,44],[65,44]]

points = [[66,34],[49,0],[66,0],[49,34],[46,80],[64,34]]


console.log(maxRectangleArea(points))