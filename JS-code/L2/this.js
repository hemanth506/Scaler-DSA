/*
    this ==>
        refers to the variables under its scope.
        If "this" is used 
            inside an function then the scope of variable inside that function is returned
            inside an object then the scope of variable inside that object is returned
            inside a file then it is returned as empty object
            But when it comes to browser, it return all the scope which is inside that web page.

*/

let x = "hemanth";
console.log(this);
// console.log(globalThis);

// console.log("====================================");
temp();

function temp() {
    let x = 10;
    this.x = x;
    console.log(this);
    console.log(globalThis == this);
}



let obj = {
    a: "hello",
    b: 10,
    c: {
        ca: "Hi",
        cb: 5,
        cc: temp
    },
    d: temp
}

obj.d();
obj.c.cc();