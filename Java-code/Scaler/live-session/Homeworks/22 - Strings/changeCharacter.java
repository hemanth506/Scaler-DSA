import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class changeCharacter {
    public int solve(String A, int B) {
        char[] Achar = A.toCharArray(); 
        int N = Achar.length;
        Arrays.sort(Achar);
        System.out.println(Achar);

        ArrayList<Integer> eltCount = new ArrayList<Integer>();
        int s = 0;
        int count = 0;
        for (int i = 1; i < N; i++) {
            if(Achar[i] != Achar[i-1]) {
                count = i - s;
                eltCount.add(count);
                System.out.println(i + " " + count);
                s = i;

            }
        }
        eltCount.add(N-s);
        System.out.println(N +" " + (N-s));
        System.out.println(eltCount);
        Collections.sort(eltCount);
        System.out.println(eltCount);

        int Nelt = eltCount.size();
        int eltCt = 0;
        for (int i = 0; i < Nelt; i++) {
            B = B - eltCount.get(i);
            if (B < 0) {
                System.out.println(B);
                break;
            } else {
                eltCt += 1;
                System.out.println("Eliminated => " + eltCt);
            }
        }
        System.out.println(Nelt - eltCt);
        return (Nelt - eltCt);
    }
    public static void main(String[] args) {
        changeCharacter cc = new changeCharacter();
        // String A = "abcabbccddeee";
        // String A = "abcabbccdd";
        // int B = 3; 
        String A = "umeaylnlfd";
        int B = 1;
        cc.solve(A, B);
    }
}
