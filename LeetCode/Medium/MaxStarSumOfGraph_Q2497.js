var maxStarSum = function(vals, edges, k) {
    const n = vals.length;
    const adjArr = Array.from({ length: n }, () => []);

    for(let [u, v] of edges) {
        adjArr[u].push(vals[v])
        adjArr[v].push(vals[u])
    }

    let maxSum = -Infinity
    for(let i = 0; i < n; i++) {
        const neighbours = adjArr[i]

        neighbours.sort((a,b) => b - a)
        let sum = vals[i]
        for(let j = 0; j < Math.min(k, neighbours.length); j++) {
            if(neighbours[j] > 0) sum += neighbours[j]
        }
        maxSum = Math.max(maxSum, sum)
    }

    return maxSum
};
let vals, edges, k;

// vals = [1,2,3,4,10,-10,-20], edges = [[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]], k = 2
vals = [-5], edges = [], k = 0
console.log(maxStarSum(vals, edges, k));