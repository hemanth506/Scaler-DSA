var highestPeak = function(isWater) {
    const n = isWater.length
    const m = isWater[0].length

    const country = Array.from({length: n}, () => Array(m).fill(-1))
    const que = []
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(isWater[i][j] === 1) {
                country[i][j] = 0
                que.push([[i,j], 0])
            } 
        }
    }

    while(que.length > 0) {
        const [[x, y], h] = que.shift()

        if((x+1) < n && country[x+1][y] === -1) {
            country[x+1][y] = h + 1
            que.push([[x+1, y], h+1])
        }

        if((x-1) >= 0 && country[x-1][y] === -1) {
            country[x-1][y] = h + 1
            que.push([[x-1, y], h+1])
        }

        if((y+1) < m &&country[x][y+1] === -1) {
            country[x][y+1] = h + 1
            que.push([[x, y+1], h+1])
        }

        if((y-1) >= 0 &&country[x][y-1] === -1) {
            country[x][y-1] = h + 1
            que.push([[x, y-1], h+1])
        }
    }

    return country
};

let isWater;
// isWater = [[0,1],[0,0]]
isWater = [[0,0,1],[1,0,0],[0,0,0]]
highestPeak(isWater)