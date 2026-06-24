class myQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public myQueue(int n) {
        capacity = n;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Insert an element x at the rear of the queue
    public void enqueue(int x) {
        if (isFull()) {
            return;
        }
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    // Remove the element from the front of the queue
    public void dequeue() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % capacity;
        size--;
    }

    // Return front element if not empty, else "-1"
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // Return rear element if not empty, else "-1"
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        // rear points to the next available slot, so the actual last element is at (rear - 1 + capacity) % capacity
        return arr[(rear - 1 + capacity) % capacity];
    }
}
