var minMoves = function (bal) {
    const n = bal.length
    let totalPos = 0, totalNeg = 0, idx = -1
    for (let i = 0; i < n; i++) {
        if (bal[i] >= 0) {
            totalPos += bal[i]
        } else {
            totalNeg += bal[i]
            idx = i
        }
    }

    if (totalPos < Math.abs(totalNeg)) return -1;
    if (totalNeg === 0) return 0;

    let i = idx - 1, j = idx + 1, steps = 1, moves = 0
    while (bal[idx] < 0) {
        if (i === -1) i = n - 1;
        if (j === n) j = 0;

        if (bal[i] > bal[j]) {
            moves += (steps * Math.min(Math.abs(bal[idx]), bal[i]))
            bal[idx] += bal[i]

            if (bal[idx] >= 0) break;

            moves += (steps * Math.min(Math.abs(bal[idx]), bal[j]))
            bal[idx] += bal[j]
        } else {
            moves += (steps * Math.min(Math.abs(bal[idx]), bal[j]))
            bal[idx] += bal[j]

            if (bal[idx] >= 0) break;

            moves += (steps * Math.min(Math.abs(bal[idx]), bal[i]))
            bal[idx] += bal[i]
        }
        j++; i--;
        steps++
    }

    return moves
};

let balance;
// balance = [5, 1, -4]
// balance = [1,2,-5,2]
balance = [3,3,0,-6,0,5,1]

console.log(minMoves(balance));