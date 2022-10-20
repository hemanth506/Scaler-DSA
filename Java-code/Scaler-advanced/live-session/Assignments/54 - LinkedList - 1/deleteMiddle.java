
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class deleteMiddle {
    public ListNode solve(ListNode A) {
        ListNode hd = null;
        if(A == null) {
            return hd;
        }

        ListNode head = A;
        int nCt = 1;
        while(head.next != null) {
            nCt += 1;
            head = head.next;
        }

        if(nCt == 1) {
            return hd;
        }
        int middle = nCt/2;
            
        ListNode iterHead = A;
        for(int i = 1; i < middle; i++) {
            iterHead = iterHead.next;
        }

        iterHead.next = iterHead.next.next;
        return A;
    }
    public static void main(String[] args) {
        deleteMiddle dm = new deleteMiddle();
        ListNode A = new ListNode(10);
        dm.solve(A);
    }
}
