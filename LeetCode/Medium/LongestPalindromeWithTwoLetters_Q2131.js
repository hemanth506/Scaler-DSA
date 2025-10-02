var longestPalindrome = function(words) {
    const n = words.length
    const hmSame = new Map()
    const hmDiff = new Map()

    for(let i = 0; i < n; i++) {
        let curWord = words[i]
        if (curWord.charAt(0) === curWord.charAt(1)) {
            hmSame.set(curWord, (hmSame.get(curWord) || 0) + 1)
        } else {
            hmDiff.set(curWord, (hmDiff.get(curWord) || 0) + 1)
        }
    }

    let ct = 0
    for(let key of hmDiff.keys()) {
        const cor = key.charAt(0) + key.charAt(1)
        const rev = key.charAt(1) + key.charAt(0)

        if(hmDiff.has(cor) && hmDiff.has(rev)) {
            let val = Math.min(hmDiff.get(cor), hmDiff.get(rev))
            ct += (val * 4)
            hmDiff.delete(rev)
        }
        hmDiff.delete(cor)
    }

    if(hmSame.size > 0) {
        let evenCt = 0
        let oddCt = 0
        let oddVal = 0
        for(let value of hmSame.values()) {
            if(value % 2 === 1) {
                oddCt += 1
                oddVal += value
            } else {
                evenCt += value
            }
        }
        ct += (evenCt * 2)
        if(oddCt) {
            ct += ((oddVal - oddCt + 1) * 2)
        }
    }
    
    return ct
};

let words;

// words = ["lc", "lc", "cl", "gg", "cc", "cc", "gl", "lg", "ab", "ab"]
// words = ["lc","cl","gg","cl"]
// words = ["ab","ty","yt","lc","cl","ab"]
// words = ["dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"]
words = ["bb","bb"]
longestPalindrome(words)