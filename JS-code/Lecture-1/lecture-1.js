// let varName = 10;

// function fn() {
//     console.log(varName);
// }

// function boo() {
//     let varName = 20;
//     fn()
//     console.log(varName);
// }

// boo()

// ==================================

let a = 10;
console.log("line 2 =", a);

function fn() {
    console.log("Line 4 = ", a);
    let a = 20;
    a++;
    console.log("line 7 = ", a);
    if(a) {
        let a = 30;
        a++;
        console.log("line 11 = ", a);
    }
    console.log("line 13 = ", a);
}
fn();
console.log("line 22 = ", a);