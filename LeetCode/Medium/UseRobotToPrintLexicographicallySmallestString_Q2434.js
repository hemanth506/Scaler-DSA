var robotWithString = function (s) {
    const n = s.length
    const aCharCode = "a".charCodeAt(0)
    const freq = Array(26).fill(0)

    for (let i = 0; i < n; i++) { freq[s.charCodeAt(i) - aCharCode]++ }

    console.log('freq', freq)
    let curSmallIdx = 0
    while (curSmallIdx < 26 && freq[curSmallIdx] === 0) { curSmallIdx++ };

    const stack = []
    const res = []

    for (let i = 0; i < n; i++) {
        const curSCharIdx = s.charCodeAt(i) - aCharCode

        stack.push(s.charAt(i))
        freq[curSCharIdx]--


        while (curSmallIdx < 26 && freq[curSmallIdx] === 0) {
            curSmallIdx++
        }

        console.log('curSmallIdx', curSmallIdx)

        while (stack.length > 0) {
            let topIdx = stack[stack.length - 1].charCodeAt(0) - aCharCode
            if (topIdx <= curSmallIdx) {
                res.push(stack.pop())
            } else {
                break
            }
        }

    }

    console.log('stack', stack)
    console.log('res', res)


    while (stack.length > 0) {
        res.push(stack.pop())
    }

    const resStr = res.join("")
    console.log('resStr', resStr)
    return resStr
};
let s;

// s = "zza"
// s = 'bac'
// s = 'bdda'
// s='dcabdcab'
// s = 'abdcabc'
// s = "cbaacb"
s = "zzxyxzy"
robotWithString(s)