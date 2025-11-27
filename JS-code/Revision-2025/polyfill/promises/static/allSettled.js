import { rejectFn, resolveFn } from "../utils.js";

Promise.myAllSettled = (prom = []) => {
    return new Promise(async (resolve, reject) => {
        if (prom.length === 0) throw Error("No promise available");
        const res = Array(prom.length)
        let completed = 0
        prom.forEach((p, i) => {
            p.then((d) => {
                res[i] = { status: 'fulfilled', value: d}
                completed++
            }).catch((err) => {
                res[i] = { status: 'rejected', value: err}
                completed++
            }).finally(() => {
                if (completed === prom.length) {
                    resolve(res)
                }
            })
        })
    })
}


console.time("promise");
Promise.myAllSettled([resolveFn(5), resolveFn(3), rejectFn(1), resolveFn(7)]).then((data) => {
    console.log('Promises resolved', data);
    console.timeEnd('promise')
})
