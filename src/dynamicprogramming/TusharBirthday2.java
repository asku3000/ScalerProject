package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class TusharBirthday2 {

	public static void main(String[] args) {
		final List<Integer> A = Arrays.asList(new Integer[] { 2, 4, 6 });
		final List<Integer> B = Arrays.asList(new Integer[] { 2, 1, 3 });
		final List<Integer> C = Arrays.asList(new Integer[] { 2, 5, 3 });
		System.out.println(solve(A, B, C));
	}

	public static int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int maxCap = A.get(0);
		for (int k = 0; k < A.size(); k++) {
			maxCap = Math.max(maxCap, A.get(k));
		}
		int dp[][] = new int[B.size() + 1][maxCap + 1];
		for (int[] row : dp) {
			Arrays.fill(row, 0);
		}
		
		for(int i=1; i<B.size()+1; i++ ) {
			
			for(int j=1; j<=maxCap; j++) {
				if(j>= B.get(i-1)) {
					dp[i][j] = Math.max(dp[i-1][j], C.get(i-1)+dp[i][j-B.get(i-1)]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int ans = 0;
		for (int k = 0; k < A.size(); k++) {
			int innerans = Integer.MAX_VALUE;
			for (int l = 1; l <= B.size(); l++) {
				if (dp[l][A.get(k)] != -1)
					innerans = Math.min(innerans, dp[l][A.get(k)]);
			}
			ans += innerans;

		}

		return ans;
	}


}
