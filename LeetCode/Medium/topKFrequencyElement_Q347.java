import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class customComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if(o1.getValue() > o2.getValue()) {
            return -1;
        } else if (o1.getValue() < o2.getValue()) {
            return 1;
        }
        return 0;
    }
}

public class topKFrequencyElement_Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new customComparator());
        for (int i = 0; i < N; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        maxHeap.addAll(hm.entrySet());

        System.out.println(maxHeap);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> nn = maxHeap.poll();
            result[i] = nn.getKey();
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        topKFrequencyElement_Q347 topK = new topKFrequencyElement_Q347();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        topK.topKFrequent(nums, k);
    }
}
