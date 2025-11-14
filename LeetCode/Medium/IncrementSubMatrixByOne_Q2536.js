var rangeAddQueries = function(n, queries) {
    const mat = Array.from({length: n}, () => Array(n).fill(0))

    for(let [a,b,c,d] of queries) {
        mat[a][b] += 1
        if((c+1) < n && (d+1) < n) {
            mat[c+1][d+1] += 1
        }

        if((d+1) < n) {
            mat[a][d+1] -= 1
        }

        if((c+1) < n) {
            mat[c+1][b] -= 1
        }
    }
    console.log('aggregated', mat);

    for(let i = 0; i < n; i++) {
        for(let j = 1; j < n; j++) {
            mat[i][j] += mat[i][j-1]
        }
    }
    console.log('check 2', mat);

    for(let i = 0; i < n; i++) {
        for(let j = 1; j < n; j++) {
            mat[j][i] += mat[j-1][i]
        }
    }

    console.log(mat);
    return mat;
};
let n, queries;

// n = 3, queries = [[1,1,2,2],[0,0,1,1]]
n = 2, queries = [[0,0,1,1]]

rangeAddQueries(n, queries)