import java.util.*;

class maxHeap {

    ArrayList<Integer> heap;

    // Constructor
    public maxHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);

        int idx = heap.size() - 1;

        // Heapify Up
        while (idx > 0) {
            int parent = (idx - 1) / 2;

            if (heap.get(parent) < heap.get(idx)) {
                Collections.swap(heap, parent, idx);
                idx = parent;
            } else {
                break;
            }
        }
    }

    public void pop() {
        if (heap.size() == 0)
            return;

        int lastIdx = heap.size() - 1;

        Collections.swap(heap, 0, lastIdx);
        heap.remove(lastIdx);

        int idx = 0;
        int n = heap.size();

        // Heapify Down
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int largest = idx;

            if (left < n && heap.get(left) > heap.get(largest))
                largest = left;

            if (right < n && heap.get(right) > heap.get(largest))
                largest = right;

            if (largest != idx) {
                Collections.swap(heap, idx, largest);
                idx = largest;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (heap.size() == 0)
            return -1;

        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
}