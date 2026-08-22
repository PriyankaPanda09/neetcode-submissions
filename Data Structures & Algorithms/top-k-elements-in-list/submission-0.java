// import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int c : nums) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Step 2: Min-heap of size k, ordered by frequency (index 1 of each pair)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            minHeap.offer(new int[]{number, frequency});

            if (minHeap.size() > k) {
                minHeap.poll(); // remove the weakest (smallest frequency)
            }
        }

        // Step 3: Extract the numbers from whatever remains in the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0]; // [0] = the number, we don't need the frequency anymore
        }

        return result;
    }
}