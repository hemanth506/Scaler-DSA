// -------- Execute first call ---------

function throttle(fn, delay) {
     let flag = false
     let timer
    return function() {
        if(flag) return;
        flag = true
        if(timer) clearTimeout(timer)
        timer = setTimeout(() => {
            fn()
            flag = false
        }, delay)
    }
}
const throttled = throttle(() => { throw new Error("Errored") }, 1000);
throttled(); // runs immediately
throttled(); // ignored
throttled(); // ignored


// -------- Execute last call ---------

// function throttle(delay) {
//      let flag = false
//      let lastCall
//     return function(fn) {
//         lastCall = fn
//         if(flag) return;
//         flag = true
//         setTimeout(() => {
//             lastCall()
//             flag = false
//         }, delay)
//     }
// }

// const throttled = throttle(1000);

// throttled(() => console.log('run 1')); 
// throttled(() => console.log('run 2'));
// throttled(() => console.log('run 3')); 








