var longestSubstring = function (s, k) { // Used divide and conquer
    function dfs(str) {
        if (str.length === 0) return 0
        const freq = new Map()
        for (let i = 0; i < str.length; i++) {
            freq.set(str[i], (freq.get(str[i]) || 0) + 1)
        }

        for (let i = 0; i < str.length; i++) {
            if (freq.get(str[i]) < k) {
                const left = dfs(str.slice(0, i))
                const right = dfs(str.slice(i + 1))
                return Math.max(left, right)
            }
        }
        return str.length
    }
    return dfs(s)
}



let s, k;

s = "aaabb", k = 3
// s = "ababbc", k = 2
// s = 'ccbabdbab', k = 3

console.log(longestSubstring(s, k));