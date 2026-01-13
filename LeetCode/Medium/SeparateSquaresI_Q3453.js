var separateSquares = function (squares) {
    let l = Infinity, h = -Infinity
    for (let [_, y, a] of squares) {
        l = Math.min(y, l)
        h = Math.max(y + a, h)
    }
    function check(mid) {
        let right = 0, left = 0;
        for (let [_, y, a] of squares) {
            if (y >= mid) {
                right += (a * a)
            } else if ((a + y) <= mid) {
                left += (a * a)
            } else {
                right += (((a + y) - mid) * a)
                left += ((mid - y) * a)
            }
        }
        if (right <= left) return true;
        return false;
    }
    while ((h - l) > 1e-6) {
        let m = (l + h) / 2
        if (check(m)) {
            h = m
        } else {
            l = m
        }
    }
    return l
};

let squares;

// squares = [[0, 0, 1], [2, 2, 1]]
squares = [[0, 0, 2], [1, 1, 1]]
console.log(separateSquares(squares));