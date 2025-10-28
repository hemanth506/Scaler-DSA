var minDeletion = function(nums) {
    const n = nums.length
    let del = 0
    for(let i = 0; i < n-1; i++) {
        let idx = i - del
        console.log('idx', idx);
        if((idx%2) === 0) {
            if(nums[i] === nums[i + 1]) {
                del += 1
            }
        }
    }
    console.log(del);
    let elts = n - del
    if(elts % 2 === 1) {
        del += 1
    }

    return del
};
let nums;

// nums = [1,1,2,3,5]
nums = [1,1,2,2,3,3]

console.log(minDeletion(nums));