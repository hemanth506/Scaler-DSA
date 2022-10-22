
public class reversedLL {
    public ListNode reverseList(ListNode A) {
        ListNode revHead = null;
        ListNode head = A;
        while (head != null) {
            ListNode tempV = head;
            head = head.next;
            tempV.next = revHead;
            revHead = tempV;
        }
        return revHead;
    }
}
