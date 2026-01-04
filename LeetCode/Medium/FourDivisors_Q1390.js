var sumFourDivisors = function (nums) { // TC = O(max log max + N)
    const max = Math.max(...nums)
    const hm = new Map()
    for (let num of nums) { // O(N)
        hm.set(num, [2, num + 1])
    }

    for (let i = 2; i + i <= max; i++) { // O(max log max)
        for (let j = i + i; j <= max; j += i) {
            if (hm.has(j)) {
                const [ct, sum] = hm.get(j)
                hm.set(j, [ct + 1, sum + i])
            }
        }
    }
    let total = 0
    for (let num of nums) { // O(N)
        const [ct, sum] = hm.get(num)
        if (ct === 4) total += sum;
    }

    return total;
};

var sumFourDivisors = function (nums) { // TC = O(n * sqrt(n))
    let total = 0
    for (let num of nums) {
        let sum = 0, ct = 0;
        for(let i = 1; i * i <= num; i++) {
            if(num % i === 0) {
                if(Math.floor(num/i) !== i) {
                    sum += (Math.floor(num/i) + i)
                    ct += 2
                } else {
                    sum += i
                    ct += 1
                }
            }
        }
        if (ct === 4) total += sum;
    }

    return total;
};

let nums;
// nums = [21,4,7]
// nums = [21,21]
nums = [1,2,3,4,5]

console.log(sumFourDivisors(nums));