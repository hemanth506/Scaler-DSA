Array.prototype.myFlat = function(level = Infinity) {
    function solveFlat (cur, curLev) {
        if(curLev === level) {
            return cur
        }

        let flatArr = []
        for(let i = 0; i < cur.length; i++) {
            if(Array.isArray(cur[i])) {
                const flatternArr = solveFlat(cur[i], curLev + 1)
                flatArr = [...flatArr, ...flatternArr]
            } else {
                flatArr.push(cur[i])
            }
        }

        return flatArr
    }

    return solveFlat(this, 0)
}

const arrToFlat = [1,2,[3,4,[5,6]], [7,8,[9,10]], [11,12,[13,14]], [{a: 'Hemanth', b: 'Ruchi'}, 15, 16]]
console.log(arrToFlat.myFlat(1))