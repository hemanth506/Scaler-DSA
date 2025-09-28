var isPossible = function(nums) {
    const n = nums.length

    const p1StartInd = 0
    let p1Start = nums[p1StartInd]

    let p2StartInd;
    let p2Start;
    for(let i = p1StartInd; i < n; i++) {
        if(p1Start === nums[i]) {
            p1Start += 1
        } else {
            p2StartInd = i
            p2Start = nums[i]
            break
        }
    }

    if(p2StartInd === undefined && n >= 6) {
        console.log('check base')
        return true
    }

    let p1Total = 0
    p1Start = nums[p1StartInd]
    let p1End
    for(let i = p1StartInd; i < n; i++) {
        if(p1Start === nums[i]) {
            p1Start += 1
            p1Total += 1
            p1End = nums[i]
        }
    }

    let p2Total = 0
    let p2End
    for(let i = p2StartInd; i < n; i++) {
        if(p2Start === nums[i]) {
            p2Start += 1
            p2Total += 1
            p2End = nums[i]
        }
    }

    console.log(`p1StartInd ${p1StartInd}, p1Start ${nums[p1StartInd]}, p1End ${p1End}, p1Total ${p1Total}`)
    console.log(`p2StartInd ${p2StartInd}, p2Start ${nums[p2StartInd]}, p2End ${p2End}, p2Total ${p2Total}`)

    if(p1Total >= 3 && p2Total >= 3 && p1Total + p2Total === n) {
        console.log('check true')
        return true
    } else if (p1Total + p2Total > n) {
        if(nums[p1StartInd] <= nums[p2StartInd] && p1End >= nums[p2StartInd]) {
            console.log('check 1')
            if(p2StartInd - p1StartInd + 1 >= 3 && p2Total >= 3) {
                console.log('p2StartInd - p1StartInd + 1', p2StartInd - p1StartInd + 1)
                return true
            } 
            console.log('check 2')
            return false
        } else if(nums[p2StartInd] <= nums[p1StartInd] && p2End >= nums[p1StartInd]) {
            console.log('check 3')
            if(p1StartInd - p2StartInd + 1 >= 3 && p1Total >= 3) {
                return true
            } 
            console.log('check 4')
            return false
        } else if (p1End < p2Start) {
            console.log('check 5')
            if(p2Total >= 3 && p1Total >= 3) {
                return true
            } 
            console.log('check 6')
            return false
        }
    } 
    console.log('check 7')
    return false
};
let nums;

// nums = [1,2,3,3,4,5] // true

// nums = [1,2,3,3,4,4,5,5] // true

// nums = [1,2,3,4,4,5] // false

// nums = [1,2] // false

// nums = [1,2,3,4,5,6] // true

nums = [4,5,6,6,7,8,9,10,10,11]

console.log(isPossible(nums))