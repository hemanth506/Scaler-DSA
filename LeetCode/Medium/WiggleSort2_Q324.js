var wiggleSort = function(nums) {
    const n = nums.length
    const tempArr = [...nums]
    tempArr.sort((a,b) => a - b)

    let j = n - 1
    for(let i = 1; i < n; i+=2) {
        nums[i] = tempArr[j]
        j--;
    }

    for(let i = 0; i < n; i+= 2) {
        nums[i] = tempArr[j]
        j--;
    }
    return
};

let nums;

nums = [1,5,1,1,6,4]

wiggleSort(nums)