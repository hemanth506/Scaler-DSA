var gardenNoAdj = function (n, paths) {
    const adjList = Array.from({ length: n }, () => [])
    const plantArr = Array(n).fill(-1)

    for (let [u, v] of paths) {
        u -= 1
        v -= 1
        adjList[u].push(v)
        adjList[v].push(u)
    }

    function bfs(nd) {
        const que = []
        que.push(nd)
        plantArr[nd] = 1
        while(que.length > 0) {
            const top = que.shift()
            for(let adj of adjList[top]) {
                if(plantArr[adj] === -1 || plantArr[top] === plantArr[adj]) {
                    que.push(adj)
                    plantArr[adj] = plantArr[top] + 1
                }
                if(plantArr[adj] > 4) plantArr[adj] %= 4
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (plantArr[i] === -1) {
            bfs(i)
        }
    }

    console.log(plantArr);
    return plantArr
};


let n, paths

// n = 3, paths = [[1,2],[2,3],[3,1]];
// n = 4, paths = [[1,2],[3,4]]
// n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
n = 5, paths = [[4,1],[4,2],[4,3],[2,5],[1,2],[1,5]]

gardenNoAdj(n, paths)