
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class swapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode root = head.next;
        ListNode prev = null;
        while (temp != null && temp.next != null) {
            ListNode t1 = temp;
            ListNode t2 = temp.next;

            if(prev != null) {
                prev.next = t2;
            }
            t1.next = t2.next;
            t2.next = t1;

            prev = t1;
            temp = t1.next;
        }

        return root;
    }
}
