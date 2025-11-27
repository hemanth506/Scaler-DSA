Array.prototype.myFlatMap = function(fn) {
    function solve(cur, curLevel) {
        if(curLevel === 1) {
            return cur
        }

        let flatArr = []
        for(let i = 0; i < cur.length; i++) {
            const mappedVal = fn(cur[i])
            if(Array.isArray(mappedVal)) {
                flatArr = [...flatArr, ...solve(mappedVal, curLevel+1)]
            } else {
                flatArr.push(mappedVal)
            }
        }

        return flatArr
    }

    return solve(this, 0)
}

const arrToFlat = [1,2,[3,4,[5,6]], [7,8,[9,10]], [11,12,[13,14]], 15, 16]
// console.log(arrToFlat.myFlatMap((a) => ))

const actRes = arrToFlat.flatMap((a) => {
    if(Array.isArray(a)) {
        return a;
    }
    return a * 4
})
console.log(actRes);