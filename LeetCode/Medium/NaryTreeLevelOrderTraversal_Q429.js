[
  { val: 2, children: [] },
  {
    val: 3,
    children: [
      { val: 6, children: [] },
      {
        val: 7,
        children: [{ val: 11, children: [{ val: 14, children: [] }] }],
      },
    ],
  },
  { val: 4, children: [{ val: 8, children: [{ val: 12, children: [] }] }] },
  {
    val: 5,
    children: [
      { val: 9, children: [{ val: 13, children: [] }] },
      { val: 10, children: [] },
    ],
  },
];


var levelOrder = function(root) {
    // console.log(JSON.stringify(root.children, 2, null))
    let ind = 0
    const que = [root]
    const finalLevelArr = []
    while (que.length > ind) {
        const n = que.length - ind
        const level = []
        for(let k = ind; k <= n; k++, ind++) {
            const curNode = que[ind]
            level.push(curNode.val)
            for(let j = 0; j < curNode.children.length; j++) {
                que.push(curNode.children[j])
            }
        }
        finalLevelArr.push(level)
    }
    finalLevelArr
};