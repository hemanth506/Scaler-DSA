var partitionLabels = function(s) {
    const n = s.length
    const idxMap = new Map()

    for(let i = n-1; i >= 0; i--) {
        if(!idxMap.has(s[i])) {
            idxMap.set(s[i], i)
        }
    }

    const arr = []
    for(let i = 0; i < n; i++) {
        let lastIdx = idxMap.get(s[i])
        for(let cur = i; cur <= lastIdx; cur++) {
            lastIdx = Math.max(lastIdx, idxMap.get(s[cur]))
        }
        arr.push(lastIdx - i + 1)
        i = lastIdx
    }

    console.log(arr);
    return arr
};

let s;
// s = "ababcbacadefegdehijhklij"
s = "eccbbbbdec"
partitionLabels(s)