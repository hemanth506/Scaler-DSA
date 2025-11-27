import { rejectFn, resolveFn } from "../utils.js";

Promise.myAny = (prom = []) => {
    return new Promise((resolve, reject) => {
        if (prom.length === 0) throw Error('No Promises available');
        let failArr = []
        prom.forEach((p) => {
            p.then((d) => {
                resolve(d)
            }).catch(err => {
                failArr.push(err);
                if(failArr.length === prom.length) {
                    reject(failArr)
                }
            })
        })
    })
}

console.time("promise");
Promise.myAny([rejectFn(5), rejectFn(3), rejectFn(1), rejectFn(7)]).then((data) => {
    console.log('Promises resolved', data);
    console.timeEnd('promise')
}).catch(err => {
    console.log('Promises rejected', err);
    console.timeEnd('promise')
}) 
