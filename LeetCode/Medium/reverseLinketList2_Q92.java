
import Medium.ListNode;

public class reverseLinketList2_Q92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode root = head;
        int ct = 1;

        ListNode startNode = null;
        ListNode prevNode = null;
        ListNode tempPrev = null;
        ListNode endNode = null;
        ListNode nextNode = null;

        while (root != null) {
            if (ct == left) {
                startNode = root;
                prevNode = tempPrev;
            }

            if (ct == right) {
                endNode = root;
                break;
            }

            tempPrev = root;
            root = root.next;
            ct += 1;
        }
        nextNode = root.next;
        endNode.next = null;
        reverseLL(startNode, endNode);

        startNode.next = nextNode;
        if (left == 1) {
            return endNode;
        }
        prevNode.next = endNode;
        return head;
    }

    private void reverseLL(ListNode startNode, ListNode endNode) {
        ListNode hdNode = startNode;
        ListNode temp = startNode;
        ListNode revNode = null;

        while (hdNode != null) {
            hdNode = hdNode.next;
            temp.next = revNode;
            revNode = temp;
            temp = hdNode;
        }
    }
}
