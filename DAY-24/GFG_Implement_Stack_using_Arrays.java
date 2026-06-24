class myStack {
    private int[] arr;
    private int top;
    private int capacity;

    public myStack(int n) {
        // Initialize the array with given capacity and set top pointer to -1
        this.capacity = n;
        this.arr = new int[n];
        this.top = -1;
    }

    public boolean isEmpty() {
        // The stack is empty if top pointer is still at its initial value -1
        return top == -1;
    }

    public boolean isFull() {
        // The stack is full if top has reached the last valid index of the array
        return top == capacity - 1;
    }

    public void push(int x) {
        // Check if stack is full before pushing to avoid ArrayOutOfBoundsException
        if (!isFull()) {
            top++;
            arr[top] = x;
        }
    }

    public void pop() {
        // Check if stack is empty before popping
        if (!isEmpty()) {
            top--;
        }
    }

    public int peek() {
        // Return top element if not empty, otherwise return -1 as specified
        if (!isEmpty()) {
            return arr[top];
        }
        return -1;
    }
}
