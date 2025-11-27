var minimalKSum = function(nums, k) {
    nums.sort((a,b) => a - b)
    let i = 0, first = 0, last;
    let aggSum = 0
    while(k > 0 && i < nums.length) {
        last = nums[i]
        let windowLen = last - first - 1
        if(windowLen > 0) {
            let curN = Math.min(windowLen, k);
            const tempLast = first + curN + 1
            const value = Math.floor((curN / 2) * (first + tempLast))
            aggSum += value
            k -= curN
        }
        first = last;
        i++
    }
    if(k > 0) {
        const tempLast = first + k + 1
        const value = Math.floor((k / 2) * (first + tempLast))
        aggSum += value
    }

    return aggSum;
};

let nums, k;

// nums = [1,4,25,10,25], k = 2
// nums = [5,6], k = 6
nums = [93,44,49,45,93,52,6,7,88,70,86,15,38,86,86,95,8,62,13,84,26,16,33,85,7,62,55,50,77,10,76,10,35,67,19,12,24,39,76,37]
k = 17

console.log(minimalKSum(nums, k));