class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class kReverseLL {
    public ListNode reverseList(ListNode A, int B) {
        if (A == null) {
            return A;
        }
        ListNode head = A;
        ListNode tHead = A;
        ListNode revHead = null;
        int ct = 0;
        while (A != null && ct < B) {
            head = A;
            A = A.next;
            head.next = revHead;
            revHead = head;
            ct += 1;
        }

        ListNode currentSet = reverseList(A, B);
        tHead.next = currentSet;
        return revHead;
    }
    public static void main(String[] args) {
    }
}
