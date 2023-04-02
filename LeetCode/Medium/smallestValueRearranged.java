import java.util.Arrays;
import java.util.Comparator;

public class smallestValueRearranged {
    private class smallestValue implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            String strA = o1 + "" + o2;
            String strB = o2 + "" + o1;

            if (Long.parseLong(strA) > Long.parseLong(strB)) {
                return 1;
            } else if (Long.parseLong(strA) < Long.parseLong(strB)) {
                return -1;
            }
            return 0;
        }
    }

    private class largestValue implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            String strA = o1 + "" + o2;
            String strB = o2 + "" + o1;

            if (Long.parseLong(strA) > Long.parseLong(strB)) {
                return -1;
            } else if (Long.parseLong(strA) < Long.parseLong(strB)) {
                return 1;
            }
            return 0;
        }
    }

    public long smallestNumber(long num) {
        String str = Long.toString(num);
        int N = str.length();
        int M = N;
        boolean isNeg = false;
        int k = 0;
        if (str.charAt(0) == '-') {
            isNeg = true;
            k = 1;
            N -= 1;
        }

        Character[] sb = new Character[N];
        int j = 0;
        for (; k < M; k++) {
            sb[j] = str.charAt(k);
            j++;
        }

        if (isNeg) {
            Arrays.sort(sb, new largestValue());
        } else {
            Arrays.sort(sb, new smallestValue());
        }

        if (sb[0] == '0') {
            int ind = 0;
            for (int i = 1; i < N; i++) {
                if (sb[i] != '0') {
                    ind = i;
                    break;
                }
            }
            swap(sb, 0, ind);
        }

        StringBuilder sbr = new StringBuilder();
        if (isNeg) {
            sbr.append('-');
        }

        for (int i = 0; i < N; i++) {
            sbr.append(sb[i]);
        }

        System.out.println(Long.parseLong(sbr.toString()));

        return Long.parseLong(sbr.toString());
    }

    private void swap(Character[] sb, int i, int ind) {
        Character ch = sb[i];
        sb[i] = sb[ind];
        sb[ind] = ch;
    }

    public static void main(String[] args) {
        smallestValueRearranged sm = new smallestValueRearranged();
        long num = 310;
        sm.smallestNumber(num);
    }
}
