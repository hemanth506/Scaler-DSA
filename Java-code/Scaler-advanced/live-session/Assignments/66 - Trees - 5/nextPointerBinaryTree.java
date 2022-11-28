class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class nextPointerBinaryTree {
    public void connect(TreeLinkNode root) {
        TreeLinkNode t = root;
        while(t.left != null) {
            TreeLinkNode f = t;
            while(t != null) {
                t.left.next = t.right;
                if(t.next != null) {
                    t.right.next = t.next.left;
                }
                t = t.next;
            }
            t = f.left; // assign the next level
        } 
    }
}
