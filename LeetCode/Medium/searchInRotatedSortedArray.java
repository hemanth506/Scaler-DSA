public class searchInRotatedSortedArray {
    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Using two iterations: pivot and then search the value with in two sorted arrays - O(2log^N) ~ O(log^N)
    public int searchUsingPivot(int[] nums, int target) {
        int N = nums.length;
        int leftEnd = nums[0];
        int rightEnd = nums[N - 1];
        if (leftEnd == rightEnd) {
            if (leftEnd == target) {
                return 0;
            }
            return -1;
        }

        int l = 0;
        int h = N - 1;
        if (leftEnd < rightEnd) {
            int notrotated = binarySearch(nums, target, l, h);
            if (notrotated != -1) {
                System.out.println("notrotated = " + notrotated);
                return notrotated;
            }
        } else {
            l = 1;
            h = N - 1;
            int peak = 0;
            while (l <= h) {
                int m = (l + h) / 2;
                System.out.println(m);
                if (nums[m] < nums[m - 1]) {
                    if (target == nums[m]) {
                        System.out.println("middle value = target");
                        return m;
                    }
                    peak = m;
                    break;
                }
                if (nums[m] > rightEnd) {
                    l = m + 1;
                } else if (nums[m] < leftEnd) {
                    h = m - 1;
                }
            }
            System.out.println("peak = " + peak);

            int resultFirst = binarySearch(nums, target, peak + 1, N - 1);
            if (resultFirst != -1) {
                System.out.println("condition 1");
                return resultFirst;
            }

            int resultSecond = binarySearch(nums, target, 0, peak - 1);
            if (resultSecond != -1) {
                System.out.println("condition 2");
                return resultSecond;
            }

        }

        System.out.println("Not present");
        return -1;
    }


    // Using one iteration: check whether it is in given range (l to m) or (m to h)
    // Refered this link https://www.youtube.com/watch?v=oTfPJKGEHcc
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                System.out.println("Present in " + m);
                return m;
            }

            // left sorted portion
            else if (nums[l] <= nums[m]) {
                System.out.println("left sorted " + target + " " + nums[l] + " " + nums[m]);
                if (target >= nums[l] && target <= nums[m]) {
                    System.out.println("cond - 1");
                    h = m - 1;
                } else {
                    System.out.println("cond - 2");
                    l = m + 1;
                }
            }
            // right sorted portion
            else {
                System.out.println("right sorted");
                if (target <= nums[h] && target >= nums[m]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        System.out.println("Not present");
        return -1;
    }




    public static void main(String[] args) {
        searchInRotatedSortedArray sr = new searchInRotatedSortedArray();
        // int[] nums = {5,6,7,8,9,10,0};
        // int target = 0;

        // int[] nums = {1,2,3,4,5};
        // int target = 4;

        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 2;
        sr.search(nums, target);
    }
}
