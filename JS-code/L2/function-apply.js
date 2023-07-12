function printthis(arg1, arg2) {
    console.log(arg1, arg2);
    console.log(this);
}
// printthis();
console.log("==============");

let obj = { a: 1, b: "hemanth"};
printthis.apply(obj, [3, 7]);
// let func1 = printthis.call(obj); // -> cannot create new function, so will return not a function error
// func1();
console.log("==============");


// console.log(func1());  // --> return not a function error
