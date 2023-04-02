import java.util.Arrays;
import java.util.Comparator;

public class largestNumberSort {
    class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare (String o1, String o2) {
            String strA = o1 + o2;
            String strB = o2 + o1;
            if(Long.parseLong(strA) > Long.parseLong(strB)) {
                return -1;
            } else if (Long.parseLong(strA) < Long.parseLong(strB)) {
                return 1;
            }
            return 0;
        }
    } 
    public String largestNumber(int[] nums) {
        int N = nums.length;
        String[] str = new String[N];
        Boolean equalsZero = true;
        for(int i = 0; i < N; i++) {
            str[i] = Integer.toString(nums[i]);
            if(nums[i] != 0) {
                equalsZero = false;
            }
        }

        if(equalsZero) {
            return "0";
        }

        System.out.println(Arrays.toString(str));
        Arrays.sort(str, new LargerNumberComparator());
        System.out.println(Arrays.toString(str));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        // int[] nums = { 3, 30, 34, 5, 9 };
        // int[] nums = { 0,0,0,0 };
        int[] nums = { 999999991,9 };

        // 

        largestNumberSort lns = new largestNumberSort();
        lns.largestNumber(nums);
    }
}