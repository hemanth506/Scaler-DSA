var isZeroArray = function(nums, queries) {
    const n = nums.length
    const m = queries.length
    const arr = Array(n).fill(0)

    for(let i = 0; i < m; i++) {
        const start = queries[i][0]
        const end = queries[i][1]
        arr[start] = arr[start] - 1
        console.log('start', start, arr[start]);
        if((end + 1) < n) {
            arr[end+1] += 1
        }
    }
    console.log('before sum: arr', arr);
    for(let i = 1; i < n; i++) {
        arr[i] += arr[i-1]
    }

    console.log('arr', arr);
    console.log('nums', nums);

    for(let i = 0; i < n; i++) {
        nums[i] += arr[i]
        if(nums[i] > 0) {
            return false
        }
    }

    return true
};
let nums, queries;
nums = [4,6]
queries = [[0,0],[0,1],[1,1],[0,0],[1,1],[1,1],[0,0],[1,1],[1,1],[1,1],[0,0],[1,1],[0,1],[0,0],[1,1]]

console.log(isZeroArray(nums, queries));