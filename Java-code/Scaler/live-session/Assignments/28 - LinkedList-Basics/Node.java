/*
 * 
 * static Node head = null;
static class Node {
    int data;
    Node next;
    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

public static void insert_node(int position, int value) {
    Node newNode = new Node(value);
    if (position == 1) {
        if (head == null) { // if list is empty
            head = newNode;
        } else { // if the list is not empty but we have to place the value in first position.
            newNode.next = head;
            head = newNode; 
        }
    } else {
        Node t = head;
        for(int i = 2; i < position; i++) {
            t = t.next;
            if (t == null) { // the position is exceeding the all list node itself
                return;
            }
        }
        newNode.next = t.next;
        t.next = newNode;
    }
}

public static void delete_node(int position) {
    Node t = head;
    if(position == 1) {
        if(head == null) { // if the llist has no nodes and still needs to delete the first's node
            return;
        } else { // assigning the t.next node to head
            head = t.next;
            return;
        }
    }

    for(int i = 2; i < position; i++) {
        t = t.next;
        if (t == null || t.next == null) {
            return;
        }
    }
    Node deleteNext = t.next.next;
    t.next = deleteNext;
    // System.out.println("It is deleted => " + position);
}

public static void print_ll() {
    Node t = head;
    while (t != null) {
        if(t.next == null) {
            System.out.print(t.data);
        } else {
            System.out.print(t.data + " ");
        }
        t = t.next;
    }
}


 */