class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class findMid {
    public int solve(ListNode A) {
        ListNode Slow = A;
        ListNode Fast = A;

        while (Fast.next != null && Fast.next.next != null) {
            Slow = Slow.next;
            Fast = Fast.next.next;
        }
        if(Fast.next == null) {
            return Slow.val;
        } else {
            return Slow.next.val;
        }
    }
    public static void main(String[] args) {
        
    }
}
