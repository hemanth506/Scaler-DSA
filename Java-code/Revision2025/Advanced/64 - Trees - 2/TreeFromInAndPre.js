function TreeNode(data) {
  this.data = data;
  this.left = null;
  this.right = null;
}

function buildTree(A, B) {
  const NA = A.length;
  const NB = B.length;
  function construct(A, a1, a2, B, b1, b2) {
    console.log(A.slice(a1, a2), a1, a2, B.slice(b1, b2), b1, b2);
    if (b1 > b2) {
      return null;
    }

    let ind = null;
    for (let i = b1; i <= b2; i++) {
      if (B[i] === A[a1]) {
        ind = i;
        break;
      }
    }

    let k = ind - b1;
    const root = new TreeNode(A[a1]);
    console.log("🚀 ~ root:", root);
    root.left = construct(A, a1 + 1, a1 + k, B, b1, ind - 1);
    root.right = construct(A, a1 + k + 1, a2, B, ind + 1, b2);

    return root;
  }

  return construct(A, 0, NA - 1, B, 0, NB - 1);
}

// const A = [1, 6, 2, 3];
// const B = [6, 1, 3, 2];

const A = [1, 2, 3, 4, 5];
const B = [3, 2, 4, 1, 5];

const tree = buildTree(A, B);
preOrder(tree);

function preOrder(root) {
  if (root === null) return null;
  console.log(root.data);
  preOrder(root.left);
  preOrder(root.right);
}
