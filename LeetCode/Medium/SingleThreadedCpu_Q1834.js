/**
 * @param {number[][]} tasks
 * @return {number[]}
 */
var getOrder = function (tasks) {
    const n = tasks.length;
    const enqueueMap = new Map();
    const timeToCompleteMap = new Map();
    const minHeap = new PriorityQueue((a, b) => { // PriorityQueue will work only in LeetCode
        if (a.processTime > b.processTime) return 1;
        else if (a.processTime < b.processTime) return -1;
        return a.index - b.index;
    });

    const uniqueTimes = new Set();

    for (let i = 0; i < n; i++) {
        const enqueueTime = tasks[i][0];
        if (!enqueueMap.has(enqueueTime)) {
            enqueueMap.set(enqueueTime, []);
        }
        enqueueMap.get(enqueueTime).push(i);
        uniqueTimes.add(enqueueTime);
    }

    const finalArr = [];
    let time = 1;
    let cpuProcessing = false;

    const timeHeap = new PriorityQueue((a, b) => a - b);
    for (let t of uniqueTimes) timeHeap.enqueue(t);

    while (enqueueMap.size > 0 || timeToCompleteMap.size > 0 || minHeap.size() > 0) {
        if (enqueueMap.has(time)) {
            const indArr = enqueueMap.get(time);
            for (let i = 0; i < indArr.length; i++) {
                minHeap.enqueue({ index: indArr[i], processTime: tasks[indArr[i]][1] });
            }
            enqueueMap.delete(time);
        }

        if (timeToCompleteMap.has(time)) {
            finalArr.push(timeToCompleteMap.get(time));
            timeToCompleteMap.delete(time);
            cpuProcessing = false;
        }

        if (cpuProcessing === false && minHeap.size() > 0) {
            let taskToProcess = minHeap.dequeue();
            if (taskToProcess) {
                let timeToComplete = taskToProcess.processTime + time;
                if (!uniqueTimes.has(timeToComplete)) {
                    timeHeap.enqueue(timeToComplete);
                    uniqueTimes.add(timeToComplete)
                }
                timeToCompleteMap.set(timeToComplete, taskToProcess.index);
                cpuProcessing = true;
            }
        }

        time = timeHeap.dequeue();
    }

    return finalArr;
};

// optimized solution
var getOrder = function (tasks) {
  if (!tasks || !tasks.length) return [];

  const n = tasks.length;

  const sortedTasks = tasks
    .map((e, i) => ({
      startTime: e[0],
      duration: e[1],
      index: i
    }))
    .sort((a, b) => a.startTime - b.startTime);

  const minQueue = new PriorityQueue((a, b) => {
    if (a.duration === b.duration) {
      return a.index - b.index;
    } else {
      return a.duration - b.duration;
    }
  })

  const result = [];
  let cpuStartTime = 0;
  let i = 0;
  while (!minQueue.isEmpty() || i < n) {
    if (
      minQueue.isEmpty()
      && cpuStartTime < sortedTasks[i].startTime
    ) cpuStartTime = sortedTasks[i].startTime;

    while (
      i < n
      && cpuStartTime >= sortedTasks[i].startTime
    ) {
      minQueue.enqueue(sortedTasks[i]);
      i++;
    }

    const nextTask = minQueue.dequeue();

    cpuStartTime += nextTask.duration;
    result.push(nextTask.index);
  }

  return result;
};