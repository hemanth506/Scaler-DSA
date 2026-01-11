var countPairsTLE = function (words) { // TLE approach
    const n = words.length
    const m = words[0].length
    let ct = 0
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            let prev = null, isSame = true;
            for (let k = 0; k < m; k++) {
                let codeA = words[i][k].charCodeAt(0)
                let codeB = words[j][k].charCodeAt(0)
                if (codeA > codeB) {
                    codeB += 26
                }
                let cur = codeA - codeB
                if (prev !== null && prev !== cur) {
                    isSame = false
                    break;
                }
                prev = cur
            }
            if (isSame) {
                ct++
            }
        }
    }
    return ct
};

var countPairs = function (words) {
    const n = words.length, m = words[0].length
    let ct = 0, hm = new Map()
    for (let i = 0; i < n; i++) {
        const first = words[i].charCodeAt(m-1)
        let key = ''
        for (let j = 0; j < m - 1; j++) {
            let curDiff = ((words[i].charCodeAt(j) - first) + 26) % 26
            key += "#" + curDiff
        }
        let val = hm.get(key) || 0
        ct += val;
        hm.set(key, val + 1)
    }
    return ct
};
let words;
// words = ["fusion","layout"]
words = ["ab", "aa", "za", "aa"]
console.log(countPairs(words));