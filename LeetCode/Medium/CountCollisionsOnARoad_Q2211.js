var countCollisions = function (directions) {
    const arr = [];
    let prev = "";
    let ct = 0;
    for (let i = 0; i < directions.length; i++) {
        let cd = directions[i]
        ct++;
        if (cd != prev) {
            arr.push([cd, ct]);
            ct = 0; 
        }
        arr[arr.length - 1][1] = ct+1
        prev = cd
    }
    console.log(arr);
    const stk = [];
    let collisionCt = 0;
    for (let [cur, cCt] of arr) {
        if (stk.length > 0) {
            const [prev, pCt] = stk.at(-1);

            if (prev === "R") {
                if (cur === "L") {
                    collisionCt += cCt + pCt;
                    stk.pop();
                    stk.push(["S", 1]);
                    continue;
                } else if (cur === "S") {
                    collisionCt += pCt;
                    stk.pop();
                }
            } else if (prev === "S") {
                if (cur === "L") {
                    collisionCt += cCt;
                    continue;
                }
            }
        }
        stk.push([cur, cCt]);
    }

    return collisionCt;
};

let directions;
// directions = "RLRSLLLRRR"
// directions = "LLRR"
directions = "LRRLSLRSRLLSLL"


console.log(countCollisions(directions));