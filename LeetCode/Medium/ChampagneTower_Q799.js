var champagneTower = function(poured, query_row, query_glass) {
    let arr1 = [poured]
    let arr2
    let i = 0;
    while(i < query_row) {
        arr2 = Array(arr1.length + 1).fill(0)
        for(let j = 0; j < arr1.length; j++) {
            let rem = arr1[j] - 1;
            if(rem > 0) {
                arr2[j] += (rem / 2)
                arr2[j+1] += (rem / 2)
            }
        }
        arr1 = arr2;
        i++
    }

    return Math.min(1, arr1[query_glass])
};


let poured, query_row, query_glass;

// poured = 1, query_row = 1, query_glass = 1
// poured = 2, query_row = 1, query_glass = 1
// poured = 100000009, query_row = 33, query_glass = 17
poured = 23, query_row = 7, query_glass = 3


console.log(champagneTower(poured, query_row, query_glass));