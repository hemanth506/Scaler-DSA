class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class reversedLL2 {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(B == 1 && C == 1) {
            return A;
        }
        ListNode actualHead = A;
        ListNode h = A;

        int ct = 1;
        ListNode rangeSt = null;
        if(B != 1) {
            while(h != null && ct < B) {
                rangeSt = h;
                h = h.next;
                ct += 1;
            }
        }

        ListNode thead = h;
        ListNode head = h;
        ListNode rHead = null;
        int rangeCt = B;
        while(h != null && rangeCt <= C) {
            ListNode tempNode = thead;
            thead = thead.next;
            tempNode.next = rHead;
            rHead = tempNode;
            rangeCt+=1;
        }
        head.next = thead;
        if(B == 1) {
            return rHead;
        } else {
            rangeSt.next = rHead;
            return actualHead;
        }
    }
    
}
