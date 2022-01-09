package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversePairsP {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 1, 3, 2, 3, 1 });
		solve(a);
		for (Integer i : a) {
			System.out.print(i + ",");
		}
		System.out.println("\n" + reversePairs);
		Collections.sort(null);
	}

	static int reversePairs;

	public static int solve(List<Integer> A) {
		reversePairs = 0;
		mergeSort(A, 0, A.size() - 1);
		return reversePairs;
	}

	static void mergeSort(List<Integer> A, int l, int r) {
		if (l < r) {
			int mid = l + ((r - l) / 2);
			mergeSort(A, l, mid);
			mergeSort(A, mid + 1, r);
			merge(A, l, mid, r);
		}
	}

	static void merge(List<Integer> A, int l, int mid, int r) {
		int i = l, j = mid + 1;
		ArrayList<Integer> temp = new ArrayList();

		// finding out the reverse pairs, which is done before actual merging sorted
		// arrays
		while (i <= mid && j <= r) {
			if (A.get(i) > (2l * A.get(j))) {
				reversePairs += mid - i + 1;
				j++;
			} else {
				i++;
			}
		}

		i = l;
		j = mid + 1;
		// merging actual arrays
		while (i <= mid && j <= r) {
			if (A.get(i) < A.get(j)) {
				temp.add(A.get(i));
				i++;
			} else {
				temp.add(A.get(j));
				j++;
			}
		}

		while (i <= mid) {
			temp.add(A.get(i));
			i++;
		}

		while (j <= r) {
			temp.add(A.get(j));
			j++;
		}

		for (int k = l; k <= r; k++) {
			A.set(k, temp.get(k - l));
		}
	}

}
