package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sixlets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 2, 8 }), 2));
	}

	static List<Integer> a;

	public static int solve(List<Integer> A, int B) {
		int sum = 0;
		int i = 0;
		a = A;
		return find(i, sum, B);
	}

	static int find(int i, int sum, int b) {
		if (sum > 1000)
			return 0;
		if (0 == b)
			return 1;
		if (i >= a.size())
			return 0;
		return find(i + 1, sum + a.get(i), b - 1) + find(i + 1, sum, b);
	}

}
