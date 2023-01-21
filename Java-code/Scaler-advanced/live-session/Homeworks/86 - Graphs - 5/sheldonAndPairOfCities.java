import java.util.ArrayList;
import java.util.Arrays;

public class sheldonAndPairOfCities {
    public ArrayList<Integer> solve(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {
        int N = A + 1;
        int[][] mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < B; k++) {
            int src = D.get(k);
            int dest = E.get(k);
            int dist = F.get(k);
            if(src == dest) {
                continue;
            }
            if (mat[src][dest] > dist) {
                mat[src][dest] = dist;
            }

            if (mat[dest][src] > dist) {
                mat[dest][src] = dist;
            }
            
        }
        // System.out.println(mat[2][1]);
        // System.out.println(Arrays.deepToString(mat));

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    int jk = mat[j][k];
                    int ji = mat[j][i];
                    int ik = mat[i][k];
                    if (k == i || k == j || ji == Integer.MAX_VALUE || ik == Integer.MAX_VALUE) {
                        continue;
                    }
                    int jik = ji + ik;
                    if (jk > jik) {
                        mat[j][k] = jik;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(mat));

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < C; i++) {
            if(mat[G.get(i)][H.get(i)] == Integer.MAX_VALUE) {
                arr.add(-1);
            } else if (G.get(i) == H.get(i)) {
                arr.add(0);
            } else {
                arr.add(mat[G.get(i)][H.get(i)]);
            }
        }
        System.out.println(arr);
        return arr;
    }

    public static void main(String[] args) {
        sheldonAndPairOfCities sh = new sheldonAndPairOfCities();
        // int A = 4;
        // int B = 6;
        // int C = 2;
        // ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2, 4, 3));
        // ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 4, 1, 1));
        // ArrayList<Integer> F = new ArrayList<Integer>(Arrays.asList(4, 1, 1, 1, 1, 1));
        // ArrayList<Integer> G = new ArrayList<Integer>(Arrays.asList(1, 1));
        // ArrayList<Integer> H = new ArrayList<Integer>(Arrays.asList(2, 3));


        int A = 15;
        int B = 18;
        int C = 29;
        ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(11,   2,    2,  6,    2,    8,    9,    3,    14,   15,   4,    14,   8,    7,    8,    6,    2,    12));
        ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2,    1,    1,  2,    1,    1,    7,    3,    2,    13,   2,    1,    6,    1,    7,    1,    2,    10));
        ArrayList<Integer> F = new ArrayList<Integer>(Arrays.asList(8337, 6651, 29, 7765, 3428, 5213, 6431, 2864, 3137, 4024, 8169, 5013, 7375, 3786, 4326, 6415, 8982, 6864));
        ArrayList<Integer> G = new ArrayList<Integer>(Arrays.asList(6, 2, 1, 15, 12, 2, 14, 10, 13, 15, 15, 4, 8, 7, 9, 4, 15, 13, 12, 5, 2, 10, 1, 11, 14, 7, 3, 13, 12));
        ArrayList<Integer> H = new ArrayList<Integer>(Arrays.asList(5, 2, 15, 13, 6, 2, 8, 6, 3, 13, 15, 3, 1, 1, 4, 4, 5, 8, 1, 3, 1, 10, 15, 9, 2, 1, 1, 10, 2));

        sh.solve(A, B, C, D, E, F, G, H);
    }
}

// -1 0 -1 4024 -1 0 8379 -1 -1 4024 0 -1 5213 3786 18415 0 -1 -1 -1 -1 29 0 -1 18583 3137 3786 -1 -1 -1 
// -1 8982 -1 4024 -1 8982 10226 -1 -1 4024 0 -1 5213 3786 21814 0 -1 -1 -1 -1 3428 0 -1 21982 3137 3786 -1 -1 -1 

