var nextBeautifulNumber = function(n) {
    let isBalanced = false
    n++

    while (!isBalanced) {
        let str = String(n)
        let hm = new Map()
        for(let char of str) {
            hm.set(char, (hm.get(char) || 0) + 1)
        }
        let localBalanced = true
        for(let [key, val] of hm.entries()) {
            if(key != val) {
                localBalanced = false
                break;
            }
        }
        isBalanced = localBalanced
        n++;
    }
    n--;

    return n
};
let n;

// n = 1
n = 100000

console.log(nextBeautifulNumber(n));