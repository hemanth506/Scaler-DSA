import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix_Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        int M = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maxHeap.size() == k) {
                    if(maxHeap.peek() > matrix[i][j]) {
                        maxHeap.poll();
                        maxHeap.add(matrix[i][j]);
                    }
                } else {
                    maxHeap.add(matrix[i][j]);
                }
                System.out.println(maxHeap);
            }
        }
        System.out.println(maxHeap.peek());
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        kthSmallestElementInSortedMatrix_Q378 kth = new kthSmallestElementInSortedMatrix_Q378();
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        int k = 8;
        kth.kthSmallest(matrix, k);
    }
}
