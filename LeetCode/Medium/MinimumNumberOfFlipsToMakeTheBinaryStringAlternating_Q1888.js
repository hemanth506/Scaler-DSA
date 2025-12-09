// Concat s + s, and compare with the required strings "0101.." and "1010.."
var minFlips = function (s) { 
    const fullS = s + "" + s;
    const m = s.length
    const n = fullS.length;
    const zeroStr = [], oneStr = []

    for (let i = 0; i < n; i++) {
        zeroStr.push(i % 2 === 0 ? '0' : '1');
        oneStr.push(i % 2 === 0 ? '1' : '0');
    }

    let zeroDiff = 0, oneDiff = 0;

    for (let i = 0; i < m; i++) {
        if (fullS[i] != zeroStr[i]) zeroDiff++;
        if (fullS[i] != oneStr[i]) oneDiff++;
    }

    let minSwaps = Math.min(zeroDiff, oneDiff);

    for (let i = m, j = 0; i < n; i++, j++) {
        if(zeroStr[j] != fullS[j]) zeroDiff--;
        if(oneStr[j] != fullS[j]) oneDiff--;

        if (fullS[i] != zeroStr[i]) zeroDiff++;
        if (fullS[i] != oneStr[i]) oneDiff++;

        minSwaps = Math.min(minSwaps, zeroDiff, oneDiff)
    }
    console.log(minSwaps);
    return minSwaps
}

let s;
// s = "111000"
// s = "010"
// s = "1110"
s = "01001001101"
minFlips(s)