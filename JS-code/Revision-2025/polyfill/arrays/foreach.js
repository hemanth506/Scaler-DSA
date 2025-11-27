export const resolveFn = (s) => {
    return new Promise((res, rej) => {
        setTimeout(() => res(s), s * 1000)
    })
}

Array.prototype.myForEach =  function(fn) {
    for (let idx = 0; idx < this.length; idx++) {
        fn(this[idx])
        console.log(idx);
    }
    return
}


const arr = [resolveFn(10),resolveFn(11),resolveFn(4),resolveFn(5)]
arr.myForEach((p) => {
    p.then((d) => console.log('Inside then', d)).catch(err => console.log(err))
})