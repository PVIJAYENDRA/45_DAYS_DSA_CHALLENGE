import java.util.*;

class Solution {
   
    
    public ArrayList<Integer> topKSumPairs(int[] nums1, int[] nums2, int k) {
        // Sort both arrays in descending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;

        // Max heap to store sums and their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Set to keep track of visited index pairs
        Set<String> visited = new HashSet<>();

        // Push initial max sum combination
        maxHeap.offer(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        // Result list
        ArrayList<Integer> result = new ArrayList<>();

        // Extract top k combinations
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            result.add(sum);

            // Check for new combination (i - 1, j)
            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxHeap.offer(new int[]{nums1[i - 1] + nums2[j], i - 1, j});
                    visited.add(key1);
                }
            }

            // Check for new combination (i, j - 1)
            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                if (!visited.contains(key2)) {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}