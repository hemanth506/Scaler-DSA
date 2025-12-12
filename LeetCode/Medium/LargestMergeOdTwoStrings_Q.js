var largestMerge = function (word1, word2) {
    const n = word1.length
    const m = word2.length
    let p1 = 0, p2 = 0, merge = ""
    while (p1 < n && p2 < m) {
        if (word1[p1] > word2[p2]) {
            merge += word1[p1];
            p1++
        } else if (word1[p1] < word2[p2]) {
            merge += word2[p2]
            p2++
        } else {

            if (word1.slice(p1) > word2.slice(p2)) {
                merge += word1[p1]
                p1++
            } else {
                merge += word2[p2]
                p2++
            }
        }
    }

    while (p1 < n) { merge += word1[p1]; p1++; }

    while (p2 < m) { merge += word2[p2]; p2++; }

    return merge

};

let word1, word2;

// word1 = "cabaa", word2 = "bcaaa"
// word1 = "abcabc", word2 = "abdcaba"
word1 = "uuurruuuruuuuuuuuruuuuu", word2 = "urrrurrrrrrrruurrrurrrurrrrruu"
console.log(largestMerge(word1, word2));