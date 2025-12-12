var rotatedDigits = function(n) {
    let ct = 0
    let falseSet = new Set([3,4,7])
    let trueSet = new Set([2,5,6,9])

    for(let i = 1; i <= n; i++) {
        let valid = false;
        let num = i
        while (num > 0) {
            let digit = num % 10;

            if(falseSet.has(digit)) {
                valid = false;
                break
            } else if (trueSet.has(digit)) {
                valid = true
            }

            num = Math.floor(num / 10)
        }
        if(valid) ct++;
    }
    return ct;
};

let n; 

// n = 10
n = 2
console.log(rotatedDigits(n));