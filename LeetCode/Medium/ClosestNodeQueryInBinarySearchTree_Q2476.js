var closestNodes = function(root, queries) { // Node recursion -- TLE
    function solve(node, query, min, max) {
        if(node === null) {
            return [min, max]
        }

        if(node.val === query) {
            min = query; max = query;
            return [min, max]
        }
        if(node.val > query) {
            max = node.val
            return solve(node.left,query, min, max)
        } else {
            min = node.val
            return solve(node.right,query, min, max)
        }
    }

    let res = []
    for(let query of queries) {
        const [min, max] = solve(root, query, -1, -1)
        res.push([min, max])
    }

    return res
};

var closestNodes = function(root, queries) { // convert to array and do BS
    const inorderArr = []
    function inorder (node) {
        if(node === null) {
            return null
        }
        inorder(node.left)
        inorderArr.push(node.val)
        inorder(node.right)
    }
    inorder(root)
    const n = inorderArr.length
    function bs(elt) {
        let l = 0, h = n-1
        let idx = -1
        while (l <= h) {
            let m = Math.floor((l+h) / 2)
            if(inorderArr[m] === elt) {
                return m
            }

            if(inorderArr[m] < elt) {
                l = m + 1
            } else {
                idx = m
                h = m - 1
            }
        }

        return idx
    }
    let res = []
    for(let q of queries) {
        const id = bs(q)
        if(inorderArr[id] === q) {
            res.push([q, q])
        } else if (id === -1) {
            res.push([inorderArr[n-1], id])
        } else if (id === 0) {
            res.push([-1, inorderArr[id]])
        } else {
            res.push([inorderArr[id-1], inorderArr[id]])
        }

    }
    return res
}