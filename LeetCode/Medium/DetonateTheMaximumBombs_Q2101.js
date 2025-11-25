var maximumDetonation = function (bombs) {
    const n = bombs.length
    function isInRange(x1, y1, r1, x2, y2) { // O(1)
        const dx = x2 - x1;
        const dy = y2 - y1;
        return ((dx * dx) + (dy * dy)) <= (r1 * r1)
    }

    let maxCt = -Infinity
    
    for (let i = 0; i < n; i++) { // O(N)
        const visited = Array(n).fill(false)
        if (visited[i] === false) {
            visited[i] = true
            let que = [bombs[i]]
            let ct = 1
            while (que.length > 0) { // O(N)
                const [x1, y1, r1] = que.shift()
                for (let j = 0; j < n; j++) {
                    const [x2, y2,] = bombs[j]
                    if(visited[j] === false) {
                        const inRange = isInRange(x1, y1, r1, x2, y2)
                        if(inRange) {
                            que.push(bombs[j])
                            visited[j] = true
                            ct += 1

                        }
                    }
                }
            }

            maxCt = Math.max(maxCt, ct)
        }
    }

    return maxCt
};

let bombs;
// bombs = [[2,1,3],[6,1,4]]
// bombs = [[1,1,5],[10,10,5]]
bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]

console.log(maximumDetonation(bombs));

