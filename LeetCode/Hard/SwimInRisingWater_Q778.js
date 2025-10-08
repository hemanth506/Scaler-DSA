var swimInWater = function(grid) {
    const n = grid.length
    const visited = Array.from({ length: n}, () => Array(n).fill(false))
    const sides = [[0,1], [1,0], [0,-1], [-1,0]]
    let maxTime = -Infinity

    const pq = new PriorityQueue((a, b) => a[0] - b[0])
    pq.add(grid[0][0], 0, 0)
    
    while (pq.size() > 0) {
        const minElt = pq.pop()
        const val = minElt[0], r = minElt[1], c = minElt[2]
        maxTime = Math.max(maxTime, val)
        if(r === n - 1 && c === n - 1) {
            break 
        }
        visited[r][c] = true

        for(let i = 0; i < 4; i++) {
            let sideR = r + sides[i][0]
            let sideC = c + sides[i][1]
            if(sideR >= n || sideR < 0 || sideC >= n || sideC < 0 || visited[sideR][sideC] === true) {
                continue
            }
            pq.add(grid[sideR][sideC], sideR, sideC)
        }
    }
    return maxTime 
};