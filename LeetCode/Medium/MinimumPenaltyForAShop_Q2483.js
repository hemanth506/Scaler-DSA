var bestClosingTime = function(customers) {
    const n = customers.length
    const op = Array(n).fill(0)
    const cs = Array(n).fill(0)
    if(customers[0] === 'N') op[0] = 1;
    if(customers[n-1] === 'Y') cs[n-1] = 1;

    for(let i = 1, j = n-2; i < n; i++, j--) {
        if(customers[i] === 'N') {
            op[i] += op[i-1] + 1
        } else {
            op[i] += op[i-1]
        }

        if(customers[j] === 'Y') {
            cs[j] += cs[j+1] + 1
        } else {
            cs[j] += cs[j+1]
        }
    }

    let minV = Infinity, minIdx = -1
    for(let i = 0; i <= n; i++) {
        let open = (i - 1) === -1 ? 0 : op[i-1]
        let close = i === n ? 0 : cs[i]

        let sum = open + close
        if(minV > sum) {
            minV = sum
            minIdx = i
        }
    }

    return minIdx
};

let customers;

// customers = "YYNY"
// customers = "NNNNN"
customers = "YYYY"
console.log(bestClosingTime(customers));