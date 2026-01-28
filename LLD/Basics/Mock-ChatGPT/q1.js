function flattenArray(arr) {
    if(!Array.isArray(arr)) {
        return [arr]
    }

    let fullArr = []
    for(let iArr of arr) {
        const flatArr = flattenArray(iArr)
        fullArr = [...fullArr, ...flatArr]
    }
    return fullArr
}

const res = flattenArray([1, [2, [3, 4], 5], 6])
console.log(res);