// Arrays

var queryResults = function(limit, queries) {
    const arr = new Map()
    const hm = new Map()
    const finalArr = []

    for(let i = 0; i < queries.length; i++) {
        const [ind, color] = queries[i]

        if(arr.has(ind)) {
            const curColor = arr.get(ind)
            if(hm.get(curColor) - 1 !== 0) {
                hm.set(curColor, hm.get(curColor) - 1)
            } else {
                hm.delete(curColor)
            }
        }

        arr.set(ind, color)
        if(!hm.has(color)) {
            hm.set(color, 0)
        }
        hm.set(color, hm.get(color) + 1)
        finalArr.push(hm.size)
    }
    return finalArr
};