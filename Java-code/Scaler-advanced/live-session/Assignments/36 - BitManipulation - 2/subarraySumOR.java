import java.util.ArrayList;
import java.util.Arrays;

// Akshay Kumar
public class subarraySumOR {
    // contribution technique
    public int solve_N_2(ArrayList<Integer> A) {
        int N = A.size();
        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            long orV = A.get(i);
            for (int j = i; j < N; j++) {
                orV |= (long) A.get(j);
                // System.out.println(orV);
                totalSum += orV % 1000000007;
            }
        }
        int finalVal = (int) (totalSum % 1000000007);
        // System.out.println(finalVal);
        return finalVal;
    }

    public int solve(ArrayList<Integer> A) {
        long N = A.size();
        long modV = 1000000007;
        long totalSubarray = ((N * (N + 1)) / 2) % modV;
        // System.out.println("totalSubarray => " + totalSubarray);

        long totalSum = 0;
        for (int i = 0; i < 32; i++) {
            long ct = 0;
            long zeroSubarray = 0;
            for (int j = 0; j < N; j++) {
                // System.out.print((A.get(j)>>i & 1) + " ");
                if ((A.get(j) >> i & 1) == 0) {
                    ct += 1;
                } else {
                    zeroSubarray += ((ct * (ct + 1)) / 2) % modV;
                    ct = 0;
                }
            }
            zeroSubarray += ((ct * (ct + 1)) / 2) % modV;

            long validSubArray = (totalSubarray - zeroSubarray) % modV;
            totalSum += (validSubArray * ((1 << i) % modV)) % modV;
            // System.out.println((validSubArray * 1<<i) + " " + totalSum);

        }
        // System.out.println(totalSum);
        return (int) (totalSum % modV) < 0 ? (int) (totalSum % modV) : (int) ((totalSum % modV) + modV);
    }

    public static void main(String[] args) {
        subarraySumOR or = new subarraySumOR();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 8, 26, 13, 5, 21));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7,4,8));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(347148, 221001, 394957, 729925, 276769, 40726, 552988, 29952, 184491, 146773, 418965, 307,219145, 183037, 178111, 81123, 109199, 683929, 422034, 346291, 11434, 7327,340473, 316152, 364005, 359269, 170935, 105784, 224044, 22563, 48561, 165781,9329, 357681, 169473, 175031, 605611, 374501, 6607, 329965, 76068, 836137,103041, 486817, 195549, 107317, 34399, 56907, 37477, 189690, 36796, 376663,39721, 177563, 174179, 183646, 217729, 408031, 429122, 631665, 282941,526797, 262186, 306571, 63613, 57501, 70685, 226381, 1338, 9360, 130360, 20300, 400906, 87823, 180349, 108813, 18181, 119185, 1, 102611, 63591, 12889,311185, 383896, 8701, 76077, 75481, 386017, 153553, 304913, 383455, 105948,142885, 1, 12610, 137005, 119185, 16948, 66171, 123683));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(68545, 260786, 1, 29565, 29695, 24193, 114797, 240479, 46076, 403900, 36502, 133043, 249601, 383845, 783681, 517539, 71023, 64414, 260785, 87097, 158803, 869131, 359079, 43321, 84617, 5269, 3961, 74089, 302933, 632476, 9799, 62305, 161839, 190323, 119680, 483133, 403789, 53401, 1, 20608, 285969, 9790, 353266, 1171, 23371, 125489, 63870, 29825, 148627, 150970, 101005, 591057, 13876, 222667, 389993, 362701, 67555, 94498, 473685, 220024, 364414, 194635, 297136, 40353, 525031, 552817, 315371, 23815, 10737, 194619, 56616, 4506, 9697, 30241, 100829, 200719, 367173, 335665, 21313, 62670, 15751, 34019, 72997, 592389, 1273, 513541, 29206, 714919, 593629, 273225, 861736, 428679, 7251, 339879, 81537, 199717, 11449, 266311, 721840, 147187));


        System.out.println(or.solve_N_2(A));
        System.out.println("====================================");
        System.out.println(or.solve(A));


    }
}
