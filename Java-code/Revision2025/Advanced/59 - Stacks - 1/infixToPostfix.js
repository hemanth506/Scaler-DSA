function infix2Postfix(A) {
    const stack = []
    let prefix = ''
    const aCode = 'a'.charCodeAt(0)
    const zCode = 'z'.charCodeAt(0)
    const map = new Map()
    map.set('+', 1)
    map.set('-', 1)
    map.set('*', 2)
    map.set('/', 2)
    map.set('^', 3)

    for(let i = 0; i < A.length; i++) {
        const curChar = A.charAt(i)
        if(curChar.charCodeAt(0) >= aCode && curChar.charCodeAt(0) <= zCode) {
            prefix += curChar
        } else if (curChar === '(') {
            stack.push(curChar)
        } else if (curChar === ')') {
            while (stack[stack.length - 1] !== '(') {
                prefix += stack[stack.length - 1]
                stack.pop()
            }
            stack.pop() // '('
        } else {
            while (stack[stack.length - 1] !== '(' && compare(map, stack[stack.length - 1], curChar)) {
                prefix += stack[stack.length - 1]
                stack.pop()
            }
            stack.push(curChar)
        }
    }

    while (stack.length !== 0) {
        prefix += stack[stack.length - 1]
        stack.pop()
    }

    return prefix
}

function compare(map, stackTop, incoming) {
    if(map.get(stackTop) >= map.get(incoming)) {
        return true // pop and push
    } 
    return false // push
}

// infix2Postfix("x^y/(a*z)+b")
infix2Postfix("a+b*(c^d-e)^(f+g*h)-i")