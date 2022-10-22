class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class reverseK {
    public ListNode reverseList(ListNode A, int B) {
        if(A == null) {
            return A;
        }

        ListNode tHead = A;
        ListNode rHead = A;
        ListNode th = null;
        int ct = 0;
        while(A != null && ct < B) {
            th = A;
            A = A.next;
            th.next = rHead;
            rHead = th;
            ct+=1;
        }
        tHead.next = A;
        return rHead;
    }
}
