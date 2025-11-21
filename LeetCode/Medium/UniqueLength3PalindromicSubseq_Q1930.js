var countPalindromicSubsequenceDP = function(s) { // TLE TC = O(2^N * N)
    const n = s.length
    const hs = new Set();
    const dp = new Set()

    const solve = (i, arr) => {
        if(arr.length === 3) {
            const arrStr = arr[0]+"_"+arr[1]
            if(arr[0] === arr[2] && !hs.has(arrStr)) {
                hs.add(arrStr)
            }
            return
        }

        if(i === n) return;

        const key = i+"_"+ arr.join("_")
        if(!dp.has(key)) {
            solve(i+1, arr)
            arr.push(s[i])
            solve(i+1, arr)
            arr.pop()
            dp.add(key);
        }
        return;
    }

    solve(0, [])
    return hs.size
};

var countPalindromicSubsequence = function(s) { // TC = O(26 * N)
    const n = s.length
    const idxMap = new Map()
    for(let i = 0; i < n; i++) {
        if(!idxMap.has(s[i])) {
            idxMap.set(s[i], i)
        }
    }

    const hs = new Set();
    let totalCt = 0, innerCt = 0;

    for(let [key, idx] of idxMap.entries()) {
        innerCt = 0;
        console.log(key, idx);
        for(let i = idx+1; i < n; i++) {
            if(key === s[i] && hs.size > 0) {
                innerCt = hs.size
            }
            hs.add(s[i])
        }
        hs.clear()
        totalCt += innerCt
    }

    return totalCt
}

let s;

// s = "aabca";
// s = "bbcbaba"
// s = "adc"
// s = "qqtgvawhekbkmcmqxmctxxtfiizmsmhaemqiapjyjlmbwyrhqcbkhswnrgvcxitejkmresjskaupcrqizyttidldwczknalvdlzcfzkoejjyzoavaxnwsqlkjontcelepojvrlhqywzucqqk"
s = "tqoqnurwfuocwyjumxqukyungrhxxraxaauvntieolokqkbylykskiegsddpktxveicaaudqozoatzqueqffvsujgbcdazwcyddgecvxfcukmqfkxqlehxrqwdijzpangdpnntfjxadcrdhfcsqmvlyxgfvszcupefsllphicjfjxvlxygkpwynkcvlegfjdiarsfoigbhffosyuroqrlvfbmbhdlppgaauoamdzanniamvkhiicumbhzmqxvycfvdzwsfcsvvnarbwbbhgrujsypdidpwxqrngmmhumctsjvgqwsbmfrmkmivtniysrwcdxklqfkblrypclccalgmnjdojfkliljbjyfeehpncbgccxognhwskkfvrmefqshaexqtwrereilzrlazwetajmawmbarhfntucuimjorglvhinrwvmhnqdkfzjapslfcxjchqoxzwexjipyhepsvduoujcaydrnhoembhlfvdmajvbdwunyoysdtlxhaygrkkxxxpelwudtgkfhhyleuvcnsnrjjmylxatcdxupjqxwbvdrmtnvchzcpvorwdpnssnozdxqeqsyuqfbdwngcankyhmegwgp"
console.log(countPalindromicSubsequence(s));