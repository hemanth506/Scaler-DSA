class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class partitionList {
    void printLL (ListNode rHead) {
        ListNode tempRHead = rHead;
        while (tempRHead != null) {
            // System.out.print(tempRHead.val + " ");
            tempRHead = tempRHead.next;
        }
        // System.out.println();
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

    public ListNode partition(ListNode A, int B) {
        if(A.next == null) {
            return A;
        }
        ListNode tempA = A;
        ListNode helper = null;
        ListNode lessNode = null;
        ListNode greaterOREqual = null;
        while (tempA != null) {
            helper = tempA;
            tempA = tempA.next;
            if(helper.val < B) {
                // System.out.println("helper.val = " + helper.val);
                if(lessNode == null) {
                    helper.next = null;
                    lessNode = helper;
                } else {
                    helper.next = lessNode;
                    lessNode = helper;
                }
            } else {
                // System.out.println("helper.val " + helper.val);
                if(greaterOREqual == null) {
                    helper.next = null;
                    greaterOREqual = helper;
                } else {
                    helper.next = greaterOREqual;
                    greaterOREqual = helper;
                }
            }
        }
        ListNode templessNode = lessNode;
        ListNode reversedlessNode = reverseNode(lessNode);

        if(lessNode != null && lessNode.next != null) {
            lessNode.next = null;
        }
        greaterOREqual = reverseNode(greaterOREqual);
        if(lessNode != null) {
            templessNode.next = greaterOREqual;
        } else {
            reversedlessNode = greaterOREqual;
        }
        
        return reversedlessNode;
    }
}
