import { PriorityQueue } from "datastructures-js";

var minCost = function(n, edges) {
    const visitedArr = Array(n).fill(false)
    const adjList = new Map()
    for(let i = 0; i < edges.length; i++) {
        const [u, v, c] = edges[i]
        if (!adjList.has(u)) {
            adjList.set(u, [])
        }
        adjList.get(u).push([v, c])

        if (!adjList.has(v)) {
            adjList.set(v, [])
        }
        adjList.get(v).push([u, c*2])
    }

    const pq = new PriorityQueue((a, b) => a[1] - b[1])
    pq.enqueue([0, 0])
    let minCost = -1
    while(!pq.isEmpty()) {
        const [v, c] = pq.dequeue()
        visitedArr[v] = true
        if(v === (n-1)) {
            minCost = c
            break;
        }
        if(adjList.has(v)) {
            for(let [iv, ic] of adjList.get(v)) {
                if(!visitedArr[iv]) {
                    pq.enqueue([iv, ic + c])
                }
            }
        }
    }

    return minCost
};

let n, edges;
// n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
// n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]
n = 4, edges = [[2,3,25],[2,1,18],[3,1,2]]
console.log(minCost(n, edges));