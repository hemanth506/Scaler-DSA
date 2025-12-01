var removeKdigits = function(num, k) {
    const n = num.length
    if (n === 1) {
        return "0"
    }
    const stk = [];
    const max = []
    for(let i = 0; i < n; i++) {
        while(stk.length > 0 && ((stk.at(-1) > num[i] && k > 0) || (max.at(-1) === 0))) {
            if(max.at(-1) !== 0) {
                k--;
            }
            stk.pop();
            max.pop();
        }

        if(stk.length === 0 && num[i] === 0) {
            continue;
        } else {
            stk.push(num[i]);
            let lastNum = max.length === 0 ? -Infinity : max.at(-1)
            max.push(Math.max(lastNum, Number(num[i])))
        }
    }
    while(k > 0) {
        k--
        stk.pop()
        max.pop()
    }
    return stk.length === 0 ? "0" : stk.join("")
};

let num, k;

// num = "1432219", k = 3;
// num = "10200", k = 1
num = "10", k = 2

console.log(removeKdigits(num, k));