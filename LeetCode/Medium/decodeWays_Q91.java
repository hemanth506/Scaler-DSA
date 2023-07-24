import java.util.HashMap;

public class decodeWays_Q91 {
    String str = "";
    int N;
    HashMap<Integer, Integer> dp;

    public int decodeCount(int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        char firstChar = str.charAt(i);
        if (firstChar == '0') {
            return 0;
        }
        System.out.println(firstChar);
        int sumCt = decodeCount(i + 1);

        if ((i + 1) < N) {
            int temp = Integer.parseInt(str.charAt(i + 1) + "");
            if (firstChar == '1' || (firstChar == '2' && temp < 7)) {
                sumCt += decodeCount(i + 2);
            }
        }
        dp.put(i, sumCt);
        return sumCt;
    }

    public int numDecodings(String s) {
        N = s.length();
        dp = new HashMap<>();
        dp.put(N, 1);
        System.out.println(dp);

        str = s;

        int totalCount = decodeCount(0);
        System.out.println(dp);
        System.out.println(totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        decodeWays_Q91 dc = new decodeWays_Q91();
        String s = "51423";
        // String s = "12";
        // String s = "226";
        // String s = "06";
        // String s = "0";
        // String s = "00";
        dc.numDecodings(s);
    }
}
