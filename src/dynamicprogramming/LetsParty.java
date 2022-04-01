package dynamicprogramming;

/*
 * Q1. Let's Party
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.



Problem Constraints

1 <= A <= 105



Input Format

Given only argument A of type Integer, number of people in Danceland.



Output Format

Return an integer denoting the number of ways people of Danceland can party.



Example Input

Input 1:

 A = 3
Input 2:

 A = 5


Example Output

Output 1:

 4
Output 2:

 26


Example Explanation

Explanation 1:

 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4.
 
Explanation 2:

 Number of ways they can party are: 26.


 */
public class LetsParty {

	public static void main(String[] args) {
		System.out.println(solve(16));
	}

	static long mod = 10003;

	public static int solve(int A) {
		int[] dp = new int[A + 1];

		return numberOfWays(A, dp);
	}

	private static int numberOfWays(int a, int[] dp) {
		if (a == 0) {
			return 1;
		}
		if (a == 1)
			return 1;

		if (a == 2)
			return 2;

		if (dp[a] != 0)
			return dp[a];

		// alone
		int alone = (int) (numberOfWays(a - 1, dp) % mod);
		//pair
		int pairing = (int) (((a - 1) % mod * numberOfWays(a - 2, dp) % mod) % mod);
		dp[a] = (int) ((alone % mod + pairing % mod) % mod);
		return dp[a];
	}

}
