import java.util.Stack;

class StockSpanner {
    // Stack stores pairs of [price, span]
    private Stack<int[]> st;

    // Constructor initializes the stack
    public StockSpanner() {
        st = new Stack<>();
    }
    
    // Processes a single day's price and returns its span
    public int next(int price) {
        int span = 1;
        
        // Pop elements from the stack while the top price is less than or equal to current price
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1]; // Accumulate the spans of smaller/equal elements
        }
        
        // Push the current price and its accumulated span onto the stack
        st.push(new int[]{price, span});
        
        return span;
    }
}
