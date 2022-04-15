package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class CoinInfiniteWithoutSCConstraint {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] {1, 2, 3});
		int B = 4;
		System.out.println(coinchange2(A, B));

	}
	static long mod = 1000007;
	public static int coinchange2(List<Integer> A, int B) {
		int i = A.size(), j = B;
		long [][] dp = new long[i+1][j+1];
		for(long[] row: dp) {
			Arrays.fill(row, -1);
		}
		return (int) find(i, j, dp, A);
    }

	private static long find(int i, int j, long[][] dp, List<Integer> A) {
		
		if(i==0 && j==0) {
			dp[i][j] = 1;
			return dp[i][j];
		}
		
		if(i==0) {
			dp[i][j] = 0;
			return dp[i][j];
		}
		
		if(j==0) {
			dp[i][j] = 1;
			return dp[i][j];
		}
		
		if(dp[i][j]!= -1) {
			return dp[i][j];
		}
		
		if(j>=A.get(i-1)) {
			dp[i][j] = (find(i-1, j, dp, A)%mod + find(i, j-A.get(i-1), dp, A)%mod)%mod;
		}else {
			dp[i][j] = find(i-1, j, dp, A)%mod;
		}
		
		return dp[i][j]%mod;
	}

}
