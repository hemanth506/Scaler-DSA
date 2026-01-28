const tasks = [
  () => Promise.resolve(1),
  () => Promise.reject('error'),
  () => new Promise(res => setTimeout(() => res(3), 100)),
];

Promise.allSettledWithLimit = ((tasks, limit) => {
    return new Promise((resolve, reject) => {
        let idx = 0
        let running = 0
        let finalArr = []

        function nextSet() {
            if(idx === tasks.length && running === 0) {
                resolve(finalArr)
            }
            while(running < limit && idx < tasks.length) {
                const curIdx = idx
                const task = tasks[curIdx]
                idx++
                running++

                task().then((res) => {
                    finalArr[curIdx] = { status: "fulfilled", value: res}
                }).catch((err) => {
                    finalArr[curIdx] = { status: "rejected", reason: err}
                }).finally(() => {
                    running--
                    nextSet()
                })
            }
        }

        nextSet()
    })
})


const res = await Promise.allSettledWithLimit(tasks, 2);
console.log(res);
/* Output:
[
  { status: 'fulfilled', value: 1 },
  { status: 'rejected', reason: 'error' },
  { status: 'fulfilled', value: 3 }
]
*/
