var maxSumDivThree = function(nums) {
    let rem1a = Infinity, rem1b = Infinity;
    let rem2a = Infinity, rem2b = Infinity;
    let sum = 0
    for(let num of nums) {
        sum += num;

        let modV = num % 3;

        if(modV === 1) {
            if(rem1a > num) {
                rem1b = rem1a
                rem1a = num
            } else if (rem1b > num) {
                rem1b = num
            }
        } else if (modV === 2) {
            if(rem2a > num) {
                rem2b = rem2a
                rem2a = num
            } else if (rem2b > num) {
                rem2b = num
            }
        }
    }

    let rem = sum % 3
    if(rem === 0) return sum;

    let removeCost = Infinity
    if(rem === 1) {
        if(rem1a !== Infinity) {
            removeCost = Math.min(removeCost, rem1a)
        }

        if(rem2b !== Infinity) {
            removeCost = Math.min(removeCost, rem2a + rem2b)
        }
    } else {
        if(rem2a !== Infinity) {
            removeCost = Math.min(removeCost, rem2a)
        }

        if(rem1b !== Infinity) {
            removeCost = Math.min(removeCost, rem1a + rem1b)
        }
    }
    return sum - removeCost
};