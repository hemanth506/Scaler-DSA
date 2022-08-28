public class containersWithMostWater {
    public int maxArea(int[] height) {
        int N = height.length;

        int maxWater = Integer.MIN_VALUE;
        int l = 0;
        int r = N - 1;
        while (l < r) {
            System.out.println(height[l] + " " + height[r]);
            int minVal = Integer.min(height[l], height[r]);
            int len = r - l;
            int maxVal = minVal * len;
            maxWater = Integer.max(maxWater, maxVal);
            if (height[l] < height[r]) {
                l += 1;
            } else  {
                r -= 1;
            }
        }
        System.out.println(maxWater);
        return maxWater;
    }
    public static void main(String[] args) {
        containersWithMostWater mostWater = new containersWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        mostWater.maxArea(height);
    }
}
