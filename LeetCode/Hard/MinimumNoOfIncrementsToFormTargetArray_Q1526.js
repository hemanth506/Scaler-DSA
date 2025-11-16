var minNumberOperations = function(target) { // TLE approach O(N^2)
    let n = target.length
    let i = 0, ct = 0
    while(i < n) {
        while(target[i] === 0) {
            i++
        }
        let start = i
        let isUpdated = false
        while(start < n && target[start] !== 0 ) {
            target[start]--
            isUpdated = true
            start++
        }
        if(isUpdated) ct++;
    }

    return ct
};


var minNumberOperations = function(target) { // O(N)
    let n = target.length
    let ct = 0
    
    let prev = 0
    for(let i = 0; i < n; i++) {
        if(prev < target[i]) {
            ct += (target[i] - prev)
        } 
        prev = target[i]
    }

    return ct
};