var minimumPairRemoval = function (nums) {
    let removal = 0, sorted = false
    while (!sorted) {
        let idxI = -1, min = Infinity;
        sorted = true
        for (let i = 0; i < nums.length - 1; i++) {
            let sum = nums[i] + nums[i + 1]
            if (nums[i] > nums[i + 1]) {
                sorted = false
            }
            if (min > sum) {
                min = sum
                idxI = i;
            }
        }

        if (!sorted) {
            nums = [...nums.slice(0, idxI), min, ...nums.slice(idxI + 2)]
            removal++;

        }
    }

    return removal
}

let nums;
// nums = [5, 2, 3, 1]
// nums = [1,2,2]
nums = [2,2,-1,3,-2,2,1,1,1,0,-1]

console.log(minimumPairRemoval(nums));