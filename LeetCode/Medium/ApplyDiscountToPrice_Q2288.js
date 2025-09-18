var discountPrices = function(sentence, discount) {
    const separateSent = sentence.split(" ")
    const discountFactor = 1 - discount / 100
    for(let i = 0; i < separateSent.length; i++) {
        let curWord = separateSent[i]
        if(curWord.charAt(0) === '$') {
            let valid = false
            for(let j = 1; j < curWord.length; j++) {
                if(!isNaN(curWord.charAt(j))) {
                    valid = true
                } else {
                    valid = false
                    break
                }
            }
            if(valid) {
                const strNum = curWord.slice(1)
                separateSent[i] = '$' + Number(strNum * (discountFactor)).toFixed(2)
            }
        }
    }
    return separateSent.join(" ")
}

const sent  = "$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999"
const discount = 0

// const sent = "$76111 ab $6 $"
// const discount = 48

// const sent = "there are $1 $2 and 5$ candies in the shop"
// const discount = 50

// const sent = "1 2 $3 4 $5 $6 7 8$ $9 $10$"
// const discount = 100

// const sent = "ka3caz4837h6ada4 r1 $602"
// const discount = 9

// const sent = "rzfd95ukmabzwu1d$wwt0huf$ixkepd97 i2ot 8"
// const discount = 67

console.log(discountPrices(sent, discount))