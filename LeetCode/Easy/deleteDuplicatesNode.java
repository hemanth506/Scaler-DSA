class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class deleteDuplicatesNode {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }

    if (head.next == null) {
      return head;
    }

    ListNode tempHead = head;
    ListNode tail = head;

    while (tail != null) {
      if (head.val == tail.val) {
        tail = tail.next;
      } else {
        head.next = tail;
        head = head.next;
      }
    }

    head.next = tail;

    return tempHead;
  }
}
