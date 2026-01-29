var minimumCost = function (source, target, original, changed, cost) {
    const aCode = 'a'.charCodeAt(0)
    const adjMat = Array.from({ length: 26 }, () => Array(26).fill(Infinity))

    for (let i = 0; i < 26; i++) { adjMat[i][i] = 0 }

    for (let i = 0; i < original.length; i++) {
        const u = original[i].charCodeAt(0) - aCode
        const v = changed[i].charCodeAt(0) - aCode
        adjMat[u][v] = Math.min(adjMat[u][v], cost[i])
    }

    for (let m = 0; m < 26; m++) {
        for (let i = 0; i < 26; i++) {
            for (let j = 0; j < 26; j++) {
                if (i === j || i === m || j === m || adjMat[i][m] === Infinity || adjMat[m][j] === Infinity) {
                    continue
                }
                adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][m] + adjMat[m][j])
            }
        }
    }

    let minCost = 0
    for (let i = 0; i < source.length; i++) {
        const x = source[i].charCodeAt(0) - aCode
        const y = target[i].charCodeAt(0) - aCode
        if (y === x) continue;
        if (adjMat[x][y] === Infinity) return -1;
        minCost += adjMat[x][y]
    }
    return minCost
};

let source, target, original, changed, cost;
// source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
// source = "aaaa", target = "bbbb", original = ["a","c","c"], changed = ["c","b","b"], cost = [1,2,1]
// source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
source = "abadcdadac", target = "baddbccdac", original = ["d", "c", "d", "c", "b", "a"], changed = ["b", "b", "c", "a", "d", "d"], cost = [8, 5, 9, 1, 10, 2]

console.log(minimumCost(source, target, original, changed, cost));