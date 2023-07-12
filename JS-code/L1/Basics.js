console.log("Hemanth");
function createCounter(init, delta) {
    let x = init;
    let y = delta;
    function count() {
        x = x + y;
        return x;
    }
    return count;
}

const c1 = createCounter(10, 5);
const c2 = createCounter(2, 2);




console.log(c1(), c2(), c1());
