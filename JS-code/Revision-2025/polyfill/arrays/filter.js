
Array.prototype.myFilter = function(fn) {
    const finalArr = []
    for (let i = 0; i < this.length; i++) {
        const element = this[i];
        if(fn(element)) {
            finalArr.push(element)
        }
    }

    return finalArr
}



const res = [1,2,3,4,5,6].myFilter((a) => (a % 3) === 0)
console.log(res);