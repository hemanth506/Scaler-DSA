var findRadius = function(houses, heaters) { // TLE Approach
    const m = heaters.length
    const n = houses.length

    function solve(mid) {
        let actualHouses = new Set(houses)
        for(let i = 0; i < m; i++) {
            const curHeaterPosition = heaters[i]
            let start = curHeaterPosition - mid, end = curHeaterPosition
            for(let idx = 0; idx < n; idx++) {
                let curHouse = houses[idx]
                if(start <= curHouse && curHouse <= end) {
                    actualHouses.delete(curHouse)
                }
            }

            start = curHeaterPosition, end = curHeaterPosition + mid
            for(let idx = 0; idx < n; idx++) {
                let curHouse = houses[idx]
                if(start <= curHouse && curHouse <= end) {
                    actualHouses.delete(curHouse)
                }
            }
        }
        return actualHouses.size > 0 ? false : true
    }

    let minRadius = 0
    let maxVal = Math.max(Math.max(...houses), Math.max(...heaters))
    let minVal = Math.min(Math.min(...houses), Math.min(...heaters))
    let l = 0, h = maxVal - minVal;
    while(l <= h) {
        let m = Math.floor((l+h) / 2)
        if(solve(m)) {
            minRadius = m
            h = m - 1
        } else {
            l = m + 1
        }
    }

    return minRadius
};

var findRadius = function (houses, heaters) {
    houses.sort((a, b) => a - b);
    heaters.sort((a, b) => a - b);

    const n = houses.length;
    const m = heaters.length;

    function canCoverAll(radius) {
        let i = 0;
        let j = 0;

        while (i < n && j < m) {
            const left = heaters[j] - radius;
            const right = heaters[j] + radius;

            if (left <= houses[i] && houses[i] <= right) {
                i++;
            } else if (houses[i] < left) {
                return false;
            } else {
                j++;
            }
        }

        return i === n;
    }

    let low = 0;
    let high = Math.max(
        Math.max(...houses),
        Math.max(...heaters)
    ) - Math.min(
        Math.min(...houses),
        Math.min(...heaters)
    );
    let ans = high;

    while (low <= high) {
        const mid = Math.floor((low + high) / 2);

        if (canCoverAll(mid)) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
};


let houses, heaters;
// houses = [1,2,3], heaters = [2]
// houses = [1,2,3,4], heaters = [1,4]
// houses = [1,5], heaters = [2]
// houses = [1,5], heaters = [10]
houses = [282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923],
    heaters = [823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612]

console.log(findRadius(houses, heaters));