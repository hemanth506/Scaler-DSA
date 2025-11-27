import { rejectFn, resolveFn } from "../utils.js";

Promise.myRace = (prom = []) => {
    return new Promise((resolve, reject) => {
        if (prom.length === 0) throw Error('No Promises available');
        prom.forEach(p => {
            p.then(resolve).catch(reject)
        })
    })
}

console.time("promise");
Promise.myRace([rejectFn(5), rejectFn(3), rejectFn(1), resolveFn(7)]).then((data) => {
    console.log('Promises resolved', data);
    console.timeEnd('promise')
}).catch(err => {
    console.log('Promises rejected', err);
    console.timeEnd('promise')
}).finally(() => console.log('completed'))
