package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer i: wave(Arrays.asList(new Integer[] {1,2,3,4}))) {
			System.out.print(i+",");
		}
	}

	public static List<Integer> wave(List<Integer> A) {
		Collections.sort(A);
		for (int i = 1; i < A.size(); i = i + 2) {
			int temp = A.get(i-1);
			A.set(i-1, A.get(i));
			A.set(i, temp);
		}
		return A;
	}

}
