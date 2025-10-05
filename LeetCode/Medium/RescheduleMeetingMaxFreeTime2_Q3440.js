var maxFreeTimeTLE = function (eventTime, startTime, endTime) {
    const n = startTime.length

    const meetings = []
    for (let i = 0; i < n; i++) {
        meetings.push([startTime[i], endTime[i]])
    }
    console.log('meetings', meetings)
    meetings.sort((a, b) => a[0] - b[0])

    const freeSpace = []
    let lowerFreeSpace = 0
    for (let i = 0; i < n; i++) {
        const curMeeting = meetings[i]
        let upperFreeSpace = curMeeting[0]
        if (lowerFreeSpace !== upperFreeSpace) {
            freeSpace.push([lowerFreeSpace, upperFreeSpace])
        }
        lowerFreeSpace = curMeeting[1]
    }

    console.log('freeSpace', freeSpace)

    function canScheduleInAnotherWindow(curMeeting, lowerBound, higherBound) {
        const requiredBound = curMeeting[1] - curMeeting[0]
        for (let i = 0; i < freeSpace.length; i++) {
            const curFreeSpace = freeSpace[i]
            if (lowerBound <= curFreeSpace[0] && curFreeSpace[1] <= higherBound) {
                continue
            } else {
                let freeSpaceBound = curFreeSpace[1] - curFreeSpace[0]
                if (requiredBound <= freeSpaceBound) {
                    return true
                }
            }
        }
        return false
    }


    let maxFTime = 0
    for (let i = 0; i < n; i++) {
        // if we remove and place it somewhere else then the whole window is free
        let lowerBound = (i - 1) < 0 ? 0 : meetings[i - 1][1]
        let higherBound = (i + 1) === n ? eventTime : meetings[i + 1][0]
        const curMeeting = meetings[i]
        console.log(curMeeting, lowerBound, higherBound)

        let curFreeTime
        if (canScheduleInAnotherWindow(curMeeting, lowerBound, higherBound)) {
            curFreeTime = higherBound - lowerBound
        } else {
            curFreeTime = higherBound - lowerBound - (meetings[i][1] - meetings[i][0])
        }
        maxFTime = Math.max(maxFTime, curFreeTime)

    }
    console.log('maxFTime', maxFTime)

    return maxFTime
};


var maxFreeTime = function (eventTime, startTime, endTime) {
    const n = startTime.length

    const meetings = []
    for (let i = 0; i < n; i++) {
        meetings.push([startTime[i], endTime[i]])
    }
    console.log('meetings', meetings)
    meetings.sort((a, b) => a[0] - b[0])

    const freeGaps = [];
    let prevEnd = 0;

    for (let i = 0; i < n; i++) {
        const start = meetings[i][0];
        if (start > prevEnd) {
            freeGaps.push(start - prevEnd);
        } else {
            freeGaps.push(0);
        }
        prevEnd = meetings[i][1];
    }
    freeGaps.push(eventTime - meetings[n - 1][1]);

    const prefixMax = Array(freeGaps.length).fill(0);
    const suffixMax = Array(freeGaps.length).fill(0);

    prefixMax[0] = freeGaps[0];
    for (let i = 1; i < freeGaps.length; i++) {
        prefixMax[i] = Math.max(prefixMax[i - 1], freeGaps[i]);
    }

    suffixMax[freeGaps.length - 1] = freeGaps[freeGaps.length - 1];
    for (let i = freeGaps.length - 2; i >= 0; i--) {
        suffixMax[i] = Math.max(suffixMax[i + 1], freeGaps[i]);
    }


    let maxFTime = 0
    for (let i = 0; i < n; i++) {
        // if we remove and place it somewhere else then the whole window is free
        let lowerBound = (i - 1) < 0 ? 0 : meetings[i - 1][1]
        let higherBound = (i + 1) === n ? eventTime : meetings[i + 1][0]
        const curMeeting = meetings[i]
        console.log(curMeeting, lowerBound, higherBound)

        let wind = higherBound - lowerBound
        let duration = meetings[i][1] - meetings[i][0]

        // since freeGaps[i] is the free space before i and 
        // freeGaps[i+1] is the free space after I, 
        // so we are considering prefix[i-1] and suffix[i+2]
        const leftMax = i === 0 ? 0 : prefixMax[i - 1];
        const rightMax = (i + 2 <= n) ? suffixMax[i + 2] : 0;

        const canRescheduleElsewhere = Math.max(leftMax, rightMax) >= duration;

        const curFreeTime = canRescheduleElsewhere ? wind : wind - duration

        maxFTime = Math.max(maxFTime, curFreeTime)

    }
    console.log('maxFTime', maxFTime)

    return maxFTime
};

let eventTime, startTime, endTime

eventTime = 5, startTime = [1, 3], endTime = [2, 5]
// eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
// eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
// eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

maxFreeTime(eventTime, startTime, endTime)

