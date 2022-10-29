class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class mergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = null;
        ListNode tail = null;

        if(A.val < B.val) {
            head = A;
            tail = A;
            A = A.next;
        } else {
            head = B;
            tail = B;
            B = B.next;
        }

        while (A != null && B != null) {
            if(A.val < B.val) {
                tail.next = A;
                tail = A;
                A = A.next;
            } else {
                tail.next = B;
                tail = B;
                B = B.next;
            }
        }
        if(A != null) {
            tail.next = A;
            tail = tail.next;
        } else {
            tail.next = B;
            tail = tail.next;
        }

        return head;
    }


}
