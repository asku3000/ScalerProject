package dynamicprogramming;

import java.util.Arrays;

/*
 * Q3. Ways to send the signal
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.



Problem Constraints

1 <= A <= 105



Input Format

The only argument given is integer A.



Output Format

Return the ans%(109+7).



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 3
Output 2:

 5


Example Explanation

Explanation 1:

 OFF OFF
 OFF ON 
 ON OFF
All lights off is also a valid signal which probably means 'bye'

Explanation 2:

 OFF OFF OFF
 OFF OFF ON
 OFF ON OFF 
 ON OFF OFF
 ON OFF ON
 
 */
public class WaysToSendSignal {

	public static void main(String[] args) {
		System.out.println(solve(3));
		System.out.println(solve(224));

	}

	static long mod = 1000000007;

	public static int solve(int A) {
		long[][] dp = new long[A + 1][2];
		for (long[] row : dp) {
			Arrays.fill(row, -1);
		}
		return (int) ((find(A, 0, dp) % mod + find(A, 1, dp) % mod) % mod);

	}

	private static long find(int A, int on, long[][] dp) {
		if (A == 0) {
			dp[A][on] = 0;
			return dp[A][on];
		}

		if (A == 1) {
			dp[A][on] = 1;
			return dp[A][on];
		}

		if (dp[A][on] != -1) {
			return dp[A][on];
		}

		if (on == 0) {
			dp[A][on] = (find(A - 1, 0, dp)%mod + find(A - 1, 1, dp)%mod)%mod;
		} else {
			dp[A][on] = find(A - 1, 0, dp)%mod;
		}

		return dp[A][on];
	}

}
