var minimumAverageDifference = function(num) {
    let n = num.length

    // prefix
    const prefixSum = Array(n)
    prefixSum[0] = num[0]
    for(let i = 1; i < n; i++) {
        prefixSum[i] = prefixSum[i-1] + num[i]
    }

    // suffix (Used the actual array as suffix array)
    for(let i = n-2; i >= 0; i--) {
        num[i] = num[i+1] + num[i]
    }

    let minVal = Infinity
    let minAvgIndex = 0
    for(let i = 0; i < n; i++) {
        let lt = i + 1
        let pref = Math.floor(prefixSum[i] / lt)
        let suf = (n-lt) === 0 ? 0 : Math.floor(num[i+1] / (n-lt))
        let absVal = Math.abs(pref - suf)
        if(absVal < minVal) {
            minVal = absVal
            minAvgIndex = i
        }
    }

    return minAvgIndex

};


let num;

num = [2,5,3,9,5,3]

minimumAverageDifference(num)