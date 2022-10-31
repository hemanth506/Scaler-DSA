import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class isPalindrome {
    // with extra space
    public int lPalinWithSpace(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        ArrayList<Integer> values = new ArrayList<Integer>();
        // Adding the first value
        if(A != null) {
            values.add(slow.val);
        }

        // Iterating and adding the value till middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            values.add(slow.val);
            fast = fast.next.next;
        }
        
        ListNode mid = null;
        // odd length
        if(fast.next == null) { 
            mid = slow.next;
        } 
        // even length
        else if(fast.next.next == null) { 
            // Check if the middle two elemets are same
            if(slow.val != slow.next.val) {
                return 0;
            }
            mid = slow.next.next;
        }
        
        int N = values.size();
        // System.out.println(values + " " + N);
        values.remove(N - 1);
        N = values.size();
        // System.out.println(N);

        int i = 1;
        while (mid != null) {
            // System.out.println("N-i " + (N - i) + " " + mid.val);
            if(values.get(N - i) != mid.val) {
                return 0;
            }
            mid = mid.next;
            i += 1;
        }

        return 1;
    }

    // with no extra space
    public ListNode midNode(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseNode(ListNode A) {
        ListNode tempA = A;
        ListNode rHead = null;
        ListNode helper = null;
        while (tempA != null) {
            helper = tempA;
            tempA = tempA.next;
            if(rHead == null) {
                helper.next = null;
                rHead = helper;
            } else {
                helper.next = rHead;
                rHead = helper;
            }
        } 
        return rHead;
    }

    public int lPalin(ListNode A) {
        ListNode firstHalf = A;
        ListNode midNode = midNode(A);
        ListNode secondHalf = midNode.next;
        midNode.next = null;

        ListNode reversedNode = reverseNode(secondHalf);
        ListNode rNode = reversedNode;
        while(rNode != null) {
            if(firstHalf.val != rNode.val) {
                return 0;
            } 
            rNode = rNode.next;
            firstHalf = firstHalf.next;
        }
        return 1;
    }
}
