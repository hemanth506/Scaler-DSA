var hasIncreasingSubarrays = function(nums, k) {
    if (k === 1) return true
    const n = nums.length
    let arr = [1]
    for(let i = 1; i < n; i++) {
        arr[i] = nums[i] > nums[i-1] ? arr[i-1] + 1 : 1
    }

    let p1 = 0 + k, p2 = p1 + k
    console.log(p1, p2);
    while (p2 < n) {
        let arr1Flag = arr[p1] >= k
        let arr2Flag = arr[p2] >= k
        if(arr1Flag && arr2Flag) {
            return true
        }
        p1++; p2++;
    }

    return false
};


let nums, k;

// nums = [2,5,7,8,9,2,3,4,3,1], k = 3
// nums = [1,2,3,4,4,4,4,5,6,7], k = 5
nums = [-15,19], k = 1

console.log(hasIncreasingSubarrays(nums, k));