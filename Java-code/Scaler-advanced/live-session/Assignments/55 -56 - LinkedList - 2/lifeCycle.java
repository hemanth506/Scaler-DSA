
public class lifeCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        boolean isCyclic = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCyclic = true;
                break;
            }
        }
        if (!isCyclic) {
            return null;
        }

        ListNode s1 = a;
        ListNode s2 = fast;
        while (s1 != s2) {
            s1 = s1.next;
            s2 = s2.next;
        }
        return s2;
	}
    public static void main(String[] args) {
        
    }
}
