import java.util.*;

class Solution {
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        
        // Queue stores array elements as {value, row_index, col_index}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        ArrayList<Integer> result = new ArrayList<>();
        
        // Push the first element of each row into the min-heap
        for (int i = 0; i < mat.length; i++) {
            if (mat[i] != null && mat[i].length > 0) {
                minHeap.add(new int[]{mat[i][0], i, 0});
            }
        }
        
        // Extract the minimum element and move to the next item in that row
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int val = current[0];
            int r = current[1];
            int c = current[2];
            
            result.add(val);
            
            // If the row has more elements, push the next one into the heap
            if (c + 1 < mat[r].length) {
                minHeap.add(new int[]{mat[r][c + 1], r, c + 1});
            }
        }
        
        return result;
    }
}
