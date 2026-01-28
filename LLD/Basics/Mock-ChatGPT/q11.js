const tasks = [
    () => 1,
    () => Promise.resolve(2),
    () => Promise.reject('fail'),
    () => { throw 'oops'; }
];

const sleep = (ms) => new Promise(res => setTimeout(res, ms));

async function sequenceTasks(tasks) {
    const results = [];

    for (const task of tasks) {
        try {
            const value = await Promise.resolve().then(task);
            results.push({ status: 'fulfilled', value });
        } catch (err) {
            // Retry once after 100ms
            await sleep(100);
            try {
                const value = await Promise.resolve().then(task);
                results.push({ status: 'fulfilled', value });
            } catch (err2) {
                results.push({ status: 'rejected', reason: err2 });
            }
        }
    }

    return results;
}

// sequenceTasks(tasks).then(console.log);




const obj = {
  value: 10,
  getValue() {
    return this.value;
  }
};

const fn = obj.getValue.bind(obj);
console.log(fn());
