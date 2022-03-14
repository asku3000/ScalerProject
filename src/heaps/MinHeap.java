package heaps;

import java.util.ArrayList;

public class MinHeap {

	ArrayList<Integer> heap = new ArrayList<>();

	int parent(int i) {
		return (i - 1) / 2;
	}

	int left(int i) {
		return (2 * i + 1);
	}

	int right(int i) {
		return (2 * i + 2);
	}

	void insert(int k) {
		heap.add(k);
		int i = heap.size() - 1;

		while (i != 0 && parent(i) >= 0 && heap.get(parent(i)) > heap.get(i)) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	int extractMin() throws Exception {
		if (heap.size() <= 0) {
			throw new Exception("heap dosn't exist");
		}
		if (heap.size() == 1) {
			int min = heap.get(0);
			heap.remove(0);
			return min;
		}

		swap(0, heap.size() - 1);
		int min = heap.get(heap.size() - 1);
		heap.remove(heap.size() - 1);
		minHeapify(0);
		return min;
	}

	private void minHeapify(int i) {
		while (2 * i + 1 < heap.size()) {
			int x;
			if (right(i) < heap.size()) {
				x = Math.min(heap.get(i), Math.min(heap.get(left(i)), heap.get(right(i))));
			}else {
				x= Math.min(heap.get(i), heap.get(left(i)));
			}
			if (x == heap.get(i)) {
				return;
			} else if (x == heap.get(left(i))) {
				swap(i, left(i));
				i = left(i);
			} else if (right(i) < heap.size()) {
				swap(i, right(i));
			}
		}
	}

	int getMin() throws Exception {
		if (heap.size() <= 0) {
			throw new Exception("heap dosn't exist");
		} else {
			return heap.get(0);
		}

	}

	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	public static void main(String[] args) throws Exception {
		MinHeap min = new MinHeap();
		min.insert(7);
		min.insert(9);
		min.insert(2);
		System.out.println(min.extractMin());
		System.out.println(min.getMin());
		min.insert(4);
		min.insert(6);
		System.out.println(min.extractMin());

	}

}
