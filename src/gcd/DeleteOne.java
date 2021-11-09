package gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeleteOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 3, 9, 6, 8, 3 })));

	}

	public static int solve(List<Integer> A) {
		ArrayList<Integer> prefixGcd = new ArrayList();
		prefixGcd.add(0);
		prefixGcd.add(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			prefixGcd.add(gcd(prefixGcd.get(i), A.get(i)));
		}

		Collections.reverse(A);
		ArrayList<Integer> suffixGcd = new ArrayList();
		suffixGcd.add(0);
		suffixGcd.add(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			suffixGcd.add(gcd(suffixGcd.get(i), A.get(i)));
		}

		Collections.reverse(A);
		Collections.reverse(suffixGcd);

		int ans = 0;
		for (int i = 0; i < A.size(); i++) {
			ans = Math.max(ans, gcd(prefixGcd.get(i), suffixGcd.get(i + 1)));
		}
		return ans;
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
