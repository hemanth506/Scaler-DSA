var maximizeSquareHoleArea = function (n, m, hBars, vBars) {
    hBars.sort((a, b) => a - b)
    vBars.sort((a, b) => a - b)
    let prev = hBars[0], len = 1, hMax = len
    for (let i = 1; i < hBars.length; i++) {
        if ((prev + 1) !== hBars[i]) {
            hMax = Math.max(hMax, len)
            len = 0
        }
        prev = hBars[i]
        len++
    }
    hMax = Math.max(hMax, len)

    prev = vBars[0], len = 1
    let vMax = len
    for (let i = 1; i < vBars.length; i++) {
        if ((prev + 1) !== vBars[i]) {
            vMax = Math.max(vMax, len)
            len = 0
        }
        prev = vBars[i]
        len++
    }
    vMax = Math.max(vMax, len)

    let min = Math.min(vMax, hMax) + 1
    return min * min
};

let n, m, hBars, vBars;
// n = 2, m = 1, hBars = [2,3], vBars = [2]
// n = 1, m = 1, hBars = [2], vBars = [2]
// n = 2, m = 3, hBars = [2, 3], vBars = [2, 4, 3]
n = 2, m = 3, hBars = [2, 3], vBars = [6,7]

console.log(maximizeSquareHoleArea(n, m, hBars, vBars));