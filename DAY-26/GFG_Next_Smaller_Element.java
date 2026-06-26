import java.util.ArrayList;
import java.util.Stack;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        // Temporary array for result to map from back
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are greater than or equal to the current element
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            // If the stack is empty, there is no smaller element to the right
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                // The top of the stack is the next smaller element
                res[i] = st.peek();
            }
            
            // Push the current element onto the stack
            st.push(arr[i]);
        }
        
        // Convert the result array to an ArrayList
        for (int i = 0; i < n; i++) {
            ans.add(res[i]);
        }
        
        return ans;
    }
}
