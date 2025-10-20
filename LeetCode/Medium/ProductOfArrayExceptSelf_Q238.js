var productExceptSelfWithSpace = function (nums) {
    const n = nums.length;
    const prefix = Array(n).fill(1);
    const suffix = Array(n).fill(1);

    prefix[0] = nums[0];
    for (let i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] * nums[i];
    }

    suffix[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        suffix[i] = suffix[i + 1] * nums[i];
    }

    const res = [];
    for (let i = 0; i < n; i++) {
        if (i === 0) res.push(suffix[i + 1]);
        else if (i === n - 1) res.push(prefix[i - 1]);
        else res.push(prefix[i - 1] * suffix[i + 1]);
    }

    for (let i = 0; i < n; i++) {
        if (Object.is(res[i], -0)) res[i] = 0;
    }

    return res;
};


var productExceptSelf = function (nums) {
    const n = nums.length;
    let zeroCt = 0
    let prod = 1
    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) zeroCt++
        else prod *= nums[i]
    }
    const res = Array(n).fill(0);

    if (zeroCt > 1) return res
    else if (zeroCt === 1) {
        for (let i = 0; i < n; i++) {
            if(nums[i] === 0) res[i] = prod
            else res[i] = 0
        }
    } else {
        for (let i = 0; i < n; i++) {
            res[i] = prod / nums[i]
        }
    }
    return res
}
let nums;

nums = [1,2,3,4]
// nums = [-1, 1, 0, -3, 3]
console.log(productExceptSelf(nums));