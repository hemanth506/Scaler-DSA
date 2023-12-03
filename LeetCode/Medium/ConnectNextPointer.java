
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

public class ConnectNextPointer {
  public Node connect(Node root) {
    if (root == null || root.left == null) {
      return root;
    }

    Node t = root;
    Node r = t;
    while (r != null) {
      Node f = t.left;
      while (t != null && f != null) {
        f.next = t.right;
        t = t.next;
        f = f.next;
        if (t != null) {
          f.next = t.left;
          f = f.next;
        }
      }
      t = r.left;
      r = t;
    }
    return root;
  }
}
