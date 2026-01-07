var continuousSubarrays = function (nums) {
    const n = nums.length, hm = new Map()
    function getMinMax(arr) {
        let min = Infinity, max = -Infinity
        for(let i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i])
            max = Math.max(max, arr[i])
        }
        return [min, max]
    }
    let l = 0, ct = 0
    for(let r = 0; r < n; r++) {
        hm.set(nums[r], (hm.get(nums[r]) || 0) + 1)
        let [min, max] = getMinMax([...hm.keys()])
        while(max - min > 2) {
            let val = hm.get(nums[l])
            if((val - 1) === 0) {
                hm.delete(nums[l])
            } else {
                hm.set(nums[l], val - 1)
            }
            [min, max] = getMinMax([...hm.keys()])
            l++
        }
        ct += (r - l + 1)
    }
    return ct
}

let nums;
// nums = [5,4,2,4]
nums = [1,2,3]
console.log(continuousSubarrays(nums));