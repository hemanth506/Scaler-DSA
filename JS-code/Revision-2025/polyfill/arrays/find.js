Array.prototype.myFind = function(fn) {
    console.log(this);
    for(let i = 0; i < this.length; i++) {
        if(fn(this[i])) {
            return this[i]
        }
    }
    return undefined
} 

const arr = [1,2,3,8,5]
const res = arr.myFind((a) => a % 4 === 0)
console.log(res);


Array.prototype.myFindIndex = function(fn) {
    console.log(this);
    for(let i = 0; i < this.length; i++) {
        if(fn(this[i])) {
            return i
        }
    }
    return undefined
} 

const ar = [1,2,3,8,5]
const ress = ar.myFindIndex((a) => a % 4 === 0)
console.log(ress);