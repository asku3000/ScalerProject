package heaps;

import java.util.PriorityQueue;

public class HeapPriorityQueue {
	
	PriorityQueue<Integer> minHeapQ = new PriorityQueue<Integer>();
	
	void insert(int k) {
		minHeapQ.add(k);
	}
	
	int extractMin() {
		return minHeapQ.poll();
	}
	
	int getMin() {
		return minHeapQ.peek();
	}
	
	public static void main(String[] args) {
		HeapPriorityQueue minHeap = new HeapPriorityQueue();
		minHeap.insert(7);
		minHeap.insert(9);
		minHeap.insert(2);
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.getMin());
		minHeap.insert(4);
		minHeap.insert(6);
		System.out.println(minHeap.getMin());
		
		
		
	}

}
