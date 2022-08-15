import java.util.Scanner;

class LinkedList {
    static Node head;
    
    LinkedList() {
        head = null;
    }

    class Node {
        int data;
        Node next;
        Node (int val) {
            data = val;
            next = null;
        }
    }

    public void insertAtbeginning(int val) {
        Node newNode = new Node(val); 
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        Node t = head;
        while (t != null) {
            if (t.next == null) {
                System.out.print(t.data);
            } else {
                System.out.print(t.data + " + ");
            }
            t = t.next;
        }
    }

    public void insertAtPosition(int position, int val) {
        Node newNode = new Node(val);
        if (position == 1) {
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode; 
            }
        } else {
            Node t = head;
            for(int i = 2; i < position; i++) {
                t = t.next;
                if (t == null) {
                    return;
                }
            }
            newNode.next = t.next;
            t.next = newNode;
        }
    }


    public void deleteAtPosition(int position) {
        Node t = head;
        for(int i = 2; i < position; i++) {
            t = t.next;
            if (t == null) {
                return;
            }
        }
        Node deleteNext = t.next.next;
        t.next = deleteNext;
    }

    public int checkDiff (String output1, String output2) {
        String[] output1Char = output1.split(" ");
        String[] output2Char = output2.split(" ");
        for (int i = 0; i < output1Char.length; i++) {
            // System.out.println(output1Char[i] + " " + output2Char[i]);
            if (Integer.parseInt(output1Char[i]) != Integer.parseInt(output2Char[i])) {
                System.out.println(output1Char[i] + " " + output2Char[i]);
                System.out.println("error in = "+ i);
                return i;
            }
        }
        System.out.println("all same");
        return 0;
    }

}


public class logicLinkedList{
    public static void main(String[] args) {
        LinkedList listLinked = new LinkedList();
        listLinked.insertAtPosition(1, 2);
        listLinked.insertAtPosition(2, 4);
        listLinked.insertAtPosition(3, 6);
        listLinked.insertAtPosition(4, 8);
        listLinked.insertAtPosition(5, 10);
        listLinked.display(); System.out.println("");

        listLinked.insertAtPosition(6, 20);
        listLinked.display(); System.out.println("");

        listLinked.insertAtPosition(4, 30);
        listLinked.display(); System.out.println("");

        listLinked.insertAtPosition(1, 22);
        listLinked.display(); System.out.println("");

        listLinked.insertAtPosition(15, 40);
        listLinked.display(); System.out.println("");

        listLinked.deleteAtPosition(4);
        listLinked.display(); System.out.println("");

        listLinked.deleteAtPosition(4);
        listLinked.display(); System.out.println("");

        // listLinked.checkDiff("226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 5 184 150 572 626 109 807 226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 572 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 54", "226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 5 184 150 572 626 109 807 226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 572 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807 226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 32");

        // Scanner sc = new Scanner(System.in);
        // System.out.println("No of commands => ");
        // int noCmd = sc.nextInt();
        // for (int i = 0; i < noCmd; i++) {
        //     System.out.println("command type => ");
        //     String cmd = sc.next();

        //     if (cmd.equals("p")) {
        //         listLinked.display();
        //     }
        //     else if (cmd.equals("d")) {
        //         listLinked.deleteAtPosition(sc.nextInt());
        //     } 
        //     else if (cmd.equals("i")) {
        //         listLinked.insertAtPosition(sc.nextInt(), sc.nextInt());
        //     }
        // }
        // sc.close();
    }
}