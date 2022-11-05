import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class nIntegerContainingOnly123 {
    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> al = new ArrayList<>();
        Queue<StringBuilder> que = new LinkedList<>();

        int i = 0;
        
        StringBuilder oneStr = new StringBuilder("1");
        que.add(oneStr);
        al.add(Integer.parseInt(oneStr.toString()));
        i++;
        if(i == A) {
            return al;
        }
        
        StringBuilder twoStr = new StringBuilder("2");
        que.add(twoStr);
        al.add(Integer.parseInt(twoStr.toString()));
        i++;
        if(i == A) {
            return al;
        }
        
        StringBuilder threeStr = new StringBuilder("3");
        que.add(threeStr);
        al.add(Integer.parseInt(threeStr.toString()));
        i++;
        if(i == A) {
            return al;
        }

        while(i <= A) {
            StringBuilder str = que.peek();
            System.out.println(str);

            StringBuilder one = new StringBuilder();
            one.append(str);
            one.append("1");
            System.out.println(one);
            que.add(one);
            al.add(Integer.parseInt(one.toString()));
            i++;
            if(i == A) {
                break;
            }

            StringBuilder two = new StringBuilder();
            two.append(str);
            two.append("2");
            System.out.println(two);
            que.add(two);
            al.add(Integer.parseInt(two.toString()));
            i++;
            if(i == A) {
                break;
            }

            StringBuilder three = new StringBuilder();
            three.append(str);
            three.append("3");
            System.out.println(three);
            que.add(three);
            al.add(Integer.parseInt(three.toString()));
            i++;
            if(i == A) {
                break;
            }
            que.remove();
        }
        System.out.println(que);
        System.out.println(al);
        return al;
    }
    public static void main(String[] args) {
        nIntegerContainingOnly123 n123 = new nIntegerContainingOnly123();
        int A = 7;
        n123.solve(A);
    }
}
