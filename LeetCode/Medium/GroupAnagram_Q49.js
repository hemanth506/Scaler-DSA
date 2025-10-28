var groupAnagrams = function(strs) {
    const freqArr = new Map()
    const aCode = 'a'.charCodeAt(0)

    for(let word of strs) {
        const wordArr = Array(26).fill(0)
        for(let ch of word) {
            wordArr[ch.charCodeAt(0) - aCode]++
        }
        const wordArrStr = wordArr.join(',')
        if(!freqArr.has(wordArrStr)) {
            freqArr.set(wordArrStr, [])
        }
        freqArr.get(wordArrStr).push(word)
    }

    console.log(Array.from(freqArr.values()));
    return Array.from(freqArr.values())
};

var groupAnagramsMap = function(strs) {
    const freqArr = []
    const finalArr = []

    for(let word of strs) {
        const wordMap = new Map()
        for(let ch of word) {
            wordMap.set(ch, (wordMap.get(ch) || 0) + 1)
        }
        let isAddedToFinal = false;
        for(let i = 0; i < freqArr.length; i++) {
            let isFound = true
            const curFreqMap = freqArr[i]
            console.log(curFreqMap.length);
            if(curFreqMap.size !== wordMap.size) {
                isFound = false
            } else {
                for(let [key, val] of curFreqMap.entries()) {
                    if(!wordMap.has(key) || (wordMap.has(key) && wordMap.get(key) !== val)) {
                        isFound = false
                        break
                    }
                }
            }
            console.log(isFound);
            if(isFound) {
                finalArr[i].push(word)
                isAddedToFinal = true
                break
            }
        }
        if(!isAddedToFinal) {
            freqArr.push(wordMap)
            finalArr.push([word])
        }
    }
    console.log(finalArr);
    return finalArr
}

let strs;
// strs = ["eat","tea","tan","ate","nat","bat"]
strs = ["","b"]
groupAnagrams(strs)