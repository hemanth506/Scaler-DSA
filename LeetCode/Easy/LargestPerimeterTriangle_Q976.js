var largestPerimeter = function(nums) {
    const n = nums.length

    nums.sort((a,b) => b - a)
    let p1 = 0, p2 = 1
    let maxPeri = 0
    while (p2 < n-1) {
        let a = nums[p1], b = nums[p2]

        for(let i = p2+1; i < n; i++) {
            let c = nums[i]
            if(a + b > c && c + b > a && c + a > b) {
                maxPeri = Math.max(maxPeri, (a+b+c))
            } else {
                break
            }
        }
        p1++, p2++
    }
    return maxPeri
};

let nums;
// nums = [2,1,2]
nums = [1,2,1,10]

console.log(largestPerimeter(nums));