import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // This main method is NOT part of the LeetCode submission —
    // it's just here so YOU can run this file yourself and see output.
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
        System.out.println("Before: " + Arrays.toString(nums));

        Solution sol = new Solution();
        sol.sortColors(nums);

        System.out.println("After:  " + Arrays.toString(nums));
    }
}