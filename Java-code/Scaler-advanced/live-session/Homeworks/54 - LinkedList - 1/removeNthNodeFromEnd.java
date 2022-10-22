class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class removeNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode tHead = A;
        int ct = 0;
        while(tHead != null) {
            ct += 1;
            tHead = tHead.next;
        }

        if(ct == 1) {
            A = null;
            return A;
        }
        int newB = ct - B;

        if(ct < B || newB == 1) {
            A = A.next;
            return A;
        }


        ListNode head = A;
        int ind = 1;
        while (head != null && ind < newB) {
            head = head.next;
            ind += 1;
        }
        if(head.next.next != null) {
            head.next = head.next.next;
        } else {
            head.next = null;
        }

        return A;
    }
}
