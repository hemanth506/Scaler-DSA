var diameterOfBinaryTree = function(root) {
    let maxPerRoot = -Infinity
    function solve(root) {
        if(root === null) return -1;

        const left = solve(root.left);
        const right = solve(root.right);
        maxPerRoot = Math.max(maxPerRoot, left + right + 2);
        return Math.max(left, right) + 1
    }
    solve(root)
    return maxPerRoot
};