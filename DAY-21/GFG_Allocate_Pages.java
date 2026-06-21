import java.util.*;

class Solution {
    
    // Helper function to count how many students are needed for a given max page limit
    public static int countStudents(int[] arr, int pages) {
        int n = arr.length;
        int students = 1;
        long pagesStudent = 0;
        
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr[i] <= pages) {
                // Assign book to current student
                pagesStudent += arr[i];
            } else {
                // Assign book to next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }

    // UPDATED FUNCTION SIGNATURE: GFG driver code expects exactly 2 parameters
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // Book allocation is impossible if students outnumber the books available
        if (k > n) {
            return -1;
        }

        int low = 0;
        int high = 0;
        
        // Find maximum element (low bound) and total sum (high bound)
        for (int val : arr) {
            low = Math.max(low, val);
            high += val;
        }

        // Apply binary search on the answer range
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);
            
            if (students > k) {
                low = mid + 1; // Need more pages per student to reduce student count
            } else {
                high = mid - 1; // Try to find a smaller maximum page configuration
            }
        }
        return low;
    }
}
