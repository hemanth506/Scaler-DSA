var maximumValueSumBruteForce = function (board) {
    const n = board.length;
    const m = board[0].length;
    console.log("board", board);

    let maxSumVal = -Infinity;
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                for (let x = 0; x < m; x++) {
                    let first = board[i][x];
                    for (let y = 0; y < m; y++) {
                        if (y !== x) {
                            let second = board[j][y];
                            for (let z = 0; z < m; z++) {
                                if (z !== x && z !== y) {
                                    let third = board[k][z];
                                    let sumVal = first + second + third;
                                    maxSumVal = Math.max(maxSumVal, sumVal);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    console.log("maxSumVal", maxSumVal);
    return maxSumVal;
};

var maximumValueSum = function (board) {
    const n = board.length;
    console.log("board", board);

    const constructBoard = [];
    for (let i = 0; i < n; i++) {
        constructBoard.push(
            board[i]
                .map((elt, j) => [elt, j])
                .sort((a, b) => b[0] - a[0])
                .map((elt) => elt[1])
                .slice(0, 3)
        );
    }
    console.log(constructBoard);

    let maxSumVal = -Infinity;
    for (let i = 0; i < n - 2; i++) {
        const firstRow = constructBoard[i]
        for (let j = i + 1; j < n - 1; j++) {
            const secondRow = constructBoard[j]
            for (let k = j + 1; k < n; k++) {
                const thirdRow = constructBoard[k]

                for (let x = 0; x < 3; x++) {
                    let first = board[i][firstRow[x]];
                    for (let y = 0; y < 3; y++) {
                        if (secondRow[y] !== firstRow[x]) {
                            let second = board[j][secondRow[y]];
                            for (let z = 0; z < 3; z++) {
                                if (thirdRow[z] !== firstRow[x] && thirdRow[z] !== secondRow[y]) {
                                    let third = board[k][thirdRow[z]];
                                    let sumVal = first + second + third;
                                    maxSumVal = Math.max(maxSumVal, sumVal);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    console.log("maxSumVal", maxSumVal);
    return maxSumVal;
};

/**
 *
 * [ [ 10, 4, 3 ], 0
 *   [ 5, 8, 7 ], 1
 *   [ 9, 3, 2 ], 2
 *   [ 4, 7, 6 ] ]3
 */

let board;

board = [
    [10, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 1, 2, 3],
    [4, 5, 6, 7],
];

// board = [[-3,1,1,1],[-3,1,-3,1],[-3,2,1,1]]
// board = [[1,2,3],[4,5,6],[7,8,9]]
// board = [[1,1,1],[1,1,1],[1,1,1]]
maximumValueSum(board);
