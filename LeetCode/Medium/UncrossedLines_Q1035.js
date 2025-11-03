var maxUncrossedLinesOld = function(nums1, nums2) {
    const m = nums2.length

    const hm = new Map()
    for(let i = 0; i < m; i++) {
        let num = nums2[i]
        if(!hm.has(num)) {hm.set(num, []);}
        hm.get(num).push(i)
    }
    console.log(hm);

    let curIdx = -1, ct = 0
    for(let num of nums1) {
        if(hm.has(num)) {
            const arr = hm.get(num)
            console.log(arr, curIdx);
            let idx = curIdx;
            for(let inIdx of arr) {
                if(inIdx > curIdx) {
                    console.log('new curIdx', inIdx);
                    curIdx = inIdx
                    break;
                }
            }
            if(idx !== curIdx) {
                ct++
            }
        }
    }

    return ct

};


var maxUncrossedLines = function(nums1, nums2) {
    const n = nums1.length
    const m = nums2.length
    const dp = Array.from({length: n}, () => Array(m).fill(-1))

    function solve(i, j) {
        if(i === n || j === m) {
            return 0
        }
        if(dp[i][j] === -1) {
            let skip = solve(i+1, j)
            let pick = -Infinity
            for(let k = j; k < m; k++) {
                if(nums1[i] === nums2[k]) {
                    pick = Math.max(pick, solve(i+1, k+1) + 1)
                    break;
                }
            }
            dp[i][j] = Math.max(skip, pick)
        }
        return dp[i][j]
    }
    return solve(0, 0)
};

let nums1, nums2
// nums1 = [1,4,2], nums2 = [1,2,4]
// nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
// nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
nums1 = [1,1,2,1,2], nums2 = [1,3,2,3,1]

console.log(maxUncrossedLines(nums1, nums2));