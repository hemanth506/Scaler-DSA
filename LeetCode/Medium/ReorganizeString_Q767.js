var reorganizeString1 = function(s) { 
    const n = s.length
    let ss = s.split('')
    for(let i = 0; i < n - 1; i++) {
        if(ss[i] === ss[i+1]) {
            let pos = -1
            let j;
            for(j = i+1; j < n; j++) {
                if(ss[i] !== ss[j]) {
                    pos = j
                    break
                }
            }
            if(pos !== -1) {
                let temp = ss[i+1]
                ss[i+1] = ss[j]
                ss[j] = temp

            } else {
                return ""
            }
        }
    }

    return ss.join("")
};


var reorganizeString2 = function(s) { 
    const n = s.length
    let ss = s.split('')
    const hm = new Map()
    for(let ch of s) {
        hm.set(ch, (hm.get(ch) || 0) + 1)
    }
    const arr = Array(...hm)
    arr.sort((a,b) => b[1] - a[1])

    console.log(arr);
    if(ss[0] !== arr[0][0]) {
        let pos = -1
        for(let i = 0; i < n; i++) {
            if(ss[i] === arr[0][0]) {
                pos = i
                break
            }
        }
        let temp = ss[0]
        ss[0] = ss[pos]
        ss[pos] = temp
    }
    console.log(ss);
    for(let i = 0; i < n - 1; i++) {
        if(ss[i] === ss[i+1]) {
            let pos = -1
            let j;
            for(j = i+1; j < n; j++) {
                if(ss[i] !== ss[j]) {
                    pos = j
                    break
                }
            }
            if(pos !== -1) {
                let temp = ss[i+1]
                ss[i+1] = ss[j]
                ss[j] = temp

            } else {
                return ""
            }
        }
    }
    console.log(ss.join(""));
    return ss.join("")
};


var reorganizeString = function(s) { 
    const hm = new Map()
    for(let ch of s) {
        hm.set(ch, (hm.get(ch) || 0) + 1)
    }
    const str = []
    const pq = Array(...hm)
    let prev = ''
    pq.sort((a,b) => b[1] - a[1])
    while(pq.length > 0) {
        console.log(pq);
        if(prev === pq[0][0]) {
            if(pq.length === 1) {
                console.log('empty');
                return ""
            }
            str.push(pq[1][0])
            prev = pq[1][0]
            pq[1][1]--
        } else {
            str.push(pq[0][0])
            prev = pq[0][0]
            pq[0][1]--
        }
        pq.sort((a,b) => b[1] - a[1])
        if(pq[pq.length - 1][1] === 0) {
            pq.pop()
        }
    }
    console.log(str);
    return str.join("")
}


let s;
// s = "aab"
s = "aaab"
// s = "aabbccddeeff"
// s = "babaa"
// s = "blflxll"
reorganizeString(s)