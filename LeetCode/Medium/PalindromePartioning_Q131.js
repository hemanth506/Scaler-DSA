var partition = function(s) {
    const n = s.length
    const res = []

    function isPal(word) {
        let m = word.length
        let p1 = 0, p2 = m-1
        while(p1 <= p2) {
            if(word.charAt(p1) !== word.charAt(p2)) {
                return false
            }
            p1++
            p2--
        }

        return true
    }

    function solve(i, arr) {
        if(i === n) {
            let newArr = [...arr]
            res.push(newArr)
            return
        }

        let str = "";
        for(let k = i; k < n; k++) {
            str += s.charAt(k)
            if(isPal(str) === true) {
                arr.push(str)
                solve(k + 1, arr)
                arr.pop()
            }
        }
    }

    solve(0, [])
    return res
};

let s;
// s = "aab"
// s = "a"
s = "efe"

console.log(partition(s));


