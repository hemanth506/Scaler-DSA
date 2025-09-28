var punishmentNumber = function (n) {

    function solve(sqrStr, idx, prevSum, n, punishNum) {
        if(idx === n) {
            console.log(prevSum, punishNum)
            return prevSum === punishNum
        }

        for(let i = idx; i < n; i++) {
            const subStr = sqrStr.slice(idx, i+1)
            console.log(idx, i , "sqrStr", sqrStr, 'subStr', subStr)
            const curNum = Number(subStr)
            if(curNum <= punishNum) {
                const flag = solve(sqrStr, i + 1, prevSum + curNum, n, punishNum)
                if(flag) {
                    return true
                }
            }
        }

        return false
    }


    let total = 0
    for (let i = 1; i <= n; i++) {
        const square = i * i
        console.log('======square=======', square)
        const flag = solve(square.toString(), 0, 0, square.toString().length, i)
        if (flag) {
            total += square
        }
    }

    return total
};

let n;

// n = 10
n = 37


console.log(punishmentNumber(n))