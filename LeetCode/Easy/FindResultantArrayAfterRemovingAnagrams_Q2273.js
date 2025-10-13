var removeAnagrams = function(words) {
    const n = words.length
    const wordFreqArr = []
    for(let i = 0; i < n; i++) {
        const wordFreq = Array(26).fill(0)
        for(let char of words[i]) {
            const idx = char.charCodeAt(0) - 'a'.charCodeAt(0)
            wordFreq[idx]++
        }
        wordFreqArr.push(wordFreq)
    }
    // console.log('wordFreqArr', wordFreqArr)

    function compare(wordA, wordB) {
        for(let i = 0; i < 26; i++) {
            if(wordA[i] !== wordB[i]) return false;
        }
        return true
    }

    const result = []
    for(let i = 0; i < n; i++) {

        let j = i + 1
        console.log(i, j)
        while(j < n && compare(wordFreqArr[i], wordFreqArr[j])) {
            j++
        }
        console.log('j', j)
        result.push(i)
        i = j - 1
    }
    console.log(result)

    const resultArr = result.map(idx => words[idx])
    console.log(resultArr)
    return resultArr
};


let words;

// words = ["abba","baba","bbaa","cd","cd"]
words = ["a","b","c","d","e"]
removeAnagrams(words)