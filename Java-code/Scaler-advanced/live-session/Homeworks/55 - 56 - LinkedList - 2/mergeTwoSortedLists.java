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
        ListNode hA = A;
        ListNode hB = B;

        ListNode head = null;
        ListNode tail = null;
        if(hA.val < hB.val) {
            head = hA;
            tail = hA;
            hA = hA.next;
        } else {
            head = hB;
            tail = hB;
            hB = hB.next;   
        }

        while (hA != null && hB != null) {
            if(hA.val < hB.val) {
                tail.next = hA;
                tail = hA;
                hA = hA.next;
            } else {
                tail.next = hB;
                tail = hB;
                hB = hB.next;
            }
        }

        if(hA != null) {
            tail.next = hA;
            tail = hA;
        } else {
            tail.next = hB;
            tail = hB;
        }

        return head;
    }
}
