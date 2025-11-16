var minOperationsWrong = function(nums) { // wrong approach
    const n = nums.length

    function gcd(a ,b) {
        if(a === 0) {
            return b
        }
        return gcd(b%a,a)
    }

    let times = -1
    for(let i = 0; i < n - 1; i++) {
        if(gcd(nums[i], nums[i+1]) === 1) {
            times = n
            break
        }
    }

    return times === -1 ? -1 : times
};


var minOperations = function(nums) {
    const n = nums.length
    function gcd(a ,b) {
        if(a === 0) {
            return b
        }
        return gcd(b%a,a)
    }

    let gcdVal = 0
    let num1 = 0
    for(let num of nums) {
        if(num === 1) {
            num1++
        }
        gcdVal = gcd(gcdVal, num)
    }

    if(gcdVal > 1) return -1;

    if(num1 > 0) return n - num1;

    let len = n
    for(let i = 0; i < n; i++) {
        let curGcd = 0
        for(let j = i; j < n; j++) {
            curGcd = gcd(curGcd, nums[j])
            if(curGcd === 1) {
                len = Math.min(len, j - i + 1)
                break
            }
        }
    }

    return len + n - 2

}


let nums;

// nums = [2,6,3,4]
// nums = [2,10,6,14]
nums = [2,6,3,4,2,6,3,4]
console.log(minOperations(nums));