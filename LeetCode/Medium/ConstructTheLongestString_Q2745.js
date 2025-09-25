var longestString = function(x, y, z) {
    let maxStrLen = -Infinity
    const [ actualX, actualY, actualZ] = [x, y, z] 
    const dp = new Map()

    function solve(x, y, z, previous) {
        const key = x+"_"+y+"_"+z+"_"+previous
        const curUsage = (actualX - x + actualY - y + actualZ - z) * 2
        maxStrLen = Math.max(maxStrLen, curUsage)
        if(x === 0 && y === 0 && z === 0) {
            dp.set(key, maxStrLen)
            return dp.get(key)
        }

        if(!dp.has(key)) {
            if(previous === "" || previous === 'x') {
                if(y > 0) solve(x, y - 1, z, 'y')
            } 
            if(previous === "" || previous === 'y' || previous === 'z') {
                if(x > 0) solve(x - 1, y, z, 'x')
                if(z > 0) solve(x, y, z - 1, 'z')
            }
            dp.set(key, maxStrLen)
        }
        return dp.get(key)
    }
    
    return solve(x, y, z, "")
};
let x, y, z

x = 2, y = 5, z = 1
// x = 3, y = 2, z = 2
longestString(x, y, z)