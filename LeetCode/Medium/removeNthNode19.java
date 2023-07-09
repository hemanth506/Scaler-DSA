import Medium.ListNode;

public class removeNthNode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int ct = 0;
        ListNode h = head;
        while(h != null) {
            ct += 1;
            h = h.next;
        }

        int removeIt = ct - n + 1;
        ListNode th = head; 
        for(int i = 1; i < removeIt; i++) {
            th = th.next;
        }

        if(th.next != null && th.next.next != null) {
            th.next = th.next.next;
        } else {
            th.next = null;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}
