class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class minStack {
    Node head = null;
    Node headMin = null;
    int minElt = Integer.MAX_VALUE;

    public void push(int x) {
        System.out.println("Push ++++ " + x);
        if (x <= minElt) {
            System.out.println(x + " <= " + minElt);
            Node minNd = new Node(x);
            minNd.next = headMin;
            headMin = minNd;
            minElt = x;
        }
        Node nd = new Node(x);
        nd.next = head;
        head = nd;
        // System.out.println("Push => " + nd.data);
    }

    public void pop() {
        // System.out.println("pop");
        if (head != null) {
            if (headMin != null && head.data == headMin.data) {
                Node tMin = headMin;
                headMin = tMin.next;

                // don't forget to update the minElt value
                if (headMin != null) {
                    minElt = headMin.data;
                } else {
                    minElt = Integer.MAX_VALUE;
                }
            }
            Node t = head;
            head = t.next;
        }
    }

    public int top() {
        int val = head != null ? head.data : -1;
        System.out.println("TopVal ----> " + val);
        return val;
    }

    public int getMin() {
        if (headMin != null && head != null) {
            Node t = headMin;
            int MinVal = t.data;
            System.out.println("MinVal => " + MinVal);
            return MinVal;
        } else {
            System.out.println(-1);
            return -1;
        }
    }

    public void display() {
        Node t = head;

        while (t.next != null) {
            System.out.println(t.data);
            t = t.next;
        }
        System.out.println(t.data);
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        minStack ms = new minStack();

        // ms.push(1);
        // ms.push(2);
        // ms.push(-2);
        // ms.push(-2);
        // ms.getMin();
        // ms.pop();
        // ms.getMin();
        // ms.top();
        // ms.pop();
        // ms.getMin();
        // ms.pop();
        // ms.getMin();

        // ms.push(10); // P 10
        // ms.push(9); // P 9
        // ms.getMin(); // g
        // ms.push(8); // P 8
        // ms.getMin(); // g
        // ms.push(7); // P 7
        // ms.getMin(); // g
        // ms.push(6); // P 6
        // ms.getMin(); // g
        // ms.pop(); // p
        // ms.getMin(); // g
        // ms.pop(); // p
        // ms.getMin(); // g
        // ms.pop(); // p
        // ms.getMin(); // g
        // ms.pop(); // p
        // ms.getMin(); // g
        // ms.pop(); // p
        // ms.getMin(); // g

        ms.pop();
        ms.push(644643544);
        ms.getMin();
        ms.top();
        ms.top();
        ms.top();
        ms.pop();
        ms.push(723943208);
        ms.pop();
        ms.push(909204);
        ms.getMin();
        ms.top();
        ms.getMin();
        ms.top();
        ms.push(481523691);
        ms.pop();
        ms.push(465865082);
        ms.top();
        ms.push(243519307);
        ms.pop();
        ms.top();
        ms.pop();
        ms.push(844871295);
        ms.getMin();
        ms.push(573041392);
        ms.push(468497349);
        ms.pop();
        ms.top();
        ms.getMin();
        ms.push(776647984);
        ms.top();
        ms.pop();
        ms.top();

    }
}
