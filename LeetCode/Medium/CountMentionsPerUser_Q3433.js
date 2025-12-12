var countMentions = function (n, events) {
    const m = events.length
    events.sort((a, b) => {
        const numA = Number(a[1])
        const numB = Number(b[1])
        if (numA === numB) return b[0][0].charCodeAt(0) - a[0][0].charCodeAt(0);
        return numA - numB;
    })

    const onlineFrom = Array(n).fill(0)
    const mentionsArr = Array(n).fill(0)

    let allCt = 0;
    for (let i = 0; i < m; i++) {
        const [type, timeStamp, commandStr] = events[i]
        if (type === 'MESSAGE') {
            if (commandStr === 'ALL') {
                allCt++
            } else if (commandStr === 'HERE') {
                for (let t = 0; t < n; t++) {
                    if (onlineFrom[t] <= Number(timeStamp)) {
                        mentionsArr[t]++
                    }
                }
            } else {
                const mentions = commandStr.split(" ")
                for (let person of mentions) {
                    const personId = Number(person.split("id")[1])
                    mentionsArr[personId]++
                }
            }
        } else {
            onlineFrom[Number(commandStr)] = (Number(timeStamp) + 60)
        }
    }

    return mentionsArr.map((men) => men + allCt)
};

let numberOfUsers, events;

// numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
// numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","12","ALL"]]
// numberOfUsers = 2, events = [["OFFLINE","10","0"],["MESSAGE","12","HERE"]]
// numberOfUsers = 3, events = [["MESSAGE","2","HERE"],["OFFLINE","2","1"],["OFFLINE","1","0"],["MESSAGE","61","HERE"]]
// numberOfUsers = 3, events = [["MESSAGE","1","id0 id1"],["MESSAGE","5","id2"],["MESSAGE","6","ALL"],["OFFLINE","5","2"]]
numberOfUsers = 15, events = [["MESSAGE","10","id7 id13 id12 id1 id7"],["MESSAGE","115","id9 id11 id3 id14 id13 id4 id12 id1 id10 id6"],["OFFLINE","38","3"],["OFFLINE","446","5"],["MESSAGE","448","id7 id7 id14"],["OFFLINE","73","8"],["OFFLINE","410","10"],["OFFLINE","470","9"],["OFFLINE","367","1"],["OFFLINE","327","11"],["OFFLINE","331","8"],["MESSAGE","213","HERE"],["MESSAGE","267","HERE"],["MESSAGE","284","HERE"],["MESSAGE","500","ALL"],["MESSAGE","435","HERE"],["MESSAGE","17","id13 id4 id5 id2 id3 id14 id1 id5 id7 id6"],["MESSAGE","464","ALL"],["MESSAGE","427","id3 id5 id0 id6 id14 id1 id1 id9"]]
console.log(countMentions(numberOfUsers, events));
