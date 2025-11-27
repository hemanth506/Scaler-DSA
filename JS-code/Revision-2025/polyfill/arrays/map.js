Array.prototype.myMap = function(fn) {
    const arr = []
    for (let idx = 0; idx < this.length; idx++) {
        const element = this[idx];
        arr.push(fn(element))
    }
    return arr
}


const res = [1,2,3,4,5].myMap((a) => a * 3)
console.log(res);