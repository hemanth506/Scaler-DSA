var maximumNumber = function(num, change) {
    const n = num.length
    const numArr = num.split("").map(Number)

    let startInd = -1
    for(let i = 0; i < numArr.length; i++) {
        if(change[numArr[i]] > numArr[i]) {
            startInd = i
            break
        }
    }
    if(startInd === -1) {
        return num
    } 

    let k = startInd
    while (k < n && change[numArr[k]] > numArr[k]) {
        numArr[k] = change[numArr[k]]
        k++;
    }

    console.log('numArr', numArr)
    return numArr.join("")
};

let num, change

// num = "132", change = [9,8,5,0,3,6,4,2,6,8]
// num = "021", change = [9,4,3,5,7,2,1,9,0,6]
num = "5", change = [1,4,7,5,3,2,5,6,9,4]
maximumNumber(num, change)