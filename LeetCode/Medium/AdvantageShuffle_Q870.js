var advantageCount = function(nums1, nums2) {
    const n = nums1.length
    const idxNums2 = nums2.map((elt, i) => [elt, i])
    idxNums2.sort((a,b) => a[0] - b[0])
    nums1.sort((a,b) => a - b)

    const skipArr = []
    const result = Array(n).fill(-1)
    let p1 = 0, p2 = 0    
    while(p1 < n) {
        let skipped = true
        if(idxNums2[p2][0] < nums1[p1]) {
            result[idxNums2[p2][1]] = nums1[p1]
            p2++
            skipped = false
        }
        if(skipped) {
            skipArr.push(p1)
        }
        p1++
    }

    console.log(result, skipArr);
    for(let i = 0, j = 0; i < n; i++) {
        if(result[i] === -1) {
            result[i] = nums1[skipArr[j]]
            j++
        }
    }
    return result
};

let nums1, nums2;
// nums1 = [12,24,8,32, 6], nums2 = [13,25,32,11, 32]
nums1 = [5621,1743,5532,3549,9581], nums2 = [913,9787,4121,5039,1481]
console.log(advantageCount(nums1, nums2));