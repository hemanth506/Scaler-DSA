var rotateTheBoxSorting = function (boxGrid) { // O(NlogN)
    const n = boxGrid.length
    const m = boxGrid[0].length
    const rotatedBox = Array.from({ length: m }, () => Array(n))

    for (let i = 0; i < n; i++) {
        let startJ = 0
        for (let j = 0; j < m; j++) {
            if (boxGrid[i][j] === '.') {
                boxGrid[i][j] = '!'
            } else if (boxGrid[i][j] === '*') {
                const sortedSubArr = boxGrid[i].slice(startJ, j).sort((a, b) => a.charCodeAt(0) - b.charCodeAt(0))
                replaceArr(sortedSubArr, i, startJ, j)
                startJ = j + 1
            }
        }
        const finalSubArr = boxGrid[i].slice(startJ, m).sort((a, b) => a.charCodeAt(0) - b.charCodeAt(0))
        replaceArr(finalSubArr, i, startJ, m)
    }


    function replaceArr(sortedSubArr, row, startJ, endJ) {
        for (let i = startJ, k = 0; i < endJ; i++, k++) {
            boxGrid[row][i] = sortedSubArr[k]
        }
    }

    for(let col = 0; col < m; col++) {
        for(let row = 0; row < n; row++) {
            rotatedBox[col][row] = boxGrid[row][col] === '!' ? '.' : boxGrid[row][col]
        }
        rotatedBox[col].reverse()
    }

    console.log(rotatedBox)
    return rotatedBox

};

var rotateTheBox = function (boxGrid) { // O(N)
    const n = boxGrid.length
    const m = boxGrid[0].length
    const rotatedBox = Array.from({ length: m }, () => Array(n))
    console.log(boxGrid)

    for (let i = 0; i < n; i++) {
        let startJ = 0, rocks = 0
        for (let j = 0; j < m; j++) {
            if (boxGrid[i][j] === '#') {
                rocks++
            } else if (boxGrid[i][j] === '*') {
                sortedSubArr(rocks, i, startJ, j)
                startJ = j + 1
                rocks = 0
            }
        }
        sortedSubArr(rocks, i, startJ, m)
    }

    function sortedSubArr(rocks, row, startJ, endJ) {
        const curArr = boxGrid[row];
        for(let j = endJ-1; j >= startJ; j--) {
            if(rocks > 0) {
                curArr[j] = '#'
                rocks--
            } else {
                curArr[j] = '.'
            }
        }
    }

    for(let col = 0; col < m; col++) {
        for(let row = 0; row < n; row++) {
            rotatedBox[col][row] = boxGrid[row][col]
        }
        rotatedBox[col].reverse()
    }

    console.log(boxGrid)
    console.log(rotatedBox)
    return rotatedBox

};

let boxGrid;
boxGrid = [["#", ".", "*", "#", "."], ["#", "#", "*", ".", "."]]

/**
 * [ [ '#', '.', '*', '.' ], 
 *   [ '#', '#', '*', '.' ] ]
 * 
 * [ [ '#', '#' ], 
 *   [ '#', '.' ], 
 *   [ '*', '*' ], 
 *   [ '.', '.' ] ]
 * 
 */


rotateTheBox(boxGrid)