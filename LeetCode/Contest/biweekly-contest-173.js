// var reversePrefix = function(s, k) {
//     const n = s.length
//     if(n === k) {
//         return s.split('').reverse().join('')
//     }
//     const firstPart = s.slice(0, k).split('').reverse().join('')
//     return firstPart +""+s.slice(k)
// }

// let s, k;
// // s = "abcd", k = 2
// // s = "xyz", k = 3
// s = "hey", k = 1


// console.log(reversePrefix(s, k));


var minLength = function (nums, k) {
    const n = nums.length;

    let left = 0;
    let minLen = Infinity;

    let freq = new Map(); 
    let distinctSum = 0; 

    for (let right = 0; right < n; right++) {
        const val = nums[right];

        if (!freq.has(val)) {
            freq.set(val, 1);
            distinctSum += val;
        } else {
            freq.set(val, freq.get(val) + 1);
        }

        while (distinctSum >= k) {
            minLen = Math.min(minLen, right - left + 1);

            const leftVal = nums[left];
            freq.set(leftVal, freq.get(leftVal) - 1);

            if (freq.get(leftVal) === 0) {
                freq.delete(leftVal);
                distinctSum -= leftVal;
            }

            left++;
        }
    }

    return minLen === Infinity ? -1 : minLen;
};

let nums, k;

// nums = [2, 2, 3, 1], k = 4
// nums = [3,2,3,4], k = 8
// nums = [5,5,4], k = 5
nums = [6, 1], k = 9
// nums = [1,1,1,1,1,2,3], k = 5


console.log(minLength(nums, k));

