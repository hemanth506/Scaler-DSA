import Medium.ListNode;

public class addTwoNumbers2_Q445 {
    int reminder = -1;
    ListNode node = new ListNode();

    public int getLengthOfLN(ListNode ln) {
        int ct = 0;
        ListNode root = ln;
        while (root != null) {
            root = root.next;
            ct += 1;
        }
        return ct;
    }

    public void findSum(int l1Len, int l2Len, ListNode root1, ListNode root2) {
        if (root1 == null && root2 == null) {
            return;
        }

        if (l1Len == l2Len) {
            findSum(l1Len - 1, l2Len - 1, root1.next, root2.next);
        } else if (l1Len > l2Len) {
            findSum(l1Len - 1, l2Len, root1.next, root2);
        }

        int sum = root1.val;
        if (l2Len == l1Len) {
            sum += root2.val;
        }

        if (reminder != -1) {
            sum += reminder;
        }

        int nVal = sum % 10;
        reminder = sum / 10;

        node.val = nVal;

        ListNode tempNode = new ListNode(-1);
        tempNode.next = node;
        node = tempNode;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Len = getLengthOfLN(l1);
        int l2Len = getLengthOfLN(l2);
        System.out.println(l1Len);
        System.out.println(l2Len);

        if (l1Len >= l2Len) {
            findSum(l1Len, l2Len, l1, l2);
        } else if (l1Len < l2Len) {
            findSum(l2Len, l1Len, l2, l1);
        }

        if (reminder > 0) {
            node.val = reminder;
        } else {
            node = node.next;
        }
        return node;
    }
}
