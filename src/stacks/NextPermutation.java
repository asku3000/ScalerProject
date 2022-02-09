package stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : nextPermutation(Arrays.asList(new Integer[] { 1, 2, 3 }))) {
			System.out.print(i + ",");
		}
	}

	public static List<Integer> nextPermutation(List<Integer> A) {
		// finding just decreasing sequence
		int decreasingElement = -1;
		for (int i = A.size() - 1; i > 0; i--) {
			if (A.get(i) >= A.get(i - 1)) {
				decreasingElement = i - 1;
				break;
			}
		}

		if (decreasingElement == -1) {
			Collections.reverse(A);
			return A;
		}

		// finding just greater than decreaing decreasingElement
		int justSmaller = A.size() - 1;
		while (A.get(justSmaller) <= A.get(decreasingElement)) {
			justSmaller--;
		}
		swap(A, decreasingElement, justSmaller);
		reverse(A, decreasingElement + 1);
		return A;
	}

	private static void reverse(List<Integer> A, int start) {
		int i = start, j = A.size() - 1;
		while (i < j) {
			swap(A, i, j);
			i++;
			j--;
		}
	}

	private static void swap(List<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
