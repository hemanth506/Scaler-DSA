var maxFreeTime = function(eventTime, k, startTime, endTime) {
    const n = startTime.length
    const meetings = []
    for(let i = 0; i < n; i++) {
        meetings.push([startTime[i], endTime[i]])
    }
    let lowerBound = 0
    let duration = 0
    let i = 0

    while (i < k) {
        duration += meetings[i][1] - meetings[i][0]
        i++
    }
    let higherBound = (i === n) ? eventTime : meetings[i][0]
    let span = higherBound - lowerBound
    console.log('span', span, 'duration', duration, 'span - duration =', span - duration)
    let maxFTime = Math.max(span - duration, 0)

    let j = 0
    while (i < n) {
        lowerBound = meetings[j][1]
        higherBound = ((i+1) === n) ? eventTime : meetings[i+1][0]
        duration -= meetings[j][1] - meetings[j][0]
        duration += meetings[i][1] - meetings[i][0]

        span = higherBound - lowerBound
        console.log('span', span, 'duration', duration, 'span - duration =', span - duration)
        maxFTime = Math.max(span - duration, maxFTime)
        i++
        j++
    }
    console.log(maxFTime)
    return maxFTime
};

let eventTime, k, startTime, endTime

// eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
// eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

maxFreeTime(eventTime, k, startTime, endTime)

