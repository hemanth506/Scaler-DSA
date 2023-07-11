public class evenOddLinkedList_Q328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode t1 = h1;
        ListNode prev = h1;

        ListNode h2 = head.next;
        ListNode t2 = h2;


        while (t1 != null && t2 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 != null) {
                prev = t1;
                t2.next = t1.next;
                t2 = t2.next;
            } else {
                t2.next = null;
            }
        }

        prev.next = h2;

        return h1;
    }
}
