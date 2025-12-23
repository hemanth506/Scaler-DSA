var maxTwoEventsDP = function (events) { // TC = O(N*2 + NlogN + NlogN)
    const dp = new Map()
    events.sort((a, b) => a[0] - b[0])
    const n = events.length

    function getNextI(i) {
        let l = i + 1, h = n - 1;
        let nextI = n
        while (l <= h) {
            let m = Math.floor((l + h) / 2)
            if (events[i][1] < events[m][0]) {
                nextI = m
                h = m - 1
            } else {
                l = m + 1
            }
        }
        return nextI
    }

    function solve(i, event) {
        if (event === 2 || i >= n) {
            return 0
        }
        const key = i + "_" + event
        if (!dp.has(key)) {
            const nextI = getNextI(i)
            let pick = solve(nextI, event + 1) + events[i][2]
            let leave = solve(i + 1, event)
            dp.set(key, Math.max(pick, leave))
        }
        return dp.get(key)
    }
    const res = solve(0, 0, 0)
    return res
};

var maxTwoEvents = function (events) { // TC = O(NlogN + NLogN)
    events.sort((a, b) => a[0] - b[0])
    const n = events.length

    const suff = Array(n)
    suff[n-1] = events[n-1][2]
    for(let i = n-2; i >= 0; i--) {
        suff[i] = Math.max(suff[i+1], events[i][2])
    }

    function getSecond (i) {
        let l = i + 1, h = n - 1, second = n;
        while(l <= h) {
            const m = Math.floor((l+h) / 2)
            if(events[i][1] < events[m][0]) {
                second = m
                h = m - 1
            } else {
                l = m + 1
            }
        }
        return second
    }
    let max = -Infinity
    for(let i = 0; i < n; i++) {
        const first = events[i][2]
        const second = getSecond(i)
        const val = (second === n) ? first : (first + suff[second])
        max = Math.max(max, val)
    }
    return max
}


let events;
// events = [[1, 3, 2], [4, 5, 2], [2, 4, 3]]
// events = [[1, 3, 2], [4, 5, 2], [1, 5, 5]]
// events = [[1,5,3],[1,5,1],[6,6,5]]
events = [[66, 97, 90], [98, 98, 68], [38, 49, 63], [91, 100, 42], [92, 100, 22], [1, 77, 50], [64, 72, 97]]
console.log(maxTwoEvents(events));