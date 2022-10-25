import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* First from down to up and then left to right.
 * 0 --> 1 --> 2 --> 3 --> 4 --> 5
 *   /\
 * 1 |
 *   /\
 * 2 |
 *   /\
 * 3 |
 */
public class sortMartixDiagonally1329Q {
    public int[][] diagonalSort(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] resultMat = new int[N][M];
        System.out.println(Arrays.deepToString(resultMat));
        
        // from down to up in column "0" diagonnly
        ArrayList<ArrayList<Integer>> sortedLists = new ArrayList<ArrayList<Integer>>();
        for(int i = N-1; i>=0; i--) {
            int k = 0;
            ArrayList<Integer> curList = new ArrayList<Integer>();
            for(int j = i; j < N; j++) {
                if(k < M) {
                    curList.add(mat[j][k]);
                    k++;
                } else {
                    break;
                }
            }
            sortedLists.add(curList);
        }
        // System.out.println(sortedLists);

        for(int i = 0; i < sortedLists.size(); i++) {
            Collections.sort(sortedLists.get(i));
        }
        System.out.println(sortedLists);

        for(int i = N-1; i>=0; i--) {
            // System.out.println("===" + i + "===");
            int index = N-i-1;
            int k = 0;
            for(int j = i; j < N; j++) {
                // System.out.println(j + " " + k);
                if(k < M) {
                    resultMat[j][k] = sortedLists.get(index).get(k);
                    k++;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.deepToString(resultMat));

        System.out.println("============================");

        // from left to right in row "1" diagonnly
        ArrayList<ArrayList<Integer>> sortedLists2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 1; i < M; i++) {
            // System.out.println(i);
            int k = 0;
            ArrayList<Integer> curList = new ArrayList<Integer>();
            for(int j = i; j < M; j++) {
                if(k < N) {
                    System.out.println(k + " " + j);
                    curList.add(mat[k][j]);
                    k++;
                } else {
                    break;
                }
            }
            sortedLists2.add(curList);
            System.out.println("====");
        }

        for(int i = 0; i < sortedLists2.size(); i++) {
            Collections.sort(sortedLists2.get(i));
        }
        System.out.println(sortedLists2);

        for(int i = 1; i < M; i++) {
            int index = i - 1;
            int k = 0;
            for(int j = i; j < M; j++) {
                if(k < N) {
                    System.out.println(k + " " + j);
                    resultMat[k][j] = sortedLists2.get(index).get(k);
                    k++;
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(resultMat));
        System.out.println("============================");
        return resultMat;
    }
    
    public static void main(String[] args) {
        sortMartixDiagonally1329Q st = new sortMartixDiagonally1329Q();
        int[][] mat = {{3,3,1,1,3},{2,2,1,2,2},{1,1,1,2,1}};
        // int[][] mat = {{11,25,66,1,69,7}, {23,55,17,45,15,52}, {75,31,36,44,58,8}, {22,27,33,25,68,4}, {84,28,14,11,5,50}};

        // getting error for this input
        // int[][] mat = {{3,9},{2,4},{1,2},{9,8},{7,3}};

        st.diagonalSort(mat);
    }
}

/*
 * [[58],[99],[1],[6],[73],[9],[60],[88],[64],[60],[39],[29],[46],[20],[78],[95],[2],[35],[20],[53],[60],[15],[94],[78],[26],[89],[87],[93],[70],[31],[94],[58],[90],[48],[60],[6],[68],[62],[32],[36],[73],[49],[45],[31],[23],[3],[73],[70],[71],[18],[14],[49],[84],[72],[59],[91],[17],[46],[93],[31],[31],[71],[52],[83],[8],[95],[49],[57],[52],[65],[83],[98],[46],[55],[44],[100],[45],[7],[59],[38],[82],[62],[25],[55],[64],[56],[89],[2],[10],[57],[26],[19],[27],[80],[12],[32],[62],[91],[68],[92]]
 */

/*
 * [[3,9],
 * [2,4],
 * [1,2],
 * [9,8],
 * [7,3]]
 */



 /*
  * [[1, 0, 0, 0, 0],
     [1, 2, 0, 0, 0],
     [1, 2, 3, 0, 0]
    ]
    [[1, 1, 1, 1, 3],
     [1, 2, 2, 1, 2],
     [1, 2, 3, 3, 2]]
  */