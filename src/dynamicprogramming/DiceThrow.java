package dynamicprogramming;

/*
 * Q1. Dice throw
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given sum A, number of ways you can get that sum with dice roll[1-6].

As the number of ways can be large return its modulo by 1e9 + 7.



Problem Constraints

1 <= A <= 10 2


Input Format

The first argument is the integer A.


Output Format

Return an integer .


Example Input

Input 1:
A = 3
Input 2:

A = 4


Example Output

Output 1:
4
Output 2:

8


Example Explanation

Explanation 1:

The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].




Explanation 2:

The eight possible ways to obrain 8 are: [1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 3], [3, 1], [2, 2], [4].


 */
public class DiceThrow {

	public static void main(String[] args) {
		System.out.println(solve(4));
	}

	static long mod = 1000000007;

	public static int solve(int A) {
		int sum = 0;
		int[] dp = new int[A + 1];
		return numberOfWays(A, sum, dp);
	}

	private static int numberOfWays(int A, int sum, int[] dp) {
		if (sum > A) {
			return 0;
		}

		if (sum == A) {
			return 1;
		}

		if (dp[sum] != 0) {
			return dp[sum];
		}
		long ans = 0;
		for (int i = 1; i <= 6; i++) {
			ans = (ans % mod + numberOfWays(A, sum + i, dp) % mod) % mod;
		}

		dp[sum] = (int) ans;
		return dp[sum];
	}
}
