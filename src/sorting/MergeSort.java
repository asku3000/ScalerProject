package sorting;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 5, 3, 5, 6, 8, 4, 2, 6, 21, 9, 0 });
		int l = 0, r = A.size() - 1;
		mergeSort(A, l, r);
		for (Integer i : A) {
			System.out.println(i + ",");
		}

	}

	static void mergeSort(List<Integer> a, int l, int r) {
		if (l < r) {
			int mid = l + ((r - l) / 2);
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private static void merge(List<Integer> a, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int temp[] = new int[r - l + 1];
		int i = l;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= r) {
			if (a.get(i) < a.get(j)) {
				temp[k] = a.get(i);
				i++;
			} else {
				temp[k] = a.get(j);
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = a.get(i);
			i++;
			k++;
		}

		while (j <= r) {
			temp[k] = a.get(j);
			j++;
			k++;
		}

		for (i = l; i <= r; i++) {
			a.set(i, temp[i - l]);
		}
	}

}
