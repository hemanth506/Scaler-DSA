var smallestRepunitDivByK = function(k) {
    if ((k % 2 === 0) || (k % 5 === 0)) {
        return -1
    }

    let i = 1;
    let ct = 1;
    while(true) {
        let val = (i % k)
        if(val === 0) {
            break;
        }
        ct++;
        i = (val * 10 + 1)
    }

    return ct
};