Array.prototype.mySome = function(fn) {
    console.log(this);
    for(let i = 0; i < this.length; i++) {
        if(fn(this[i])) {
            return true
        }
    }
    return false
} 

const arr = [1,2,3,8,5]
const res = arr.mySome((a) => a % 4 === 0)
console.log(res);


Array.prototype.myEvery = function(fn) {
    console.log(this);
    for(let i = 0; i < this.length; i++) {
        if(!fn(this[i])) {
            return false
        }
    }
    return true
} 

const ar = [1,2,3,8,5]
const ress = ar.myEvery((a) => a % 5 === 0)
console.log(ress);