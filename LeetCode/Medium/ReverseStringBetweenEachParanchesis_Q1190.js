var reverseParentheses = function(s) {
    const stack = []
    const n = s.length
    for(let i = 0; i < n; i++) {
        if(s[i] === ')') {
            let str = ''
            while(stack[stack.length - 1] !== '(') {
                str += stack.pop()
            }
            stack.pop()
            for(let k = 0; k < str.length; k++) {
                stack.push(str[k])
            }
        } else {
            stack.push(s[i])
        }
    }

    return stack.join("")
};


let s;
// s = "(abcd)"
// s = "(u(love)i)"
s = "(ed(et(oc))el)"
console.log(reverseParentheses(s));