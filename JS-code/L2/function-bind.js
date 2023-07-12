function printthis() {
    console.log(this);
}
printthis();
console.log("==============");

let obj = { a: 1, b: "hemanth"};
console.log(printthis.bind(obj))
let func1 = printthis.bind(obj);
func1();
console.log("==============");


console.log(func1());
console.log(func1);
