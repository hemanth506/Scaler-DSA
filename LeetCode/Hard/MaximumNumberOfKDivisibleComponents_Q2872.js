var maxKDivisibleComponents = function(n, edges, values, k) {
    const visited = Array(n).fill(false);
    const adjArr = Array.from({ length: n}, () => [])
    let ct = 0

    for(let [v, u] of edges) {
        adjArr[v].push(u)
        adjArr[u].push(v)
    }

    function dfs(nd) {
        if(visited[nd]) {
            return 0
        }

        visited[nd] = true;
        let sum = values[nd]
        for(let adj of adjArr[nd]) {
            sum += dfs(adj)
        }

        if((sum % k) === 0) {
            ct += 1;
            return 0
        }

        return sum
    }

    for(let i = 0; i < n; i++) {
        if(!visited[i]) {
            dfs(i)
        }
    }

    return ct;
};
let n, edges, values, k;

n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
// n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3

console.log(maxKDivisibleComponents(n, edges, values, k));