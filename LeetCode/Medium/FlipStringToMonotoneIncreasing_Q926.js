var minFlipsMonoIncr = function(s) {
    const n = s.length
    const dp = new Map()

    function solve(i, prev) {
        if(i === n) {
            return 0
        }

        const str = i + "_" + prev
        if(!dp.has(str)) {
            let idx = i
            while (idx < n && s.charAt(idx) === s.charAt(i)) {
                idx++
            }
            idx -= 1

            let flips = idx - i + 1

            if(prev === '1') {
                if(s.charAt(idx) === prev) {
                    flips = 0
                }
                const onesVal = solve(idx + 1, '1') + flips
                dp.set(str, onesVal)
            } else {
                const sameVal = solve(idx + 1, s.charAt(idx))
                const flippedChar = s.charAt(idx) === '1' ? '0' : '1'
                const flipVal = solve(idx + 1, flippedChar) + flips
                const minVal = Math.min(sameVal, flipVal)
                dp.set(str, minVal)
            }
        }

        return dp.get(str)
    }

    return solve(0, "")
};
let s;

// s = "010110"
// s = "00110"
// s = "00011000"
// s = "11111"
// s = "0101100011"
s = "10011111110010111011"


console.log(minFlipsMonoIncr(s))