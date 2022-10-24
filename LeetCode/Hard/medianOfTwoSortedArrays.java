import java.util.ArrayList;

public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int tot = n + m;
        int medianIndex = (tot / 2) + 1;
        boolean isEven = tot % 2 == 0;

        int p1 = 0;
        int p2 = 0;
        int medInd = 1;
        ArrayList<Integer> medianValues = new ArrayList<Integer>();
        boolean iterationStopped = false;
        while (p1 < n && p2 < m) {
            // System.out.println(medInd + "==========" + p1 + " " + p2);
            if (nums1[p1] == nums2[p2]) {
                // check for array1 when both the values are equal
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums1[p1]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p1 += 1;
                medInd += 1;

                // check for array2 when both the values are equal
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums2[p2]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p2 += 1;
                medInd += 1;
            } else if (nums1[p1] < nums2[p2]) {
                // check for array1 when array1Val < array2Val
                // System.out.println("p1++ " + nums1[p1] + " " + nums2[p2] + " == " + nums1[p1]);
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums1[p1]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p1 += 1;
                medInd += 1;
            } else if (nums1[p1] > nums2[p2]) {
                // check for array2 when array1Val > array2Val
                // System.out.println("p2++ " + nums1[p1] + " " + nums2[p2] + " == " + nums2[p2]);
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums2[p2]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p2 += 1;
                medInd += 1;
            }
        }

        if (!iterationStopped) {
            // System.out.println("inside iteration not Stopped");
            // check for array1 when array2 is empty
            while (p1 < n) {
                // System.out.println("inside = p1");
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums1[p1]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p1 += 1;
                medInd += 1;
            }

            // check for array2 when array1 is empty
            while (p2 < m) {
                // System.out.println("inside = p2");
                if (medInd == medianIndex || medInd == medianIndex - 1) {
                    medianValues.add(nums2[p2]);
                }
                if (medInd == medianIndex) {
                    iterationStopped = true;
                    break;
                }
                p2 += 1;
                medInd += 1;
            }
        }

        // System.out.println(medianValues);
        int medSize = medianValues.size();
        double median = 0;
        double lastV = medianValues.get(medSize - 1);
        double lastprevV = 0;
        if (tot > 1) {
            lastprevV = medianValues.get(medSize - 2);
        }

        if (isEven) {
            // System.out.println("even");
            median = (lastV + lastprevV) / 2;
        } else {
            // System.out.println("odd");
            median = lastV;
        }
        // System.out.println("median = " + median);
        return median;
    }

    public static void main(String[] args) {
        medianOfTwoSortedArrays md = new medianOfTwoSortedArrays();
        // int[] nums1 = { 3, 6, 7, 8, 10, 12 };
        // int[] nums2 = { 1, 5, 7, 9, 11, 12, 13 };

        // int[] nums1 = { 1,2 };
        // int[] nums2 = { 3,4 };

        // int[] nums1 = { 1 };
        // int[] nums2 = { };
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
        int[] nums2 = { 0, 6 };

        md.findMedianSortedArrays(nums1, nums2);
    }
}
