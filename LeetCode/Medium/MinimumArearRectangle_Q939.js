var minAreaRect = function (points) {
    const n = points.length
    const map = new Set()

    let minArea = Infinity
    for (let i = 0; i < n; i++) {
        let [x1, y1] = points[i]
        for (let j = 0; j < n; j++) {
            let [x2, y2] = points[j]
            const dia1 = x1+"_"+y2;
            const dia2 = x2+"_"+y1;
            if(map.has(dia1) && map.has(dia2)) {
                const area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                minArea = Math.min(minArea, area)
            }
        }
        map.add(x1+"_"+y1)
    }
    return minArea === Infinity ? 0 : minArea;
};

let points;
points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
// points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
// points = [[0,1],[1,3],[3,3],[4,4],[1,4],[2,3],[1,0],[3,4]]
// points = [[3, 2], [3, 1], [4, 4], [1, 1], [4, 3], [0, 3], [0, 2], [4, 0]]
console.log(minAreaRect(points));