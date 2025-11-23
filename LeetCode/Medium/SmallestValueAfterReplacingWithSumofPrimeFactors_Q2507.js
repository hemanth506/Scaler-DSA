var smallestValue = function(n) {
    const spf = Array.from({ length: n+1 }, (_, idx) => idx);

    for(let i = 2; i*i <= n; i++) { // set smallest prime factor
        if(spf[i] === i) {
            console.log(spf[i], i);
            for(let j = i*i; j <= n; j+=i) {
                spf[j] = Math.min(i, spf[j])
            }
        }
    }

    while(true) {
        let num = n, sum = 0;
        while (num > 1) {
            let x = spf[num]
            console.log(x);
            while((num % x) === 0) {
                num /= x
                sum += x
            }
        }

        if(sum === n) {
            break;
        }
        n = sum
    }

    return n
};


let n;
n = 4
console.log(smallestValue(n));