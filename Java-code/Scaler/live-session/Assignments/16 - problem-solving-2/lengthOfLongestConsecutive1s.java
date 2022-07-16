public class lengthOfLongestConsecutive1s {

    int solve(String A) {
        char[] arr = A.toCharArray();
        int left, right, ct;
        int answer = 0;
        int N = arr.length;

        int total1s = 0;
        for (int p = 0; p < N; p++) {
            if(arr[p] == '1') {
                total1s += 1;
            }
        }

        if (total1s == N) {
            return N;
        }

        for (int i = 0; i < N; i++) {
            left = 0;
            right = 0;
            if(arr[i] == '0'){
                // System.out.println(arr[i]);

                for (int k = i - 1; k >= 0; k--) {
                    if (arr[k] == '1') {
                        left += 1;
                    } else {
                        break;
                    }
                }

                for (int j = i + 1; j < N; j++) {
                    if (arr[j] == '1') {
                        right += 1;
                    } else {
                        break;
                    }
                }

                // System.out.println("i => "+i+" left => " + left + " right => " + right);
                ct = left + right;
                // System.out.println(left+right);
                if (ct < total1s) {
                    ct += 1;
                } 
                if (ct > answer){
                    answer = ct;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {

        lengthOfLongestConsecutive1s soln = new lengthOfLongestConsecutive1s();
        String A;
        // A = "111011101";
        A = "11010110000000000";
        int length = soln.solve(A);
        System.out.println(length);
    }
}
