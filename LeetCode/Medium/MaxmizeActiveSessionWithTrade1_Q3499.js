var maxActiveSectionsAfterTrade = function (s) { // O(N)
    const n = s.length
    let maxCt = -Infinity;
    let initialCt = 0;
    for(let i = 0; i < n; i++) {
        if(s[i] == 1) {
            initialCt++
        }
    }

    let foundLeft = false
    let toAddCt = 0
    let rightZeros = 0;
    for(let i = 0; i < n; i++) {
        console.log('i', i);
        if(s[i] == 1) {
            let ones = 0
            let k = i;
            for(; k < n; k++) {
                if(s[k] == 0) {
                    break;
                }
                ones++
            }

            let leftZeros = 0
            if (!foundLeft) {
                for(let j = i-1; j >= 0; j--) {
                    if(s[j] == 1) {
                        break;
                    }
                    leftZeros++;
                }
                foundLeft = true
            } else {
                console.log('true');
                leftZeros = rightZeros
            }

            rightZeros = 0
            let tempI = i
            for(let l = k; l < n; l++) {
                if(s[l] == 1) {
                    break;
                }
                rightZeros++;
                tempI = l
            }
            i = Math.max(tempI, i + ones)
            if(rightZeros && leftZeros) {
                if(maxCt < (leftZeros + rightZeros)) {
                    maxCt = (leftZeros + rightZeros)
                    toAddCt = leftZeros + rightZeros
                }
            }
        }
    }
    console.log(initialCt + toAddCt);
    return initialCt + toAddCt
}


let s;

// s = "01"
// s = "0100"
// s = "1000100"
// s = "01010"
// s = "01101001"
s = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
maxActiveSectionsAfterTrade(s)