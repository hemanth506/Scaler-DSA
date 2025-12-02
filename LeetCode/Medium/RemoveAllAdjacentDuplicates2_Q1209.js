var removeDuplicates = function(s, k) {
    const n = s.length
    const arr = []
    let ct = 1
    for(let i = 1; i < s.length; i++) {
        if(s[i] !== s[i-1]) {
            arr.push([s[i-1], ct]);
            ct = 1
        } else {
            ct++
        }
    }
    arr.push([s[n-1], ct])
    const m = arr.length

    const stk = []
    for(let i = 0; i < m; i++) {
        if(stk.length > 0 && stk.at(-1)[0] === arr[i][0]) {
            const sumWithPrev = stk.at(-1)[1] + arr[i][1]
            stk[stk.length - 1] = [stk.at(-1)[0], sumWithPrev]
        } else {
            stk.push(arr[i])
        }

        if(stk.at(-1)[1] % k !== 0) {
            stk[stk.length - 1] = [stk.at(-1)[0], stk.at(-1)[1] % k]
        } else {
            stk.pop()
        }
    }

    console.log(stk);
    let completeStr = ""
    for(let [ch, ct] of stk) {
        let curStr = ''
        for(let i = 0; i < ct; i++) {
            curStr += ch
        }
        completeStr += curStr
    }

    return completeStr
};


let s, k;


// s = "abcd", k = 2
// s = "deeedbbcccbdaa", k = 3
s = "pbbcggttciiippooaais", k = 2
console.log(removeDuplicates(s, k));