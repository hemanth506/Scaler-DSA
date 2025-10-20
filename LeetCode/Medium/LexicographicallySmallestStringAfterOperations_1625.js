var findLexSmallestString = function (s, a, b) {
    const n = s.length
    const hs = new Set()
    hs.add(s)
    let curSmall = s

    function solve(curS) {
        let newAddS = ""
        for (let i = 0; i < n; i++) {
            if (i % 2 === 1) {
                newAddS += "" + (Number(curS.charAt(i)) + a) % 10
            } else {
                newAddS += curS.charAt(i)
            }
        }
        if (!hs.has(newAddS)) {
            curSmall = curSmall > newAddS ? newAddS : curSmall
            hs.add(newAddS)
            solve(newAddS)
        }

        let newSwiftS = curS.slice(-b) + curS.slice(0, -b)
        console.log(curS, newSwiftS)
        if (!hs.has(newSwiftS)) {
            curSmall = curSmall > newSwiftS ? newSwiftS : curSmall
            hs.add(newSwiftS)
            solve(newSwiftS)
        }
    }

    solve(s)
    console.log(hs, curSmall)
    return String(curSmall)
};

let s, a, b;

// s = "74", a = 5, b = 1
// s = "5525", a = 9, b = 2
s = "0011", a = 4, b = 2
findLexSmallestString(s,a,b)
