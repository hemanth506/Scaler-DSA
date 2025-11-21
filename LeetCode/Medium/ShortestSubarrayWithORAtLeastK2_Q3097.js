/**
 *  TC = O(N log N), 
 * but can do tis using 2-pointer with the similiar logic.
 * Adding and removing bit are same, only diff is instead of binary search, we can use 2 pointer.
 */

var minimumSubarrayLength = function (nums, k) {
    const n = nums.length
    
    const add = (num, hm) => {
        let idx = 1;
        while (num > 0) {
            if ((num & 1) === 1) {
                hm.set(idx, (hm.get(idx) || 0) + 1)
            }
            num = num >> 1;
            idx = idx * 2
        }
    }

    const remove = (rem, hm, orVal) => {
        let idx = 1
        while (rem > 0) {
            if ((rem & 1) === 1) {
                if (hm.get(idx) === 1) {
                    orVal -= idx
                    hm.delete(idx)
                } else {
                    hm.set(idx, hm.get(idx) - 1)
                }
            }
            rem = rem >> 1
            idx = idx * 2
        }
        return orVal
    }

    const validate = (m) => {
        const hm = new Map()
        let orVal = 0
        for (let i = 0; i < n; i++) {
            if(i >= m) {
                let rem = nums[i - m]
                orVal = remove(rem, hm, orVal)
            }

            let num = nums[i]
            add(num, hm)
            orVal = orVal | num;   
            if (i >= m - 1 && orVal >= k) return true;
        }
        return false
    }

    let shortestLen = -1
    let l = 1; let h = n;
    while (l <= h) {
        let m = Math.floor((l+h) / 2)
        const flag = validate(m)
        if(flag) {
            shortestLen = m
            h = m - 1
        } else {
            l = m + 1
        }
    }
    return shortestLen
};

let nums, k;

// nums = [1,2,3], k = 2
// nums = [2,1,8], k = 10
// nums = [1,2], k = 0
// nums = [1,2,32,21], k = 55
// nums = [1,12,26,2], k = 8
nums = [36,2,12,1], k = 46

minimumSubarrayLength(nums, k)