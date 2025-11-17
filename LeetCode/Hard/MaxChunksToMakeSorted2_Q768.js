var maxChunksToSorted = function(arr) {
    const n = arr.length
    const idxArr = Array(n).fill(0)
    const visited = Array(n).fill(false)
    let minIdx = Infinity;
    
    for(let i = 0; i < n; i++) {
        let minVal = Infinity
        for(let j = 0; j < n; j++) {
            if(visited[j] === false && arr[j] < minVal) {
                minIdx = j;
                minVal = arr[j];
            }
        }
        visited[minIdx] = true
        idxArr[minIdx] = i
    }

    console.log(idxArr);

    let chunks = 0
    let hs = new Set()
    for(let i = 0; i < n; i++) {
        hs.add(idxArr[i])
        if(hs.has(idxArr[i])) {
            let canChunk = true
            for(let [key] of hs.entries()) {
                if(key > i) {
                    canChunk = false
                    break
                }
            }
            if(canChunk) {
                chunks++
                hs.clear()
            }
        }
    }
    console.log(chunks);
    return chunks
};

let arr;
// arr = [2,1,3,4,4]
// arr = [5,4,3,2,1]
arr = [4,0,0,2,4]

maxChunksToSorted(arr)