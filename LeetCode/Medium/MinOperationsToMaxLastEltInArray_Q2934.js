var minOperations = function(nums1, nums2) {
    const n = nums1.length

    const A = [...nums1]
    const B = [...nums2]
    const [aMax, bMax] = [A[n-1], B[n-1]]
    let bct = 0
    for(let i = 0; i < n-1; i++) {
        if(aMax < A[i] || bMax < B[i]) {
            if(A[i] === B[i]) {
                return -1
            }
            [B[i], A[i]] = [A[i], B[i]]
            bct += 1
        }
    }

    // after swap the last elt
    [nums2[n-1], nums1[n-1]] = [nums1[n-1], nums2[n-1]]

    const C = [...nums1]
    const D = [...nums2]
    const [cMax, dMax] = [C[n-1], D[n-1]]
    let act = 1
    for(let i = 0; i < n-1; i++) {
        if(cMax < C[i] || dMax < D[i]) {
            if(C[i] === D[i]) {
                return -1
            }
            [D[i],C[i]] = [C[i], D[i]]
            act += 1
        }
    }


    for(let i = 0 ; i < n - 1; i++) {
        if(cMax < C[i] || dMax < D[i] || bMax < B[i] || aMax < A[i]) return -1
    }

    return Math.min(bct, act)
};
let nums1, nums2;

// nums1 = [1,2,7], nums2 = [4,5,3]
// nums1 = [2,3,4,5,9], nums2 = [8,8,4,4,4]
// nums1 = [1,5,4], nums2 = [2,5,3]
nums1 = [10,18,12,12], nums2 = [19,6,5,12]

console.log(minOperations(nums1, nums2))