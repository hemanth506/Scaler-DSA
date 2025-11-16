var maxNumberOfFamiliesTLE = function (n, reservedSeats) { // TLE approach
    const m = reservedSeats.length
    reservedSeats.sort((a, b) => {
        if (a[0] == b[0]) {
            return a[1] - b[1]
        }
        return a[0] - b[0]
    })


    function calculateFamilies(cs) {
        let count = 0
        if (!cs.has(2) && !cs.has(3) && !cs.has(4) && !cs.has(5) && !cs.has(6) && !cs.has(7) && !cs.has(8) && !cs.has(9)) {
            count += 2
        } else if ((!cs.has(2) && !cs.has(3) && !cs.has(4) && !cs.has(5)) || (!cs.has(6) && !cs.has(7) && !cs.has(8) && !cs.has(9)) || (!cs.has(4) && !cs.has(5) && !cs.has(6) && !cs.has(7))) {
            count += 1
        }
        return count
    }

    let ct = 0
    const rowSet = new Set()
    let colSet = new Set()
    for (let i = 0; i < m; i++) {
        const [row,] = reservedSeats[i]
        rowSet.add(row)

        colSet = new Set()
        let j = i
        for (; j < m; j++) {
            const [innerRow, innerCol] = reservedSeats[j];
            if (innerRow !== row) { break; }
            else { colSet.add(innerCol); }
        }
        i = j - 1

        ct += calculateFamilies(colSet)
    }

    for(let i = 1; i <= n; i++) {
        if(!rowSet.has(i)) {
            ct += 2
        }
    }

    return ct
};

var maxNumberOfFamilies = function (n, reservedSeats) {
    const map = new Map();

    for (let [r, c] of reservedSeats) {
        if (!map.has(r)) map.set(r, new Set());
        map.get(r).add(c);
    }

    let ct = 0
    for(let [, cs] of map.entries()) {
        let left = !cs.has(2) && !cs.has(3) && !cs.has(4) && !cs.has(5)
        let right = !cs.has(6) && !cs.has(7) && !cs.has(8) && !cs.has(9)
        let mid = !cs.has(4) && !cs.has(5) && !cs.has(6) && !cs.has(7)

        if(left && right) ct += 2;
        else if (left || right || mid) ct += 1;
    }

    ct += (n - map.size) * 2

    return ct
};


let n, reservedSeats;
// n = 3, reservedSeats = [[1, 2], [1, 3], [1, 8], [2, 6], [3, 1], [3, 10]]
// n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
// n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
// n = 2, reservedSeats = [[2,9],[2,7],[2,3],[1,4],[2,8],[1,7],[2,10],[1,6],[2,2],[1,5]]
// n = 3, reservedSeats = [[2,3]]
// n = 5, reservedSeats = [[2,2],[5,4],[3,5],[5,10],[5,7],[4,5]]
n = 4, reservedSeats = [[2,10],[3,1],[1,2],[2,2],[3,5],[4,1],[4,9],[2,7]]

console.log(maxNumberOfFamilies(n, reservedSeats));