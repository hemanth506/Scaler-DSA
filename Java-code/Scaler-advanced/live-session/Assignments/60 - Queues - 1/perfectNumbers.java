import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class perfectNumbers {
    // Using ArrayList
    public String solveArrayList(int A) {
        if(A == 1) {
            return "11";
        } else if (A == 2) {
            return "22";
        }
        ArrayList<StringBuilder> statV = new ArrayList<>();
        statV.add(new StringBuilder("11"));
        statV.add(new StringBuilder("22"));

        ArrayList<StringBuilder> al = new ArrayList<>();
        al.add(new StringBuilder("11"));
        al.add(new StringBuilder("22"));

        int i = 0;
        int ct = 2;
        while (i < A) {
            StringBuilder str = al.get(i);
            String sb1 = str.substring(0, str.length()/2);
            String sb2 = str.substring(str.length()/2, str.length());

            for(int j = 0; j < 2; j++) {
                if(ct == A) {
                    break;
                }
                StringBuilder insertV = new StringBuilder();
                insertV.append(sb1);
                insertV.append(statV.get(j));
                insertV.append(sb2);
                al.add(insertV);
                ct++;
            }
            i++;
        }

        int N = al.size();
        // System.out.println(al.get(N-1));
        return al.get(N-1).toString();
    }

    // using stacks
    public String solve(int A) {
        Queue<StringBuilder> que = new LinkedList<>();
        que.add(new StringBuilder("11"));
        que.add(new StringBuilder("22"));

        for (int i = 1; i < A; i++) {
            StringBuilder str = que.peek();
            String sb1 = str.substring(0, str.length() / 2);
            String sb2 = str.substring(str.length() / 2, str.length());
            
            StringBuilder insertV = new StringBuilder();
            insertV.append(sb1);
            insertV.append("11");
            insertV.append(sb2);

            StringBuilder insertV2 = new StringBuilder();
            insertV2.append(sb1);
            insertV2.append("22");
            insertV2.append(sb2);

            que.remove();
            que.add(insertV);
            que.add(insertV2);
        }
        // System.out.println(que.peek());
        return que.peek().toString();
    }

    public static void main(String[] args) {
        perfectNumbers pf = new perfectNumbers();
        int A = 4;
        pf.solve(A);
    }
}
