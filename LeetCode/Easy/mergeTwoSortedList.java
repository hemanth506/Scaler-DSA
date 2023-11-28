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

public class mergeTwoSortedList {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return null;
    }

    if (list1 == null || list2 == null) {
      if (list1 == null) {
        return list2;
      }

      if (list2 == null) {
        return list1;
      }
    }
    ListNode head;
    ListNode tail;

    if (list1.val >= list2.val) {
      head = list2;
      list2 = list2.next;
    } else {
      head = list1;
      list1 = list1.next;
    }
    tail = head;

    while (list1 != null || list2 != null) {
      if (list1.val >= list2.val) {
        tail.next = list2;
        list2 = list2.next;
      } else {
        tail.next = list1;
        list1 = list1.next;
      }
      tail = tail.next;
    }

    while (list1 != null) {
      tail.next = list1;
      list1 = list1.next;
      tail = tail.next;
    }

    while (list2 != null) {
      tail.next = list2;
      list2 = list2.next;
      tail = tail.next;
    }
    return head;
  }

}
