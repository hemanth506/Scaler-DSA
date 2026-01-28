/*
Implement retry(fn, retries, delay)
    fn → async function returning a promise
    retries → number of retries
    delay → wait time between retries (ms)

Behavior
    Call fn
    If it fails → wait delay ms → retry
    If all retries fail → reject with last error
    If it succeeds → resolve immediately
*/

function retry(fn, times, delay) {
    return new Promise((resolve, reject) => {
        let retryCt = 1
        function exe() {
            fn().then((result) => {
                resolve(result)
            }).catch((err) => {
                retryCt++
                if(retryCt === times) {
                    reject(err)
                    return
                }
                setTimeout(exe, delay)
            });
        }
        exe()
    })
}