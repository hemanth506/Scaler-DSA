var prisonAfterNDays_TLE = function(cells, n) { // TLE
    const arr = Array(8).fill(0)
    for(let i = 0; i < n; i++) {
        for(let j = 1; j <= 6; j++) {
            if(cells[j-1] === cells[j+1]) {
                arr[j] = 1
            }
        }
        cells = [...arr]
    }

    return cells
};


var prisonAfterNDays = function(cells, n) {
    let arr = Array(8).fill(0)
    const actualCells = [...cells]
    const middleStr = cells[1]+''+cells[2]+''+cells[3]+''+cells[4]+''+cells[5]+''+cells[6]
    let iter = 0
    for(let i = 0; i < n; i++) {
        let curStr = ''
        arr = Array(8).fill(0)
        for(let j = 1; j <= 6; j++) {
            arr[j] = cells[j-1] === cells[j+1] ? 1 : 0
            curStr += ""+arr[j]
        }
        if(curStr === middleStr && i !== 0) {
            iter = i
            break
        }
        
        cells = [...arr]
    }

    console.log('iter', iter);
    console.log('cells', cells);
    const rem = n % iter
    cells = [...actualCells]
    console.log('rem', rem);
    console.log('cells', cells);
    for(let i = 0; i < rem; i++) {
        arr = Array(8).fill(0)
        for(let j = 1; j <= 6; j++) {
            if(cells[j-1] === cells[j+1]) {
                arr[j] = 1
            }
        }
        
        cells = [...arr]
    }

    console.log('final cells', cells);
    return cells
};

let cells, n;

cells = [1,0,0,1,0,0,1,0], n = 1000000000
// cells = [0,1,0,1,1,0,0,1], n = 7


prisonAfterNDays(cells, n)