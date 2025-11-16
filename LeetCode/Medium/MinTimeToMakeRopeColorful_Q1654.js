var minCost = function(colors, neededTime) {
    const n = colors.length

    const arr = colors.split("").map((color, i) => [color, neededTime[i]])
    const stk = [arr[0]]
    let tt = 0
    for(let i = 1; i < n; i++) {
        const top = stk[stk.length - 1]
        const cur = arr[i]

        if(top[0] === cur[0]) {
            if(top[1] < cur[1]) {
                stk.pop()
                stk.push(cur)
                tt += top[1]
            } else {
                tt += cur[1]
            }
        } else {
            stk.push(cur)
        }
    }

    return tt
};

let colors, neededTime;
// colors = "abaac", neededTime = [1,2,3,4,5]
// colors = "abc", neededTime = [1,2,3]
colors = "aabaa", neededTime = [1,2,3,4,1]

console.log(minCost(colors, neededTime));