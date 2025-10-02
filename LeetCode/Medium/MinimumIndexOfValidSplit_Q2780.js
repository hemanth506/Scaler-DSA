var minimumIndex = function(nums) {
    const n = nums.length

    const map = new Map()
    for(let i = 0; i < n; i++) {
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
    }

    let maxEltTimes = 0
    let maxElt = 0
    for(let [key, value] of map.entries()) {
        if(maxEltTimes < value) {
            maxEltTimes = value
            maxElt = key
        }
    }

    console.log('dominant elt =', maxElt, maxEltTimes)
    let leftDominantCt = 0
    let splitIndex = -1
    for(let i = 0; i < n; i++) {

        if(nums[i] === maxElt) {
            leftDominantCt += 1
        }

        let leftValid = leftDominantCt > (i + 1) / 2
        let rightDominantCt = maxEltTimes - leftDominantCt
        let rightValid = rightDominantCt > (n-i-1) / 2
        if(leftValid && rightValid) {
            splitIndex = i
            break
        }
    }

    console.log('splitIndex', splitIndex)

    return splitIndex
};

let nums;

nums = [2,1,3,1,1,1,7,1,2,1]

minimumIndex(nums)