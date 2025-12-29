var pyramidTransition = function (bottom, allowed) {
    const grid = [bottom.split("")]
    let i = bottom.length
    while (i > 1) {
        i--
        grid.push(Array(i).fill(""))
    }

    const hm = new Map()
    for (let word of allowed) {
        const str = word[0] + "" + word[1]
        const ch = word[2]
        if (!hm.has(str)) hm.set(str, [])
        hm.get(str).push(ch)
    }

    const n = grid.length
    let found = false
    function solve(i, j) {
        if (i === n-1) {
            found = true
            return;
        }

        const str = grid[i][j] + "" + grid[i][j + 1]
        if (hm.has(str)) {
            const chArr = hm.get(str)
            for(let ch of chArr) {
                grid[i+1][j] = ch
                if(!found) {
                    if(j + 1 === grid[i].length - 1) {
                        solve(i+1, 0)
                    } else {
                        solve(i, j+1)
                    }
                }
            }
        }

        return
    }

    solve(0, 0)
    return found
};

let bottom, allowed;

// bottom = "BCD", allowed = ["BCA", "BCC","CDK", "CDE","CEA","FFF"]
bottom = "AAAA", allowed = ["AAB","AAC","BCD","BBE","DEF"]

console.log(pyramidTransition(bottom, allowed));