var recoverTree = function(root) { // SC: O(h + n)
    function inorder(node) {
        if(node === null) {
            return
        }

        inorder(node.left)
        if(node.val !== null) {
            arr.push(node.val)
        }
        inorder(node.right)
    }

    function updateValue(node, p1, p2) {
        if(node === null) {
            return
        }

        if(node.val === p1) {
            node.val = p2
        } else if (node.val === p2) {
            node.val = p1
        }
        updateValue(node.left, p1, p2)
        updateValue(node.right, p1, p2)
        
    }

    const arr = []
    inorder(root)

    let p1, p2;
    let isFirst = true
    for(let i = 0; i < arr.length-1; i++) {
        if(arr[i] > arr[i+1]) {
            if(isFirst) {
                p1 = arr[i]
                p2 = arr[i+1]
                isFirst = false
            } else {
                p2 = arr[i+1]
            }
        }
    }

    updateValue(root, p1, p2)
};

var recoverTree = function(root) { // SC: O(h)
    let prev = first = second = null
    function inorder(node) {
        if(node === null) {
            return
        }
        
        inorder(node.left)
        if(prev && node.val < prev.val) {
            if(first === null) {
                first = prev
            }
            second = node
        }
        prev = node
        inorder(node.right)
    }

    inorder(root)

    let temp = first.val
    first.val = second.val
    second.val = temp
};