public class singleNumber2 {
    public int singleNumber(int[] nums) {
        int N = nums.length;


        int value = 0;
        for(int i = 0; i < 32; i++) {
            int ct = 0;
            for(int j = 0; j < N; j++) {
                if((nums[j]>>i & 1) == 1) {
                    ct += 1;
                }
            }
            System.out.println(ct);
            if(ct % 3 != 0) {
                value += 1<<i;
            }
        }
        System.out.println(value);
        return value;        
    }
    public static void main(String[] args) {
        singleNumber2 s2 = new singleNumber2();
        int[] nums = {0,1,0,1,0,1,99};
        // int[] nums = {2,2,3,2};

        s2.singleNumber(nums);
    }
}
