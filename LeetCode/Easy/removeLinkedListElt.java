class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class removeLinkedListElt {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(-1, head);
        ListNode top = newNode;
        head = newNode;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                if (head.next.next != null) {
                    head.next = head.next.next;
                } else {
                    head.next = null;
                }
            } else {
                head = head.next;
            }
        }
        if (top.next != null) {
            top = top.next;
        } else {
            top = null;
        }
        return top;
    }
}
