import java.util.ArrayList;
import java.util.Arrays;

class Node {
    Node c[] = new Node[2];
    Node() {
        c[0] = null;
        c[1] = null;
    }
}

public class maximumXOR {
    public int getMostSignBit(ArrayList<Integer> A) {
        int maxInt = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++) {
            maxInt = Integer.max(maxInt, A.get(i));
        }

        int bit = 0;
        for(int i = 31; i >= 0; i--) {
            System.out.println("maxInt = " + maxInt + " i = " + i + " maxInt>>i = " + (maxInt>>i));
            if(((maxInt>>i)&1) == 1) {
                bit = i;
                break;
            }
        }
        return bit;
    }

    public void insertNode(Node root, int number, int bit) {
        Node t = root;
        for(int i = bit; i >= 0; i--) {
            int b = (number>>i)&1;
            if(t.c[b] != null) {
                t = t.c[b];
            } else {
                Node nn = new Node();
                t.c[b] = nn;
                t = t.c[b];
            }
        }
    }

    public int maxXOR(Node root, int number, int bit) {
        Node t = root;
        int value = 0;
        for(int i = bit; i >= 0; i--) {
            int b = (number>>i)&1;
            System.out.println("i = " + i + " number>>i = " + (number>>i) + " b = " + b);
            if(t.c[1-b] != null) {
                value += (1<<i);
                t = t.c[1-b];
            } else {
                t = t.c[b];
            }
        }
        return value;
    }
    
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int bit = getMostSignBit(A);
        System.out.println(bit);
        Node root = new Node();
        for(int i = 0; i < N; i++){
            insertNode(root, A.get(i), bit);
        }

        int mXOR = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            mXOR = Integer.max(mXOR, maxXOR(root, A.get(i), bit));
        }

        System.out.println(mXOR);
        
        return mXOR;
    }

    public static void main(String[] args) {
        maximumXOR xor = new maximumXOR();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        xor.solve(A);
    }
}
