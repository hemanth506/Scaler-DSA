import Medium.ListNode;

public class rotateLinkedList {
    
    public ListNode rotateRight(ListNode head, int k) {
        int N = 0;
        if(k == 0 || head == null) {
            return head;
        }
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            N += 1;
        }
        k = k%N;
        if(k == 0) {
            return head;
        }

        ListNode nn = reverseComplete(head);

        ListNode[] heads = reverseList(nn, k);
        ListNode revHead = heads[0];
        ListNode revtail = heads[1];
        ListNode tailHead = heads[2];

        ListNode rH = reverseComplete(tailHead);
        revtail.next = rH;

        return revHead;
    }

    private ListNode reverseComplete(ListNode head) {
        ListNode temp = head;
        ListNode th = head;
        ListNode revNode = null;

        while (temp != null) {
            head = head.next;
            temp.next = revNode;
            revNode = temp;
            temp = head;
        }

        if (th != null) {
            th.next = head;
        }
 
        return revNode;
    }

    private ListNode[] reverseList(ListNode head, int N) {
        ListNode temp = head;
        ListNode th = head;
        ListNode revNode = null;

        int ct = 0;
        while (temp != null && ct < N) {
            head = head.next;
            temp.next = revNode;
            revNode = temp;
            temp = head;
            ct += 1;
        }

        th.next = head;

        ListNode[] ll = new ListNode[3];
        ll[0] = revNode; 
        ll[1] = th;
        ll[2] = head;
        return ll;
    }
}
