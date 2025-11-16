var maxChunksToSorted = function(arr) {
    const n = arr.length
    let chunk = 0
    const hs = new Set()
    for(let i = 0; i < n; i++) {
        hs.add(arr[i])
        if(hs.has(i)) {
            let canChunk = true
            for(let [key] of hs.entries()) {
                if(i < key) {
                    canChunk = false;
                    break
                }
            }
            if(canChunk) {
                chunk++
                hs.clear()
            }
        }
    }

    return chunk
};