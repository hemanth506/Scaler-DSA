function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

var widthOfBinaryTree = function (root) {
    if (!root) return 0;
    
    let maxLen = 1
    let que = [[root, 1]]

    while (que.length > 0) {
        let newQue = [], idx = Array(2).fill(null)
        const N = que.length
        let baseId = que[0][1];

        for (let i = 1; i <= N; i++) {
            const [n, id] = que.shift()
            const normId = id - baseId;

            if (n.left !== null) {
                const leftId = normId * 2
                newQue.push([n.left, leftId])
                if (idx[0] === null) idx[0] = leftId;
                idx[1] = leftId;
            }

            if (n.right !== null) {
                const rightId = (normId * 2) + 1
                newQue.push([n.right, rightId])
                if (idx[0] === null) idx[0] = rightId;
                idx[1] = rightId;
            }

        }
        if (idx[1] !== null) {
            const len = idx[1] - idx[0] + 1
            maxLen = Math.max(maxLen, len)
        }
        if (idx[0] !== null) {
            que = newQue
        }
    }
    return maxLen
};