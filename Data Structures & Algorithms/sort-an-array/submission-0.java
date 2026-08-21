class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Base case: an array of 0 or 1 elements is already sorted
        if (n <= 1) {
            return nums;
        }

        // Step 1: find the midpoint
        int mid = n / 2;

        // Step 2: copy the left half and right half into new arrays
        // Arrays.copyOfRange is a built-in helper for "slicing" an array —
        // it is NOT a sorting function, so it's allowed by the problem's rule.
        int[] left = java.util.Arrays.copyOfRange(nums, 0, mid);
        int[] right = java.util.Arrays.copyOfRange(nums, mid, n);

        // Step 3: recursively sort each half
        // (this is where the function calls itself on smaller pieces)
        left = sortArray(left);
        right = sortArray(right);

        // Step 4: merge the two sorted halves back together
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Compare fronts of both arrays, take the smaller one each time
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // One of the two arrays might still have leftover elements — copy them over
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }
}