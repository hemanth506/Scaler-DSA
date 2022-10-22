
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class removeDuplicates {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode h = A;
        int ct = 0;
        while (h != null) {
            h = h.next;
            ct += 1;
        }

        if (ct == 1) {
            return A;
        }

        ListNode thead = A;
        ListNode nHead = null;
        ListNode UHead = null;
        boolean hasMismatch = false;
        while (thead != null && thead.next != null) {
            if(thead.val != thead.next.val) {
                // System.out.println(thead.val);
                if(nHead == null) {
                    UHead = thead;
                    nHead = thead;
                } else {
                    nHead.next = thead;
                    nHead = nHead.next;
                }
                hasMismatch = true;
            }
            thead = thead.next;
        }
        if(hasMismatch) {
            // Last node
            nHead.next = thead;
        } else {
            thead = thead.next;
            return thead;
        }

        return UHead;
    }

}

