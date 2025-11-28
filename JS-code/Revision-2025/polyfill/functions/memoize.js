const memoizeFn = function() {
    const mapObj = {}
    return (a, b) => {
        const key = a+'_'+b
        if(mapObj.hasOwnProperty(key)) return mapObj[key];
        for(let i = 0; i < 1000000000; i++) {}

        mapObj[key] = a * b
        return mapObj[key]
    }
}

const memo = memoizeFn()
console.time('memo')
console.log(memo(29584, 2494));
console.timeEnd('memo')

console.time('memo')
console.log(memo(29584, 2494));
console.timeEnd('memo')