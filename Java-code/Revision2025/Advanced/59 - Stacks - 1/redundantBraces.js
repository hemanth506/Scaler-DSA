function redundantBraces(A){
    const stack = []

    for(let i = 0; i < A.length; i++) {
        const curChar = A.charAt(i)
        console.log('🚀 ~ redundantBraces.js:6 ~ redundantBraces ~ curChar:', curChar)
        if(curChar === '(' || curChar === '+' || curChar === '-' || curChar === '*' || curChar === '/') {
            console.log('Pushing to stack', curChar)
            stack.push(curChar)
        } else if(curChar === ')') {
            console.log('stack', stack)
            if(stack[stack.length - 1] === '(') {
                return 1
            }

            while (stack[stack.length - 1] !== '(') {
                stack.pop()
            }
            stack.pop() 
        }
    }

    return 0
}

const res = redundantBraces('(a+(a+b))')
console.log(res)