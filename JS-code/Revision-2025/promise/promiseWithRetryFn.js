function retryPromise(fn, maxLimit, delay) {
  return new Promise((resolve, reject) => {
    function callableFn(limit) {
      fn()
        .then(resolve)
        .catch(() => {
          if (limit >= maxLimit) {
            reject("Event completely rejected");
          } else {
            console.log("Retried", limit);
            setTimeout(() => callableFn(limit + 1), delay * 1000);
          }
        });
    }
    callableFn(0);
  });
}

console.time("prom");
const retryProm = retryPromise(() => Promise.reject("failed"), 3, 2)
  .then((res) => console.log("Completed"))
  .catch((err) => {
    console.log("Errored", err);
    console.timeEnd("prom");
  })
  .finally(() => console.log("Finally"));
