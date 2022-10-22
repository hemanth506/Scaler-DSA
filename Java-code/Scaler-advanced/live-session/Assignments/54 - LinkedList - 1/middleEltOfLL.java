class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class middleEltOfLL {
    public int solve(ListNode A) {
        int countNode = 0;
        ListNode tempNode = A;
        while (tempNode != null) {
            tempNode = tempNode.next;
            countNode += 1;
        }
        int middleNode = (countNode / 2) + 1;

        int middleVal = 0;
        ListNode newTempNode = A;
        for (int i = 1; i <= middleNode; i++) {
            middleVal = newTempNode.val;
            if (newTempNode.next != null) {
                newTempNode = newTempNode.next;
            }
        }
        return middleVal;
    }

    public static void main(String[] args) {

    }
}
