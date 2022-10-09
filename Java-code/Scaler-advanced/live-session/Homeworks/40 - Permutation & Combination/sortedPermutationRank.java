
public class sortedPermutationRank {
    public int findRank(String A) {
        int N = A.length();
        int mod = 1000003;
        int rank = 0;
        for(int i = 0; i < N; i++) {
            System.out.println("====" + i + "====");
            char curChar = A.charAt(i);
            int ctChar = 0;
            for(int j = i+1; j < N; j++) {
                if(A.charAt(j) < curChar) {
                    System.out.println(A.charAt(j));
                    ctChar++;
                }
            }

            // instead of this find factorial and store it in hashmap.
            if(ctChar != 0) {
                System.out.println(N-i);
                int sumV = 1;
                for(int k = 1; k <= (N-i-1); k++) {
                    sumV = (sumV%mod * k%mod)%mod;
                }
                System.out.println("sumV " + sumV);
                rank += (sumV%mod * ctChar%mod)%mod;
            }
            System.out.println("ctChar " + ctChar);
            System.out.println("=======================");
        }
        rank+=1;
        System.out.println(rank);
        return rank%mod;
    }
    public static void main(String[] args) {
        sortedPermutationRank spr = new sortedPermutationRank();
        // String A = "fgeih";
        // String A = "acb";
        // String A = "a";
        String A = "VIEW";

        spr.findRank(A);
    }
}
