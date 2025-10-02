var longestDiverseString_TLE = function (a, b, c) { // TLE
    let maxLen = -Infinity;
    let resultStr = "";

    const arr = Array(a + b + c).fill("");

    function solve(a, b, c, i) {
        // update best so far
        const currentStr = arr.slice(0, i).join("");
        if (currentStr.length > maxLen) {
            maxLen = currentStr.length;
            resultStr = currentStr;
        }

        // no more letters
        if (a === 0 && b === 0 && c === 0) return;

        // check restriction: last two same
        if (i >= 2 && arr[i - 1] === arr[i - 2]) {
            // can’t place same as arr[i-1]
            if (arr[i - 1] !== "a" && a > 0) {
                arr[i] = "a";
                solve(a - 1, b, c, i + 1);
            }
            if (arr[i - 1] !== "b" && b > 0) {
                arr[i] = "b";
                solve(a, b - 1, c, i + 1);
            }
            if (arr[i - 1] !== "c" && c > 0) {
                arr[i] = "c";
                solve(a, b, c - 1, i + 1);
            }
        } else {
            // free to try all
            if (a > 0) {
                arr[i] = "a";
                solve(a - 1, b, c, i + 1);
            }
            if (b > 0) {
                arr[i] = "b";
                solve(a, b - 1, c, i + 1);
            }
            if (c > 0) {
                arr[i] = "c";
                solve(a, b, c - 1, i + 1);
            }
        }
    }

    solve(a, b, c, 0);
    return resultStr;
};

var longestDiverseString = function (a,b,c) { // Optimal way O(N)
    const maxHeap = new PriorityQueue((a, b) => b[0] - a[0])
    if(a !== 0) maxHeap.push([a, 'a'])
    if(b !== 0) maxHeap.push([b, 'b'])
    if(c !== 0) maxHeap.push([c, 'c'])
    let str = ''
    while (maxHeap.size() > 0) {
        const maxElt = maxHeap.pop()
        if(str.length >= 2 && str.charAt(str.length-1) === maxElt[1] && str.charAt(str.length-2) === maxElt[1]) {
            if(maxHeap.size() === 0) {
                break
            }
            const secMaxElt = maxHeap.pop()
            let secDescCt = secMaxElt[0] - 1
            str += secMaxElt[1]
            if(secDescCt > 0) {
                maxHeap.push([secDescCt, secMaxElt[1]])
            }
            maxHeap.push([maxElt[0], maxElt[1]])
        } else {
            let descCt = maxElt[0] - 1
            str += maxElt[1]
            if(descCt > 0) {
                maxHeap.push([descCt, maxElt[1]])
            }
        }
    }

    return str
}
let a, b, c;

a = 1, b = 1, c = 7

console.log(longestDiverseString(a, b, c))