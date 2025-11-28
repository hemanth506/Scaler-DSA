const once = function (fn) {
    let isExecuted = false
    return function () {
        if (isExecuted) return;
        isExecuted = true
        return fn(...arguments)
    }
}

// No matter how many times it is called, it will execute once
const marry = once((a, b) => console.log(`Marriage Between ${a} and ${b}`))
marry('Hemanth', 'Ruchika')
marry('Hemanth', 'Ruchika')

marry('Hemanth', 'Ruchika')
marry('Hemanth', 'Ruchika')
marry('Hemanth', 'Ruchika')
marry('Hemanth', 'Ruchika')
marry('Hemanth', 'Ruchika')
