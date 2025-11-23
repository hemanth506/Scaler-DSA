const { PriorityQueue } = require("datastructures-js");

var maxProbability = function(n, edges, succProb, start_node, end_node) {
    const adj = new Map()
    for(let i = 0; i < edges.length; i++) {
        const [src, dest] = edges[i]
        const prob = succProb[i]

        if(!adj.has(src)) adj.set(src, []);
        adj.get(src).push([dest, prob])

        if(!adj.has(dest)) adj.set(dest, []);
        adj.get(dest).push([src, prob])
    }

    if(!adj.has(start_node) || !adj.has(end_node)) {
        return 0
    }

    const reachedMap = new Map()
    const maxHeap = new PriorityQueue((a,b) => b[1] - a[1])
    maxHeap.enqueue([start_node, 1])
    let succ = 0

    while (!maxHeap.isEmpty()) {
        const [u, p] = maxHeap.dequeue()
        if(u === end_node) {
            succ = p
            break
        }
        if(!reachedMap.has(u)) {
            reachedMap.set(u, p)
            const len = adj.get(u).length;
            for(let i = 0; i < len; i++) {
                const [v, pr] = adj.get(u)[i]
                if(!reachedMap.has(v)) {
                    console.log([v, (pr * p)]);
                    maxHeap.enqueue([v, (pr * p)])
                }
            }
        }
    }

    return succ
};

let n, edges, succProb, start, end;


// n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2;
// n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
n = 500, edges = [[193,229],[133,212],[224,465]], succProb = [0.91,0.78,0.64], 


maxProbability(n, edges, succProb, start, end)