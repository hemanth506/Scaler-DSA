let a = true;

setTimeout(() => {
    a = false;
}, 2000);

while(a) {
    console.log("running...!")
}