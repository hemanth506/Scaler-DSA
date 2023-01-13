import java.util.HashMap;

class Node {
    int val;
    Node prev;
    Node next;

    Node(int x) {
        this.val = x;
        this.prev = null;
        this.next = null;
    }
}

class Pair {
    int value;
    Node addr;
    Pair (int val, Node addr) {
        this.value = val;
        this.addr = addr;
    }
}

public class LRUcache {
    HashMap<Integer, Pair> hm = new HashMap<Integer, Pair>();
    int size = 0;
    int memorySize = 0;
    Node d1;
    Node d2;
    public LRUcache(int capacity) {
        memorySize = capacity;
        d1 = new Node(-1);
        d2 = new Node(-1);
        d1.next = d2;
        d2.prev = d1;
    }

    // Get function is also like accessing that again, so it will come first.
    public int get(int key) {
        if(hm.containsKey(key)) {
            int val = hm.get(key).value;
            remove(key);
            insertLast(key, val);
            return val;
        }
        return -1;
    }

    public void remove(int key) {
        Node n = hm.get(key).addr;
        Node prevN = n.prev;
        prevN.next = n.next;

        Node nextN = n.next;
        nextN.prev = n.prev;
        hm.remove(key);
        size -= 1;
    }

    public void insertLast(int key, int value) {
        Node newNode = new Node(key);

        Pair newPair = new Pair(value, newNode);
        hm.put(key, newPair);

        Node prevN = d2.prev;
        Node nextN = prevN.next;

        newNode.prev = prevN;
        newNode.next = nextN;

        prevN.next = newNode;
        nextN.prev = newNode;
        size += 1;
    }

    public void deleteFirst() {
        Node delN = d1.next;
        
        Node nextN = delN.next;
        Node prevN = delN.prev;

        d1.next = nextN;
        nextN.prev = prevN;
        hm.remove(delN.val);
        size -= 1;
    }

    public void set(int key, int value) {
        if(hm.containsKey(key)) {
            remove(key);
        } else {
            if(size >= memorySize) {
                deleteFirst();
            }
        }
        insertLast(key, value);
    }
}
