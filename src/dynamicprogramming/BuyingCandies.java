package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class BuyingCandies {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 1, 2, 3 });
		List<Integer> B = Arrays.asList(new Integer[] { 2, 2, 10 });
		List<Integer> C = Arrays.asList(new Integer[] { 2, 3, 9 });
		int D = 8;
		System.out.println(solve(A, B, C, D));
	}

	public static int solve(List<Integer> A, List<Integer> B, List<Integer> C, int D) {
		// number of item packet
		int i = A.size();

		// allowed nibbles
		int j = D;
		int[][] dp = new int[i + 1][j + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return find(i, j, dp, A, B, C);

	}

	private static int find(int i, int j, int[][] dp, List<Integer> a, List<Integer> b, List<Integer> c) {
		
		if(i==0 || j==0) {
			dp[i][j] = 0;
			return dp[i][j];
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		if(j>= c.get(i-1)) {
			dp[i][j] = Math.max(find(i-1, j, dp, a, b, c), a.get(i-1)*b.get(i-1) + find(i, j - c.get(i-1), dp, a, b, c));
		}else {
			dp[i][j] = find(i-1, j, dp, a, b, c);
		}
		
		return dp[i][j];
	}
}
