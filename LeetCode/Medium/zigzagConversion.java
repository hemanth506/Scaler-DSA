import java.util.ArrayList;
import java.util.HashMap;

public class zigzagConversion {
    public String convert(String s, int numRows) {
        int N = s.length();
        if(N == 1 || numRows == 1 || numRows >= N) {
            return s;
        }

        HashMap<Integer, ArrayList<Character>> hm = new HashMap<>();
        int curRow = 0;
        boolean direction = true;
        for(int i = 0; i < N; i++) {
            // System.out.println(curRow);
            if(curRow == numRows) {
                direction = false;
            }

            if (curRow == 1) {
                direction = true;
            }

            if(direction) {
                curRow++;
            } else {
                curRow--;
            }

            if(hm.containsKey(curRow)) {
                ArrayList<Character> sr = hm.get(curRow);
                sr.add(s.charAt(i));
            } else {
                ArrayList<Character> nn = new ArrayList<>();
                nn.add(s.charAt(i));
                hm.put(curRow, nn);
            }
        }
        System.out.println(hm);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numRows; i++) {
            for(int j = 0; j < hm.get(i).size(); j++) {
                sb.append(hm.get(i).get(j));
            }
        }
        System.out.println(sb);
        return sb.toString();
    } 

    public static void main(String[] args) {
        zigzagConversion zg = new zigzagConversion();
        // String s = "PAYPALISHIRING";
        // int numRows = 4;

        // String s = "AB";
        // int numRows = 1;

        String s = "AB";
        int numRows = 1;
        zg.convert(s, numRows);
    }
}
