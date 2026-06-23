import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    // maxHeap stores the smaller half of the numbers (inverted order)
    private Queue<Integer> maxHeap;
    // minHeap stores the larger half of the numbers (natural order)
    private Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add element onto the correct heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Step 2: Balance the heaps so maxHeap size is >= minHeap size
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // Total count is odd: maxHeap holds the exact middle element
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        // Total count is even: average the roots of both heaps
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
