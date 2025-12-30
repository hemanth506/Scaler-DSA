var numMagicSquaresInside = function(grid) {
    const n = grid.length
    const m = grid[0].length

    function checkMagicGrid(i, j) {
        const ii = i+2, jj = j +2
        if(ii >= n || jj >= m) return false;

        const rowHs = new Set()
        let prevSum = -1;
        for(let row = i; row <= ii; row++) {
            let sum = 0;
            for(let col = j; col <= jj; col++) {
                const elt = grid[row][col]
                if(rowHs.has(elt) || elt > 9 || elt < 1) return false;
                rowHs.add(elt)
                sum += elt
            }
            if(prevSum !== -1 && sum != prevSum) return false;
            prevSum = sum;
        }

        
        const colHs = new Set()
        for(let col = j; col <= jj; col++) {
            let sum = 0;
            for(let row = i; row <= ii; row++) {
                const elt = grid[row][col]
                if(colHs.has(elt) || elt > 9 || elt < 1) return false;
                colHs.add(elt)
                sum += elt
            }
            if(sum != prevSum) return false;
            prevSum = sum;
        }

        let dia1 = 0, dia2 = 0;
        let tempI = i, tempJ = j, revI = i, revJ = jj;
        for(let times = 1; times <= 3; times++) {
            dia1 += grid[tempI][tempJ]
            dia2 += grid[revI][revJ]
            tempI++, tempJ++, revI++, revJ--;
        }
        if(dia1 !== prevSum || dia2 !== prevSum) return false;

        return true
    }


    let ct = 0
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(checkMagicGrid(i, j)) {
                ct++
            }
        }
    }
    return ct
};

let grid;

// grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
// grid = [[8]]
grid = [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2],
        [4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]

console.log(numMagicSquaresInside(grid));