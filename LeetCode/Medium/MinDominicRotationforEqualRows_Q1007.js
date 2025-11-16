var minDominoRotations = function(tops, bottoms) {
    const n = tops.length

    const nums = [1,2,3,4,5,6]
    let minSwaps = Infinity
    for(let num of nums) {
        let swapToTop = 0, topAvailable = true;
        for(let i = 0; i < n; i++) {
            if(tops[i] === num) {
                continue;
            } else if (bottoms[i] === num) {
                swapToTop++
            } else {
                topAvailable = false;
                break;
            }
        }
        if(topAvailable) {
            console.log('num', num, swapToTop);
            minSwaps = Math.min(minSwaps, swapToTop)
        }


        let swapToBottom = 0, bottomAvailable = true;
        for(let i = 0; i < n; i++) {
            if(bottoms[i] === num) {
                continue;
            } else if (tops[i] === num) {
                swapToBottom++
            } else {
                bottomAvailable = false;
                break;
            }
        }

        if(bottomAvailable) {
            console.log('swapToBottom => num', num, swapToBottom);
            minSwaps = Math.min(minSwaps, swapToBottom)
        }
        
    }

    return minSwaps === Infinity ? -1 : minSwaps;
};

let tops, bottoms;
// tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
tops = [1,2,1,1,1,2,2,2], bottoms = [2,1,2,2,2,2,2,2]

console.log(minDominoRotations(tops, bottoms));