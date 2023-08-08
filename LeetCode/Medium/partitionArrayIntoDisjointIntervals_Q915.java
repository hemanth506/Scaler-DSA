import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class partitionArrayIntoDisjointIntervals_Q915 {

    // Wrong approach - Heap
    public int partitionDisjoint_Heap(int[] nums) {
        int N = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(nums[0]);
        minHeap.add(nums[N - 1]);

        int i = 1;
        int j = N - 2;
        while (i <= j) {
            System.out.println("start = " + i + " " + j);
            if (maxHeap.peek() <= nums[j]) {
                System.out.println("insert in min");
                minHeap.add(nums[j]);
                j--;
            } else if (minHeap.peek() > nums[i]) {
                System.out.println("insert in max");
                maxHeap.add(nums[i]);
                i++;
            } else {
                minHeap.poll();
                maxHeap.add(nums[i]);
                j++;
                i++;
                System.out.println("=========");
            }
            System.out.println("End = " + i + " " + j + " [" + maxHeap + "] " + " [" + minHeap + "]");
        }

        if (maxHeap.peek() > minHeap.peek()) {
            maxHeap.add(minHeap.poll());
        }
        System.out.println(maxHeap.size());
        System.out.println(maxHeap);
        System.out.println(minHeap);
        return maxHeap.size();
    }

    // Use prefix max and suffix min Array
    public int partitionDisjoint(int[] nums) {
        int N = nums.length;
        int[] prefixMax = new int[N];
        int[] suffixMin = new int[N];

        prefixMax[0] = nums[0];
        suffixMin[N - 1] = nums[N - 1];
        for (int i = 1; i < N; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            suffixMin[N - i - 1] = Math.min(suffixMin[N - i], nums[N - i - 1]);
        }

        System.out.println(Arrays.toString(prefixMax));
        System.out.println(Arrays.toString(suffixMin));

        for (int i = 0; i < N - 1; i++) {
            if (prefixMax[i] <= suffixMin[i + 1]) {
                System.out.println(i + 1);
                return i + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        partitionArrayIntoDisjointIntervals_Q915 pt = new partitionArrayIntoDisjointIntervals_Q915();
        int[] nums = { 5, 0, 3, 8, 6 };
        // int[] nums = {1,1,1,0,6,12};
        // int[] nums = { 1, 1 };
        // int[] nums = { 26, 51, 40, 58, 42, 76, 30, 48, 79, 91 };
        // int[] nums = { 32, 57, 24, 19, 0, 24, 49, 67, 87, 87 };
        // int[] nums = {30,57,9,79,49,67,11,4,42,43,7,21,78,70,46,91,94,89,95,82};
        // int[] nums = { 3, 1, 8, 4, 9, 7, 12, 0, 0, 12, 6, 12, 6, 19, 24, 90, 87, 54,
        // 92, 60, 31, 59, 75, 90, 20, 38, 52,
        // 51, 74, 70, 86, 20, 27, 91, 55, 47, 54, 86, 15, 16, 74, 32, 68, 27, 19, 54,
        // 13, 22, 34, 74, 76, 50, 74,
        // 97, 87, 42, 58, 95, 17, 93, 39, 33, 22, 87, 96, 90, 71, 22, 48, 46, 37, 18,
        // 17, 65, 54, 82, 54, 29, 27,
        // 68, 53, 89, 23, 12, 90, 98, 42, 87, 91, 23, 72, 35, 14, 58, 62, 79, 30, 67,
        // 44, 48 };
        pt.partitionDisjoint(nums);
    }
}
