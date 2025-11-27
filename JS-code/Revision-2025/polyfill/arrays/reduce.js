Array.prototype.myReduce = function(fn, initial) {
    let prev = initial
    for (let idx = 0; idx < this.length; idx++) {
        const cur = this[idx];
        prev = fn(prev, cur)
    }
    return prev
}


const res = [1,2,3,4,5].myReduce((prev, cur) => prev * cur, 1)
console.log(res);