import java.util.HashSet;

public class ctNoOfDistinctIntAfterRev {
    public String reverseInt (int num) {
        int div = 10;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int mod = num % 10;
            sb.append(mod);
            num = num / div;
        }
        System.out.println(sb);
        return sb.toString();
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            hs.add(nums[i]);
            int numLen = Integer.toString(nums[i]).length();
            if(numLen != 1) {
                String revStr = reverseInt(nums[i]);
                hs.add(Integer.parseInt(revStr));
            }
        }
        System.out.println(hs);
        System.out.println(hs.size());
        return hs.size();
    }
    public static void main(String[] args) {
        ctNoOfDistinctIntAfterRev ct = new ctNoOfDistinctIntAfterRev();
        int[] nums = {1,13,10,12,31};
        ct.countDistinctIntegers(nums);
    }
}
