var triangleNumber = function(nums) { // O(N^3)
    nums.sort((a, b) => a - b);
    const n = nums.length
    let ct = 0
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                if (nums[k] < nums[i] + nums[j]) {
                    ct++
                }
                else {
                    break;
                }
            }
        }
    }

    return ct
};

var triangleNumber = function(nums) { // O(N^2)
    const n = nums.length
    nums.sort((a, b) => a - b)

    let ct = 0
    for(let k = n - 1; k >= 2; k--) {
        let i = 0, j = k - 1

        while (i < j) {
            if(nums[i] + nums[j] > nums[k]) {
                ct += (j-i)
                j--
            } else {
                i++
            }
        }
    }

    return ct
};

let nums

nums = [2,3,4,5,5,6,7,10,12,15,20]

triangleNumber(nums)