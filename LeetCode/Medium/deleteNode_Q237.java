/* 
 In the question, it was asked only to delete the value of the node, not the actual node itself.
 NOTE: Read the question properly and completely.
 */

import Medium.ListNode;

public class deleteNode_Q237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
