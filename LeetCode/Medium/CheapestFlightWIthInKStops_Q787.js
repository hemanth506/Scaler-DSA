var findCheapestPrice = function (n, flights, src, dst, k) { // djistras algo, but can solve using bellmanford also
    const adjList = new Map()

    for (let [from, to, cost] of flights) {
        if (!adjList.has(from)) adjList.set(from, [])
        adjList.get(from).push([to, cost])
    }

    const minCostToReactCity = Array(n).fill(Infinity)
    minCostToReactCity[src] = -Infinity

    const minHeap = []
    let minCostToReachDest = Infinity

    const srcArr = adjList.get(src)
    for (let i = 0; i < srcArr.length; i++) {
        const flightDetails = [0, srcArr[i][0], srcArr[i][1]]
        minHeap.push(flightDetails)
    }

    while (minHeap.length > 0) {
        minHeap.sort((a, b) => b[0] - a[0])
        const [stop, to, cost] = minHeap.pop()
        if (to === dst && stop <= k) {
            minCostToReachDest = Math.min(minCostToReachDest, cost)
        }
        if (minCostToReactCity[to] <= cost) {
            continue; // already reached in less cost
        }

        minCostToReactCity[to] = cost
        if (adjList.has(to)) {
            const arr = adjList.get(to)
            for (let i = 0; i < arr.length; i++) {
                const flightDetails = [stop + 1, arr[i][0], arr[i][1] + cost]
                minHeap.push(flightDetails)
            }
        }
    }
    return minCostToReachDest
};

let n, flights, src, dst, k;
n = 5, flights = [[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200], [2, 4, 50], [4, 3, 50]], src = 0, dst = 3, k = 3; // 300
// n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1; // 700
// n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1 // 200
// n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0 // 500
// n = 4, flights = [[0,1,1],[0,2,5],[1,2,1],[2,3,1]], src = 0, dst = 3, k = 1 // 6

console.log(findCheapestPrice(n, flights, src, dst, k));