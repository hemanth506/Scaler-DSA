var MyRob = function(root) { // beats 17%
    const dp = new Map()

    function solve(root, sum) {
        if(root === null) {
            return -Infinity
        }

        if(!dp.has(root)) {
            let pick = root.val + sum
            let curPick = pick
            if(root.left) {
                pick += Math.max(solve(root.left.left, curPick), 0)
                pick += Math.max(solve(root.left.right, curPick), 0)
            }

            if(root.right) {
                pick += Math.max(solve(root.right.left, curPick), 0)
                pick += Math.max(solve(root.right.right, curPick), 0)
            }

            let leave = sum
            let curLeave = leave
            leave += Math.max(solve(root.left, curLeave), 0)
            leave += Math.max(solve(root.right, curLeave), 0)

            dp.set(root, Math.max(pick, leave))
        }

        return dp.get(root)
    }

    const res = solve(root, 0)
    console.log('res', res)
    return res
};

var rob = function(root) { // beats 88%
    const dp = new Map();

    function solve(node) {
        if (node === null) {
            return 0;
        }

        if (!dp.has(node)) {
            let robCurrent = node.val;
            if (node.left) {
                robCurrent += solve(node.left.left) + solve(node.left.right);
            }
            if (node.right) {
                robCurrent += solve(node.right.left) + solve(node.right.right);
            }

            let skipCurrent = solve(node.left) + solve(node.right);

            const result = Math.max(robCurrent, skipCurrent);
            dp.set(node, result);
        }

        return dp.get(node);
    }

    return solve(root);
}

// Alternative solution using bottom-up approach (more optimal)
var robOptimal = function(root) {
    // Returns [rob_this_node, skip_this_node]
    function helper(node) {
        if (node === null) {
            return [0, 0];
        }
        
        const left = helper(node.left);
        const right = helper(node.right);
        
        // If we rob this node, we can't rob children
        const robThis = node.val + left[1] + right[1];
        
        // If we skip this node, we take max from children
        const skipThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return [robThis, skipThis];
    }
    
    const result = helper(root);
    return Math.max(result[0], result[1]);
}