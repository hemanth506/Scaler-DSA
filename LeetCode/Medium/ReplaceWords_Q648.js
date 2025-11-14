var replaceWords = function(dictionary, sentence) {
    class Trie {
        constructor(ch) {
            this.idx = -1;
            this.ch = ch;
            this.hm = new Map();
        }
    }

    function getIdx(word, root) {
        const n = word.length
        let temp = root, idx = -1, i = 0;
        while (temp && i < n && temp.hm.has(word[i])) {
            temp = temp.hm.get(word[i])
            if (idx === -1) {
                idx = temp.idx;
            }
            i++
        }

        return idx;
    }

    const root = new Trie('')
    for(let idx = 0; idx < dictionary.length; idx++) {
        temp = root;
        for(let ch of dictionary[idx]) {
            if(!temp.hm.has(ch)) {
                temp.hm.set(ch, new Trie(ch))
            }
            temp = temp.hm.get(ch)
        }
        temp.idx = idx
    }


    const res = []
    for(let word of sentence.split(" ")) {
        let idx = getIdx(word, root)
        if (idx === -1) {
            res.push(word)
        } else {
            res.push(dictionary[idx])
        }
    }

    return res.join(" ")
};

let dictionary, sentence;

// dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"

console.log(replaceWords(dictionary, sentence));