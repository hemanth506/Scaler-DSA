var countSubarrays = function(nums, k) {
    const n = nums.length
    let ct = 0
    const que = []
    const maxVal = Math.max(...nums)
    let cur = 0
    for(let i = n-1; i >= 0; i--) {
        let added = false
        if(maxVal === nums[i]) {
            added = true
            que.push(i)
        }

        if(que.length >= k) {
            if(que.length > k && added) {
                cur++
            }
            console.log(i, que, cur);
            const idx = que[cur]
            ct += n - idx
        }
    }

    return ct
};

let nums, k

nums = [1,3,2,3,3], k = 2
// nums = [1,4,2,1], k = 3
console.log(countSubarrays(nums, k));