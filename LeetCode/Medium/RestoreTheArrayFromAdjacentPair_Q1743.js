var restoreArray = function(adjacentPairs) {
    const n = adjacentPairs.length
    const adjList = new Map()

    for(let i = 0; i < n; i++) {
        let [a, b] = adjacentPairs[i]
        if(!adjList.has(a)) adjList.set(a, [])
        if(!adjList.has(b)) adjList.set(b, [])

        adjList.get(a).push(b)
        adjList.get(b).push(a)
    }

    // console.log('adjList', adjList)

    let start = null
    for(let [key, value] of adjList.entries()) {
        if(value.length === 1) {
            start = key
            break
        }
    }

    // console.log('start', start)

    const res = []
    let prev = start
    let cur = start
    while (cur !== undefined) {
        res.push(cur)
        let arr = adjList.get(cur)
        const next = arr[0] === prev ? arr[1] : arr[0]
        prev = cur
        cur = next
    }

    console.log(res)
    return res
};

let adjacentPairs

// adjacentPairs = [[2,1],[3,4],[3,2]]
// adjacentPairs = [[4,-10],[-1,3],[4,-3],[-3,3]]
adjacentPairs = [[4,-2],[1,4],[-3,1]]



restoreArray(adjacentPairs)