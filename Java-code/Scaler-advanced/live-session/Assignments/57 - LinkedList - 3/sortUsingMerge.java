class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class sortUsingMerge {
    public ListNode[] splitNodes(ListNode A) {
        ListNode head1 = A;
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode[] separatedNodes = {head1, head2};
        return separatedNodes;
    }

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

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        }

        ListNode[] separatedNodes = splitNodes(A);
        ListNode N1 = sortList(separatedNodes[0]);
        ListNode N2 = sortList(separatedNodes[1]);
        ListNode N3 = mergeTwoLists(N1, N2);
        return N3;
    }
}
