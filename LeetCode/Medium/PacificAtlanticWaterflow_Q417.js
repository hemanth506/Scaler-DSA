var pacificAtlanticOld = function (heights) {
    const n = heights.length
    const m = heights[0].length
    const dp = [...Array(n)].map(() => [...Array(m)].fill(-1))

    function solve(i, j, prevVal) {
        if (i < 0 || j < 0 || j >= m || i >= n) {
            return true
        }

        // if()

        if (dp[i][j] === -1) {

            let pacific = solve(i, j - 1, heights[i][j]) || solve(i - 1, j, heights[i][j])

            let atlantic = solve(i, j + 1, heights[i][j]) || solve(i + 1, j, heights[i][j])

            dp[i][j] = pacific && atlantic
        }

        return dp[i][j]
    }
    solve(0, 0,)
    console.log('result ', dp)
};


var pacificAtlanticOld2 = function (heights) {
    const n = heights.length
    const m = heights[0].length

    function solve(i, j, prevVal, ocean) {

        if (i < 0 || j < 0 || j >= m || i >= n) {
            return true
        }

        if (heights[i][j] > prevVal) {
            return false
        }

        if (dp[i][j][ocean] === null) {
            const p1 = solve(i - 1, j, heights[i][j], ocean)
            const p2 = solve(i, j - 1, heights[i][j], ocean)
            const p3 = solve(i + 1, j, heights[i][j], ocean)
            const p4 = solve(i, j + 1, heights[i][j], ocean)

            dp[i][j][0] = p1 || p2 || p3 || p4
            dp[i][j][1] = a1 || a2 || a3 || a4
        }

        return dp[i][j][ocean]
    }

    let dp = [...Array(n)].map(() => [...Array(m)].map(() => [null, null]))
    for (let i = 0; i < n; i++) {
        solve(0, i, heights[0][i], 1)
    }
};

var pacificAtlantic = function (heights) {
    const n = heights.length;
    const m = heights[0].length;

    const pacificSet = new Set()
    const atlanticSet = new Set()


    function dfs(i, j, preVal, oceanSet) {
        if(oceanSet.has(i+'_'+j) || i < 0 || j < 0 || i === n || j === m || heights[i][j] < preVal) {
            return
        }

        oceanSet.add(i+'_'+j)
        dfs(i - 1, j, heights[i][j], oceanSet)
        dfs(i, j - 1, heights[i][j], oceanSet)
        dfs(i + 1, j, heights[i][j], oceanSet)
        dfs(i, j + 1, heights[i][j], oceanSet)
    }

    for(let j = 0; j < n; j++) {
        dfs(j, 0, heights[j][0], atlanticSet)
        dfs(j, m-1, heights[j][m-1], pacificSet)
    }

    for(let i = 0 ; i < m ;i++) {
        dfs(0, i, heights[0][i], atlanticSet)
        dfs(n-1, i, heights[n-1][i], pacificSet)
    }

    console.log(pacificSet, atlanticSet)
    const result = []
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            const str = i+'_'+j
            if(pacificSet.has(str) && atlanticSet.has(str)) {
                result.push([i, j])
            }
        }
    }
    console.log(result)
    return result
    
};


let heights

heights = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]
pacificAtlantic(heights)