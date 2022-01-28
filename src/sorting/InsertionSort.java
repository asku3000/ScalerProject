package sorting;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] {45, 10, 15, 25, 50});
		insertionSort(a);
		for(Integer i: a) {
			System.out.print(i+",");
		}

	}

	static void insertionSort(List<Integer> A) {

		for (int i = 1; i < A.size(); i++) {
			int j = i - 1;
			while (j >= 0) {
				if (A.get(j) > A.get(j + 1)) {
					//swap
					int temp = A.get(j);
					A.set(j, A.get(j + 1));
					A.set(j + 1, temp);
					j--;
				}else {
					break;
				}
			}
		}
	}

}
