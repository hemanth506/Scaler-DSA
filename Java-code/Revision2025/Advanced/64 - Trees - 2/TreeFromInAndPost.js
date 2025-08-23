function TreeNode(data) {
  this.data = data;
  this.left = null;
  this.right = null;
}

function buildTree(A, B) {
  function construct(post, pL, pR, inOrder, inL, inR) {
    console.log('-----------------------------------')
    console.log('🚀 ~  ', post.slice(pL, pR+1), pL, pR, inOrder.slice(inL, inR+1), inL, inR);
    if (pL > pR || inL > inR) return null; 

    let ind = null;
    for (let i = inR; i >= inL; i--) {
      if (inOrder[i] === post[pR]) {
        ind = i;
        break;
      }
    }

    let k = inR - ind;
    console.log('ind:', ind, ' k:', k)
    const root = new TreeNode(post[pR]);
    console.log('root:', root)
    root.right = construct(post, pR - k, pR - 1, inOrder, ind + 1, inR);
    root.left = construct(post, pL, pR - k - 1, inOrder, inL, ind - 1);

    return root;
  }

  const Nc = A.length;
  const Nd = B.length;
  return construct(B, 0, Nd - 1, A, 0, Nc - 1);
}

const A = [6, 1, 3, 2];
const B = [6, 3, 2, 1];

const tree = buildTree(A, B);
postOrder(tree);

function postOrder(root) {
  if (root === null) return null;
  postOrder(root.left);
  postOrder(root.right);
  console.log(root.data);
}