var minDeletionSize = function (strs) {
    const n = strs.length
    const sn = strs[0].length
    let resolved = Array(n).fill(false);
    let ct = 0;
    for (let i = 0; i < sn; i++) {
        let cond = false;
        for (let j = 1; j < n; j++) {
            if (!resolved[j] && strs[j - 1][i] > strs[j][i]) {
                cond = true;
                ct++;
                break;
            }
        }
        if (cond) { continue; }

        for (let j = 1; j < n; j++) {
            if (!resolved[j] && strs[j - 1][i] < strs[j][i]) {
                resolved[j] = true
            }
        }
        console.log(i, 'resolved', resolved);
    }
    console.log(ct);
    return ct
};

let strs;

// strs = ["ca","bb","ac"]
// strs = ["xc","yb","za"]
// strs = ["zyx","wvu","tsr"]
// strs = ["bbjwefkpb","axmksfchw"]
strs = ["fedcba", "fedcbb", "fedcbc", "feddbb", "ffddbb"]


minDeletionSize(strs)