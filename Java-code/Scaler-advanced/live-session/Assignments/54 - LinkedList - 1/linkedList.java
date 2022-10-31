class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class linkedList {
    static ListNode head = null;
    static int size = 0;

    public static void insert_node(int position, int value) {
        System.out.println("insert + " + position);
        ListNode top = head;
        ListNode node = new ListNode(value);
        if (head == null) {
            // System.out.println("First Node");
            head = node;
        } else {
            position -= 1;
            // System.out.println("Not first node " + position);
            int pos = 1;
            while (head.next != null && pos < position) {
                head = head.next;
                pos += 1;
            }
            node.next = head.next;
            head.next = node;

            // Final Declaration
            head = top;
        }
        size += 1;
    }

    public static void delete_node(int position) {
        System.out.println("delete = " + position + " === ");

        ListNode top = head;
        if (size >= position) {
            if(position == 1) {
                top = head.next;
            } else {
                position -= 1;
                for (int i = 1; i < position; i++) {
                    head = head.next;
                }

                if (head.next != null && head.next.next != null) {
                    System.out.println("if");
                    head.next = head.next.next;
                } else {
                    System.out.println("else");
                    head.next = null;
                    // head = head.next;
    
                }
            }
            size -= 1;
        }
        head = top;
        System.out.println(" ===  === ");
    }

    public static void print_ll() {
        System.out.print ("print == ");
        ListNode temp = head;
        System.out.print(temp.val);
        temp = temp.next;
        while (temp != null) {
            System.out.print(" " + temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedList.insert_node(1, 28);
        linkedList.insert_node(2, 26);
        linkedList.print_ll();
        linkedList.delete_node(1);
        linkedList.print_ll();

        linkedList.insert_node(3, 21);
        linkedList.insert_node(4, 20);
        linkedList.insert_node(5, 15);
        linkedList.print_ll();
        linkedList.insert_node(3, 22);
        linkedList.print_ll();
        linkedList.delete_node(1);
        linkedList.delete_node(4);
        linkedList.delete_node(3);
        
        linkedList.print_ll();
        linkedList.insert_node(5, 19);
        linkedList.print_ll();
    }
}



/*
 * static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

static ListNode head = null;
static int size = 0;
public static void insert_node(int position, int value) {
    // System.out.println("insert + " + position);
    ListNode top = head;
    ListNode node = new ListNode(value);
    if (head == null) {
        // System.out.println("First Node");
        head = node;
    } else {
        position -= 1;
        // System.out.println("Not first node " + position);
        int pos = 1;
        while (head.next != null && pos < position) {
            head = head.next;
            if (head == null) { // the position is exceeding the all list node itself
                return;
            } else {
                pos += 1;
            }
        }
        node.next = head.next;
        head.next = node;

        // Final Declaration
        head = top;
    }
    size += 1;
}

public static void delete_node(int position) {
    // System.out.println("delete = " + position + " === ");

    ListNode top = head;
    if (size >= position) {
        if(position == 1) {
            if(head == null) {
                return;
            } else {
                head = head.next;
            }
        } else {
            for (int i = 2; i < position; i++) {
                head = head.next;
            }

            if (head.next != null && head.next.next != null) {
                // System.out.println("if");
                head.next = head.next.next;
            } else {
                // System.out.println("else");
                head.next = null;
                // head = head.next;
            }
        }
        size -= 1;
    }
    head = top;
    // System.out.println(" ===  === ");
}

public static void print_ll() {
    // System.out.print ("print == ");
    ListNode temp = head;
    while (temp != null) {
        if(temp.next == null) {
            System.out.print(temp.val);
        } else {
            System.out.print(temp.val + " ");
        }
        temp = temp.next;
    }
    // System.out.println();
}

 */