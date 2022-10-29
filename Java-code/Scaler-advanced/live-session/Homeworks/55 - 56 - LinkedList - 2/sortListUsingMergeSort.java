class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class sortListUsingMergeSort {
    public ListNode[] splitWithMid(ListNode A) {
        ListNode firstHalf = A;
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode[] separateNodes = { firstHalf, secondHalf };
        return separateNodes;
    }

    public ListNode mergeListNode(ListNode A, ListNode B) {
        ListNode tempA = A;
        ListNode tempB = B;

        ListNode head = null;
        ListNode tail = null;

        if (tempA.val < tempB.val) {
            head = tempA;
            tail = tempA;
            tempA = tempA.next;
        } else {
            head = tempB;
            tail = tempB;
            tempB = tempB.next;
        }

        while (tempA != null && tempB != null) {
            if (tempA.val < tempB.val) {
                tail.next = tempA;
                tail = tempA;
                tempA = tempA.next;
            } else {
                tail.next = tempB;
                tail = tempB;
                tempB = tempB.next;
            }
        }

        if (tempA != null) {
            tail.next = tempA;
            tail = tempA.next;
        } else {
            tail.next = tempB;
            tail = tempB;
        }

        return head;
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode[] separateNodes = splitWithMid(A);
        ListNode head1 = sortList(separateNodes[0]);
        ListNode head2 = sortList(separateNodes[1]);
        ListNode head3 = mergeListNode(head1, head2);

        return head3;
    }

}
