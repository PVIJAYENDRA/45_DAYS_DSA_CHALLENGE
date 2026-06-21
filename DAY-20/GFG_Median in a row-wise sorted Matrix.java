/*import java.util.Arrays;*/

class Solution {
    // Helper method to count elements less than or equal to mid using binary search
    private int countLessEqual(int[] row, int mid) {
        int low = 0;
        int high = row.length - 1;
        
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (row[m] <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return low;
    }

    public int median(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find the absolute minimum and maximum elements in the matrix
        int low = matrix[0][0];
        int high = matrix[0][cols - 1];

        for (int i = 1; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        // Target count of elements that must be <= median
        int targetCount = (rows * cols + 1) / 2;

        // Binary search over the value range
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count how many elements in the entire matrix are <= mid
            for (int i = 0; i < rows; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            // Adjust search boundaries
            if (count < targetCount) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Final low is the median
        return low;
    }
}
