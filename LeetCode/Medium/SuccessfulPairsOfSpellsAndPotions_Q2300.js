var successfulPairs = function(spells, potions, success) {
    const n = spells.length
    const m = potions.length
    const b = m - 1
    potions.sort((a,b) => a - b)
    const res = []
    for(let i = 0; i < n; i++) {
        const spell = spells[i]

        let l = 0, h = m - 1
        let a = -1
        while (l <= h) {
            let m = Math.floor((l+h)/2)
            let potion = potions[m]
            if((spell * potion) >= success) {
                a = m
                h = m - 1
            } else {
                l = m + 1
            }
        }


        let ans = (a !== -1 )? (b - a + 1) : 0
        res.push(ans)
    }

    console.log(res)

    return res
    
};

let spells, potions, success

// spells = [5,1,3], potions = [1,2,3,4,5], success = 7
spells = [3,1,2], potions = [8,5,8], success = 16

successfulPairs(spells, potions, success)