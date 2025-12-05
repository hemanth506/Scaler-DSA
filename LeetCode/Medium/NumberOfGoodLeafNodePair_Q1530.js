var countPairs = function (root, distance) {
    let ct = 0

    function dfs(node) {
        if (!node) return new Array(distance).fill(0);

        if (!node.left && !node.right) {
            const arr = new Array(distance).fill(0);
            arr[0] = 1;
            return arr;
        }

        const leftArr = dfs(node.left);
        const rightArr = dfs(node.right);

        const arr = Array(distance).fill(0); 
        for (let i = 0; i < distance; i++) {
            if (leftArr[i] === 0) continue;
            const dl = i + 1

            for (let j = 0; j < distance; j++) {
                if (rightArr[j] === 0) continue;
                const dr = j + 1

                if ((dl + dr) <= distance) {
                    ct += (leftArr[i] * rightArr[j]);
                }
            }
        }

        for(let i = 0; i < distance-1; i++) {
            if(leftArr[i] > 0) arr[i+1] += leftArr[i]
            if(rightArr[i] > 0) arr[i+1] += rightArr[i]
        }
        return arr
    }

    dfs(root)
    return ct
};