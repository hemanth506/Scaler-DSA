var numberOfSubstringsTLE = function (s) { // TLE
    const n = s.length
    const arr = Array(3).fill(0)
    const aCharCode = 'a'.charCodeAt(0)
    let ct = 0
    let p1 = 0
    while (p1 <= (n - 3)) {
        console.log('----p1-----', p1, s.charAt(p1))
        arr[s.charCodeAt(p1) - aCharCode]++
        let p2 = p1 + 1
        while (p2 < n) {
            console.log('p2', p2, s.charAt(p2))
            arr[s.charCodeAt(p2) - aCharCode]++
            console.log('arr', arr)
            if (arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1) {
                console.log('res', n - p2)
                ct += n - p2
                break
            }
            p2++
        }
        // arr[s.charCodeAt(p1) - aCharCode]--
        arr[0] = 0, arr[1] = 0, arr[2] = 0
        p1++
    }
    console.log('ct', ct)
    return ct
};


var numberOfSubstrings = function (s) {
    const n = s.length
    const arr = Array(3).fill(0)
    const aCharCode = 'a'.charCodeAt(0)
    let ct = 0, p1 = 0, p2 = 1
    arr[s.charCodeAt(p1) - aCharCode]++
    while(p1 < n || p2 < n) {
        while (p2 < n && (arr[0] < 1 || arr[1] < 1 || arr[2] < 1)) {
            arr[s.charCodeAt(p2) - aCharCode]++
            p2++
        }
        if(arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1) {
            ct += n - p2 + 1
            arr[s.charCodeAt(p1) - aCharCode]--
        }
        p1++
    }

    console.log('ct', ct)
    return ct
};

let s;

// s = "abcabc"
// s = "aaacb"
s = "abc"

numberOfSubstrings(s)