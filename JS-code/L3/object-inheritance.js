let a = {p: 10, q: 20}
let c = {k: 10}

let b = Object.create(a)

console.log(a, b)
console.log("b.p => ", b.p)
b.p = 12
console.log("b.p => ", b.p)

a.q = 25
console.log(a, b)

console.log("prototype => ", b.__proto__) 

// Multilevel inheritance/prototype
let o1 = {x: 10}
let o2 = Object.create(o1)
o2.y = 'asdsa'
let o3 = Object.create(o2)
o3.z = true
let o4 = Object.create(o3)

console.log(o4);
console.log(o4.__proto__);
console.log(o4.__proto__.__proto__);
console.log(o4.__proto__.__proto__.__proto__ == o1);
console.log(o4.__proto__.__proto__.__proto__.__proto__);
console.log(o4.__proto__.__proto__.__proto__.__proto__.__proto__ == null);





