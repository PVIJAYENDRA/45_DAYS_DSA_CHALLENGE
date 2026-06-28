class MinStack {
    
    private Stack<Long> st;
    private long mini;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        long val = (long) value;
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
            return;
        }

        if (val >= mini) {
            st.push(val);
        } else {
            // Formula safely executes within 64-bit boundaries
            st.push(2 * val - mini);
            mini = val;
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long x = st.pop();

        // If the removed element is an encrypted flag
        if (x < mini) {
            mini = 2 * mini - x;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        long x = st.peek();

        // If x is less than mini, mini holds the actual unencrypted value
        if (x < mini) {
            return (int) mini;
        }

        return (int) x;
    }

    public int getMin() {
        return (int) mini;
    }
}
