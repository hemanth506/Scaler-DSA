var trapRainWater_WrongApproach = function (heightMap) {
    const n = heightMap.length
    const m = heightMap[0].length

    const prefMaxHor = Array.from({ length: n }, () => Array(m).fill(0))
    const sufMaxHor = Array.from({ length: n }, () => Array(m).fill(0))
    const prefMaxVert = Array.from({ length: n }, () => Array(m).fill(0))
    const sufMaxVert = Array.from({ length: n }, () => Array(m).fill(0))

    for (let i = 0; i < n; i++) {
        prefMaxHor[i][0] = heightMap[i][0]
        for (let j = 1; j < m; j++) {
            prefMaxHor[i][j] = Math.max(prefMaxHor[i][j - 1], heightMap[i][j])
        }
    }

    for (let i = 0; i < n; i++) {
        sufMaxHor[i][m - 1] = heightMap[i][m - 1]
        for (let j = m - 2; j >= 0; j--) {
            sufMaxHor[i][j] = Math.max(sufMaxHor[i][j + 1], heightMap[i][j])
        }
    }


    for (let i = 0; i < m; i++) {
        prefMaxVert[0][i] = heightMap[0][i]
        for (let j = 1; j < n; j++) {
            prefMaxVert[j][i] = Math.max(prefMaxVert[j - 1][i], heightMap[j][i])
        }
    }

    for (let i = 0; i < m; i++) {
        sufMaxVert[n - 1][i] = heightMap[n - 1][i]
        for (let j = n - 2; j >= 0; j--) {
            sufMaxVert[j][i] = Math.max(sufMaxVert[j + 1][i], heightMap[j][i])
        }
    }

    let trapped = 0
    for (let i = 1; i < n - 1; i++) {
        for (let j = 1; j < m - 1; j++) {
            const minPillar = Math.min(prefMaxHor[i][j - 1], sufMaxHor[i][j + 1], prefMaxVert[i - 1][j], sufMaxVert[i + 1][j])
            const waterTrapped = minPillar - heightMap[i][j]
            console.log('minPillar', minPillar, 'waterTrapped', waterTrapped)
            trapped += Math.max(waterTrapped, 0)
        }
    }

    console.log(trapped)
    return trapped

};

var trapRainWater = function (heightMap) {
    const n = heightMap.length
    const m = heightMap[0].length
    const pq = new PriorityQueue((a, b) => a[0] - b[0])
    const visited = Array.from({length: n}, () => Array(m).fill(false))

    for (let i = 0; i < n; i++) {
        pq.add([heightMap[i][0], [i, 0]])
        pq.add([heightMap[i][m - 1], [i, m - 1]])
        visited[i][0] = true; visited[i][m - 1] = true
    }

    for (let j = 0; j < m; j++) {
        pq.add([heightMap[0][j], [0, j]])
        pq.add([heightMap[n - 1][j], [n - 1, j]])
        visited[0][j] = true; visited[n - 1][j] = true
    }

    const dR = [1, -1, 0, 0], dC = [0, 0, -1, 1]
    let waterTrapped = 0
    while (pq.size() > 0) {
        const cur = pq.pop()
        const curHeight = cur[0]
        const [curCellRow, curCellCol] = cur[1]
        for(let d = 0; d < 4; d++) {
            let r = curCellRow + dR[d], c = curCellCol + dC[d]
            if (r >= 0 && c >= 0 && r < n && c < m && !visited[r][c]) {
                waterTrapped += Math.max(curHeight - heightMap[r][c], 0)
                heightMap[r][c] = Math.max(curHeight, heightMap[r][c])
                pq.add([heightMap[r][c], [r, c]])
                visited[r][c] = true
            }
        }
    }

    return waterTrapped
}

let heightMap;

// heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
// heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
heightMap = [[12, 13, 1, 12], [13, 4, 13, 12], [13, 8, 10, 12], [12, 13, 12, 12], [13, 13, 13, 13]]


trapRainWater(heightMap)