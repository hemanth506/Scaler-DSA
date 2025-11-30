var minSubarray = function (nums, p) {
    const n = nums.length;
    let minLen = Infinity;

    let suffix = 0;
    const sufModHm = new Map();
    sufModHm.set(0, [n]);
    for (let i = n - 1; i >= 0; i--) {
        suffix += nums[i];
        let mod = suffix % p;
        if (mod === 0) minLen = Math.min(minLen, i);
        if (!sufModHm.has(mod)) sufModHm.set(mod, []);
        sufModHm.get(mod).push(i);
    }

    if(suffix % p === 0) return 0;
    
    let prefix = 0;
    for (let i = 0; i < n; i++) {
        prefix += nums[i];
        let rem = prefix % p === 0 ? 0 : p - (prefix % p);
        if (sufModHm.has(rem)) {
            const arr = sufModHm.get(rem);
            for (let j = arr.length - 1; j >= 0; j--) {
                if (i < arr[j]) {
                    let len = arr[j] - i - 1;
                    minLen = Math.min(len, minLen);
                    break;
                }
            }
        }
    }

    return minLen === Infinity ? -1 : minLen;
};

let nums, p;

// nums = [3,1,4,2], p = 6
// nums = [6,3,5,2], p = 9
// nums = [1,2,3], p = 3
// nums = [8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2], p = 148
(nums = [3, 1, 3]), (p = 3);

console.log(minSubarray(nums, p));
