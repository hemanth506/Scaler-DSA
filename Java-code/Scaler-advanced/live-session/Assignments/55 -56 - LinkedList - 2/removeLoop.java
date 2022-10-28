import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class removeLoop {
    // With extra space using hashset
    public ListNode solveWith(ListNode A) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode head = A;
        ListNode tail = null;
        while (head.next!=null && !hs.contains(head)) {
            tail = head;
            hs.add(head);
            head = head.next;
        }
        if(hs.contains(head)) {
            tail.next = null;
        }
        return A;
    }

    // Without extra space
    public ListNode solve(ListNode A) {
        ListNode head = A;

        ListNode Slow = A;
        ListNode Fast = A;
        boolean isCyclic = false;
        while (Fast.next != null && Fast.next.next != null) {
            Slow = Slow.next;
            Fast = Fast.next.next;
            // System.out.println("test = " + Slow.val + " " + Fast.val);
            if(Fast == Slow) {
                isCyclic = true;
                break;
            }
        }
        if(!isCyclic) {
            return head;
        }

        // System.out.println("cyclic");

        ListNode S1 = A;
        ListNode S2 = Fast;
        ListNode prev = null;
        while (S1 != S2) {
            prev = S2;
            S1 = S1.next;
            S2 = S2.next;
        }
        prev.next = null;

        return head;
    }

    public static void main(String[] args) {
        
    }
}
