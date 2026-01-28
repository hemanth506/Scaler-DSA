const tasks = [
  () => Promise.resolve(1),
  () => Promise.resolve(2),
  () => Promise.resolve(3)
];

function limitConcurrency(tasks, limit) {
  return new Promise((resolve, reject) => {
    const results = [];
    let running = 0;
    let index = 0;

    function next() {
      if (index === tasks.length && running === 0) {
        return resolve(results); // all tasks done
      }

      while (running < limit && index < tasks.length) {
        const currentIndex = index;
        const task = tasks[currentIndex];
        index++;
        running++;

        task()
          .then((res) => {
            results[currentIndex] = res;
          })
          .catch(reject)
          .finally(() => {
            running--;
            next(); // start next task
          });
      }
    }

    next(); // start initial tasks
  });
}


limitConcurrency(tasks, 2).then(console.log);

