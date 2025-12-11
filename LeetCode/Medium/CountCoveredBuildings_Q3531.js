var countCoveredBuildings = function(n, buildings) {
    const hmX = new Map();
    const hmY = new Map();

    for(let [x, y] of buildings) {
        if(!hmX.has(x)) {
            hmX.set(x, [])
        }
        hmX.get(x).push(y);

        if(!hmY.has(y)) {
            hmY.set(y, [])
        }
        hmY.get(y).push(x)
    }

    for(let key of hmX.keys()) {
        hmX.get(key).sort((a,b) => a - b)
    }


    for(let key of hmY.keys()) {
        hmY.get(key).sort((a,b) => a - b)
    }

    function check(val, arr) {
        if(arr.length >= 3 && arr[0] !== val && arr.at(-1) !== val) {
            return true
        }
        return false
    }

    let ct = 0
    for(let i = 0; i < buildings.length; i++) {
        const [x, y] = buildings[i]
        const hmXArr = hmX.get(x);
        const hmYArr = hmY.get(y)
        if(check(y, hmXArr) && check(x, hmYArr)) {
            ct++
        }
    }

    return ct;
};


let n, buildings;
// n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
// n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
console.log(countCoveredBuildings(n, buildings));