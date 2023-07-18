import java.util.HashMap;

class doubleLL {
    int key;
    int val;
    doubleLL next;
    doubleLL prev;
    doubleLL(int key, int val, doubleLL next, doubleLL prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}


public class LRUCache_Q146 {
    int size;
    int capacity;
    HashMap<Integer, doubleLL> hm;
    doubleLL head;
    doubleLL tail;

    LRUCache_Q146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hm = new HashMap<>();
        this.head = new doubleLL(-1, -1, tail, null);
        this.tail = new doubleLL(-1, -1, null, head);
    }

    public int get(int key) {
        System.out.println("Get " + key);
        if(hm.containsKey(key)) {
            doubleLL node = hm.get(key);
            System.out.println(node.val);
            delete(key);
            insertEnd(key, node.val);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println("Put");
        if(hm.containsKey(key)) {
            delete(key);
            insertEnd(key, value);
        } else {
            if(size == capacity) {
                deleteFirst();
            }
            insertEnd(key, value);
        }
    }

    public void delete (int key) {
        System.out.println("delete");
        doubleLL en = hm.get(key);
        en.prev.next = en.next;
        en.next.prev = en.prev;
        en.next = null;
        en.prev = null;
        hm.remove(key);
        size--;
    }

    public void deleteFirst() {
        System.out.println("delete first");
        doubleLL firstNode = head.next;
        doubleLL temp = firstNode.next;
        temp.prev = head;
        head.next = temp;
        hm.remove(firstNode.key);
        size--;
    }

    public void insertEnd(int key, int value) {
        System.out.println("insert end");
        doubleLL nn = new doubleLL(key, value, null, null);
        nn.prev = tail.prev;
        tail.prev = nn;
        nn.prev.next = nn;
        nn.next = tail;
        hm.put(key, nn);
        size++;
    }

    public static void main(String[] args) {
        // LRUCache_Q146 lru = new LRUCache_Q146(2);
        // lru.put(1, 1);
        // lru.put(2, 2);
        // lru.get(1);
        // lru.put(3, 3);
        // lru.get(2);

        // lru.put(4, 4);
        // lru.get(1);
        // lru.get(3);
        // lru.get(4);

        LRUCache_Q146 lru = new LRUCache_Q146(2);
        lru.get(2);
        lru.put(2, 6);
        lru.get(1);
        lru.put(1, 5);
        lru.put(1, 2);
        lru.get(1);
        lru.get(2);
    }
}
