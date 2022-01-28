package sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 1, 4, 10, 2, 1, 5 });
		quickSort(a, 0, a.size() - 1);
		for (Integer i : a) {
			System.out.print(i + ",");
		}
	}

	static void quickSort(List<Integer> A, int l, int r) {
		if (l < r) {
			int mid = rearrange(A, l, r);
			quickSort(A, l, mid-1);
			quickSort(A, mid + 1, r);
		}
	}

	private static int rearrange(List<Integer> A, int l, int r) {
		int p1 = l + 1, p2 = r;
		while (p1 <= p2) {
			if (A.get(p1) <= A.get(l)) {
				p1++;
			} else if (A.get(p2) > A.get(l)) {
				p2--;
			} else {
				swap(A, p1, p2);
				p1++;
				p2--;
			}
		}
		swap(A, l, p1 - 1);
		return p1 - 1;
	}

	private static void swap(List<Integer> A, int p1, int p2) {
		int temp = A.get(p1);
		A.set(p1, A.get(p2));
		A.set(p2, temp);
	}

}
