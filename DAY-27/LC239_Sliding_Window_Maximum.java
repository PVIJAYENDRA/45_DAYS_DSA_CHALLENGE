import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Handle edge cases safely
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        
        // Deque will store array indices, keeping elements in decreasing order
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that fall out of the current sliding window bounds
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // 2. Remove smaller elements from the back as they are useless for maximums
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            
            // 3. Add the current element's index to the back of the queue
            dq.offerLast(i);
            
            // 4. Once the window reaches size k, record the maximum (always at the front)
            if (i >= k - 1) {
                result[resultIndex++] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }
}
