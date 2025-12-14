var validateCoupons = function (code, businessLine, isActiveArr) {
    const businessSet = new Set(["electronics", "grocery", "pharmacy", "restaurant"])
    const constructedArr = businessLine.map((line, i) => {
        return [line, code[i], isActiveArr[i]]
    })

    console.log(constructedArr);
    constructedArr.sort((a, b) => {
        const aFirst = a[0][0].charCodeAt(0);
        const bFirst = b[0][0].charCodeAt(0)
        if (aFirst === bFirst) {
            return a[1].localeCompare(b[1])
        }
        return aFirst - bFirst
    })
    console.log(constructedArr);

    
    function isValidCode(word) {
        if (word === "") return false;

        const aCode = 'a'.charCodeAt(0)
        const zCode = 'z'.charCodeAt(0)
        const ACode = 'A'.charCodeAt(0)
        const ZCode = 'Z'.charCodeAt(0)
        const zeroCode = '0'.charCodeAt(0)
        const nineCode = '9'.charCodeAt(0)
        const underScoreCode = '_'.charCodeAt(0)

        for (let ch of word) {
            const curCharCode = ch.charCodeAt(0)
            if ((aCode <= curCharCode && curCharCode <= zCode) || (ACode <= curCharCode && curCharCode <= ZCode) || (zeroCode <= curCharCode && curCharCode <= nineCode) || curCharCode === underScoreCode) {
                continue
            } else {
                return false
            }
        }
        return true
    }

    const valid = []
    for (let [line, code, isActive] of constructedArr) {
        if (businessSet.has(line) && isValidCode(code) && isActive) {
            valid.push(code)
        }
    }

    return valid
};
let code, businessLine, isActive;
// code = ["SAVE20", "", "PHARMA5", "SAVE@20"], businessLine = ["restaurant", "grocery", "pharmacy", "restaurant"], isActive = [true, true, true, true]
code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]
code = ["pBXoMqBU0_aMgc9F8dy6TaSzza3KjSJFjxZa_NuyMjzEBR7fJNwpGHh7lzuoZvQeEUeo6YumHmIOjjchXlzSVa4ItdyDOImQgm","P8rIIUl35MW8yrqRbO0N_IITptYOxz9tOCbPL6d1aIF_hM2sapaDtUzNpmAZRmJQB1WgjLh8bdYADuSRSU21OzttUkq73qiA66","aFWkYookQlHYMXzhVGxbnrXIl1810ws3qHtketHSECHqJoktWXVZGc6ZyeOuzA_VL9zFL9znpIHwbkwJF2bOPQqsz3_0PYgETJ"], businessLine = ["pharmacy","invalid","pharmacy"], isActive = [true,true,true]


console.log(validateCoupons(code, businessLine, isActive));