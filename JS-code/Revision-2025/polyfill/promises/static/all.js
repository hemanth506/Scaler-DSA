import { rejectFn, resolveFn } from "../utils.js";


Promise.myAll = (prom = []) => {
    return new Promise(async (resolve, reject) => {
        if (prom.length === 0) throw Error("No promise available");
        const res = []
        for(let p of prom) {
            p.then((d) => {
                res.push(d) 
                if(res.length === prom.length) {
                    resolve(res)
                }
            }).catch((err) => { reject(err) })
        }
    })

}


console.time("promise");
Promise.myAll([resolveFn(5), resolveFn(3), resolveFn(1), resolveFn(7)]).then((data) => {
    console.log('Promises resolved', data);
    console.timeEnd('promise')
}).catch(err => {
    console.log('Promises rejected', err);
    console.timeEnd('promise')
}) 

console.log(Promise);
