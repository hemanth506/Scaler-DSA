import Medium.ListNode;

public class mergeSortList {
    private ListNode getMid(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        if(f == null) {
            return f;
        }
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode secHead = mid.next;
        mid.next = null;
        ListNode t1 = mergeSort(head);
        ListNode t2 = mergeSort(secHead);
        ListNode t3 = mergeArray(t1, t2);
        return t3;
    }

    private ListNode mergeArray(ListNode head, ListNode secHead) {
        ListNode p1 = head;
        ListNode p2 = secHead;
        if(p1 == null) {
            return p1;
        }

        if (p2 == null) {
            return p2;
        }

        ListNode master = null;
        if(p1.val < p2.val) {
            master = p1;
            p1 = p1.next;
        } else {
            master = p2;
            p2 = p2.next;
        }

        ListNode temp = master;
        while (p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                temp.next = p1;
                temp = temp.next;
                p1 = p1.next;
            } else {
                temp.next = p2;
                temp = temp.next;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            temp.next = p1;
            temp = temp.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            temp.next = p2;
            temp = temp.next;
            p2 = p2.next;
        }
        return master;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode sortedHead = mergeSort(temp);
        return sortedHead;
    }
}
