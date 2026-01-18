var largestSquareArea = function(bottomLeft, topRight) {
    const n = bottomLeft.length
    let max = 0
    for(let i = 0; i < n; i++) {
        const [botx1, boty1] = bottomLeft[i]
        const [topx1, topy1] = topRight[i]
        for(let j = i+1; j < n; j++) {
            const [botx2, boty2] = bottomLeft[j]
            const [topx2, topy2] = topRight[j]

            const x = Math.min(topx1, topx2) - Math.max(botx1, botx2)
            const y = Math.min(topy1, topy2) - Math.max(boty1, boty2)
            if(x > 0 && y > 0) {
                const side = Math.min(x, y)
                max = Math.max(max, side)
            }

        }
    }

    return side * side
};

let bottomLeft, topRight;
// bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
// bottomLeft = [[1,1],[1,3],[1,5]], topRight = [[5,5],[5,7],[5,9]]
bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]

console.log(largestSquareArea(bottomLeft, topRight));