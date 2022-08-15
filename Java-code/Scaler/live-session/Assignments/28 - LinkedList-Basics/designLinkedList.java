/*
 * 0 => Add the node value of x in the first node of the linkedList
 * 1 => Append a node of value x to the last element of the linked list.
 * 2 => Add a node of value x before the indexth node in the linked list.If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * 3 => Delete the indexth node in the linked list, if the index is valid.
 */

import java.util.ArrayList;
import java.util.Arrays;

class ListNode {
    public int data;
    public ListNode next;

    ListNode(int value) {
        data = value;
        next = null;
    }
}

public class designLinkedList {
    public ListNode solve(ArrayList<ArrayList<Integer>> A) {
        ListNode head = null;

        int N = A.size();
        for (int i = 0; i < N; i++) {
            System.out.println(A.get(i));
            int firstIndex = A.get(i).get(0);
            int secondIndex = A.get(i).get(1);
            int thirdIndex = A.get(i).get(2);

            if (firstIndex == 0) {
                // System.out.print(" Zero ");System.out.println();
                ListNode newNode = new ListNode(secondIndex);
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode t = head;
                    newNode.next = t;
                    head = newNode;
                }

                ListNode h = head;
                while (h != null) {
                    System.out.print(h.data + "=>");
                    h = h.next;
                }
                System.out.println();
                System.out.println("================");
            } else if (firstIndex == 1) {
                // System.out.print(" One ");System.out.println();
                ListNode newNode = new ListNode(secondIndex);
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode t = head;
                    while (t.next != null) {
                        t = t.next;
                    }
                    t.next = newNode;
                }

                ListNode h = head;
                while (h != null) {
                    System.out.print(h.data + "=>");
                    h = h.next;
                }
                System.out.println();
                System.out.println("================");
            } else if (firstIndex == 2) {
                // System.out.print(" Two ");System.out.println();
                ListNode newNode = new ListNode(secondIndex);
                ListNode t = head;
                boolean exceedPos = false;
                if (head == null) {
                    if (thirdIndex == 0) {
                        head = newNode;
                    }
                } else {
                    for (int j = 1; j < thirdIndex; j++) {
                        if (t.next == null) {
                            exceedPos = true;
                            break;
                        }
                        t = t.next;
                    }
                    if (!exceedPos) {
                        if (thirdIndex == 0) {
                            newNode.next = head;
                            head = newNode;
                        } else {
                            newNode.next = t.next;
                            t.next = newNode;
                        }
                    }
                }

                ListNode h = head;
                while (h != null) {
                    System.out.print(h.data + "=>");
                    h = h.next;
                }
                System.out.println();
                System.out.println("================");
            } else if (firstIndex == 3) {
                // System.out.print(" Three ");System.out.println();
                ListNode t = head;
                boolean exceedPos = false;
                if (head != null) {
                    for (int j = 1; j < secondIndex; j++) {
                        t = t.next;
                        if (t.next == null) {
                            exceedPos = true;
                            break;
                        }
                    }
                    if (!exceedPos) {
                        if (t.next != null) {
                            if (secondIndex == 0) {
                                head = t.next;
                            } else {
                                ListNode deleteNode = t.next.next;
                                t.next = deleteNode;
                            }
                        } else {
                            head = null;
                        }
                    }
                }

                ListNode h = head;
                while (h != null) {
                    System.out.print(h.data + "=>");
                    h = h.next;
                }
                System.out.println();
                System.out.println("================");
            }
        }

        ListNode h = head;
        while (h != null) {
            System.out.print(h.data + "=>");
            h = h.next;
        }
        System.out.print("NULL");
        // System.out.println(head);
        return head;
    }

    public static void main(String[] args) {
        designLinkedList ds = new designLinkedList();
        // ArrayList<ArrayList<Integer>> A = new
        // ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<>(Arrays.asList(0,
        // 1, -1)),
        // new ArrayList<>(Arrays.asList(1, 2, -1)),
        // new ArrayList<>(Arrays.asList(2, 3, 1)),
        // new ArrayList<>(Arrays.asList(0, 4, -1)),
        // new ArrayList<>(Arrays.asList(3, 1, -1)),
        // new ArrayList<>(Arrays.asList(3, 2, -1))
        // )); // ANS : 4=>3=>NULL

        // ArrayList<ArrayList<Integer>> A = new
        // ArrayList<ArrayList<Integer>>(Arrays.asList(
        // new ArrayList<>(Arrays.asList(2, 6, 0)),
        // new ArrayList<>(Arrays.asList(1, 17, -1)),
        // new ArrayList<>(Arrays.asList(1, 19, -1)),
        // new ArrayList<>(Arrays.asList(2, 16, 1)),
        // new ArrayList<>(Arrays.asList(1, 13, -1)),
        // new ArrayList<>(Arrays.asList(3, 3, -1)),
        // new ArrayList<>(Arrays.asList(1, 19, -1))
        // )); // ANS : 6=>16=>17=>13=>19=>NULL

        // ArrayList<ArrayList<Integer>> A = new
        // ArrayList<ArrayList<Integer>>(Arrays.asList(
        // new ArrayList<>(Arrays.asList(1, 13, -1)),
        // new ArrayList<>(Arrays.asList(3, 0, -1)),
        // new ArrayList<>(Arrays.asList(3, 1, -1)),
        // new ArrayList<>(Arrays.asList(2, 15, 0)),
        // new ArrayList<>(Arrays.asList(3, 0, -1)),
        // new ArrayList<>(Arrays.asList(1, 12, -1)),
        // new ArrayList<>(Arrays.asList(3, 0, -1)),
        // new ArrayList<>(Arrays.asList(1, 19, -1)),
        // new ArrayList<>(Arrays.asList(1, 13, -1)),
        // new ArrayList<>(Arrays.asList(3, 0, -1)),
        // new ArrayList<>(Arrays.asList(0, 12, -1)),
        // new ArrayList<>(Arrays.asList(1, 13, -1)),
        // new ArrayList<>(Arrays.asList(3, 2, -1))
        // )); // ANS : 12,13

        // ArrayList<ArrayList<Integer>> A = new
        // ArrayList<ArrayList<Integer>>(Arrays.asList(
        // new ArrayList<>(Arrays.asList(2, 18, 0)),
        // new ArrayList<>(Arrays.asList(2, 5, 1)),
        // new ArrayList<>(Arrays.asList(2, 8, 0)),
        // new ArrayList<>(Arrays.asList(1, 7, -1)),
        // new ArrayList<>(Arrays.asList(1, 5, -1))
        // )); // ANS : 8=>18=>5=>7=>5=>NULL

        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3, 1, -1)),
                new ArrayList<>(Arrays.asList(3, 1, -1)),
                new ArrayList<>(Arrays.asList(1, 18, -1)),
                new ArrayList<>(Arrays.asList(2, 12, 1)),
                new ArrayList<>(Arrays.asList(1, 17, -1)),
                new ArrayList<>(Arrays.asList(2, 11, 3)),
                new ArrayList<>(Arrays.asList(1, 19, -1)),
                new ArrayList<>(Arrays.asList(3, 0, -1)),
                new ArrayList<>(Arrays.asList(0, 12, -1)))); // ANS : 12=>12=>17=>11=>19=>NULL
        ds.solve(A);
    }
}
