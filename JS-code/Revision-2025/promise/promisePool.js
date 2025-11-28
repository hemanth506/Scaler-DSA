function resolvePromise(id, delay) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(`Resolved promise ${id}`);
    }, delay * 1000);
  });
}

function rejectPromise(id, delay) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      reject(`Rejected promise ${id}`);
    }, delay * 1000);
  });
}

function promisePool(promises = []) {
  let poolSize = 3;
  let curPoolSize = 0;
  let i = -1;
  let n = promises.length;
  return new Promise((resolve, reject) => {
    function runNext() {
      while (curPoolSize < poolSize && i < n - 1) {
        curPoolSize++;
        i++;

        const [prom, id, delay] = promises[i];
        prom(id, delay)
          .then(console.log)
          .catch(console.error)
          .finally(() => {
            curPoolSize--;
            runNext();
            if (i === n - 1 && curPoolSize === 0) {
              resolve();
            }
          });
      }
    }
    runNext();
  });
}
console.time("all prom");
promisePool([
  [resolvePromise, 1, 10],
  [resolvePromise, 2, 3],
  [rejectPromise, 3, 1],
  [resolvePromise, 4, 8],
  [rejectPromise, 5, 7],
  [resolvePromise, 6, 15],
  [rejectPromise, 7, 0],
  [resolvePromise, 8, 12],
  [resolvePromise, 11, 10],
  [resolvePromise, 12, 3],
  [rejectPromise, 13, 1],
  [resolvePromise, 14, 8],
  [rejectPromise, 15, 7],
  [resolvePromise, 16, 15],
  [rejectPromise, 17, 0],
  [resolvePromise, 18, 12],
]).then(() => {
  console.timeEnd("all prom");
  console.log("Completed all promises");
});
