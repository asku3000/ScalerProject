package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. Tushar's Birthday Party
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved..
Get help from TA.
Problem Description
As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints
|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format
First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost



Output Format
Return a single integer, the answer to the problem



Example Input
Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]


Example Output
Output 1:

12
Output 2:

4


Example Explanation
Explanation 1:

First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:

Only way is to take 2 dishes of cost 2, hence 4.

 */
public class TusharBirthday {

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
		int i = B.size(), j = maxCap;
		long dp[][] = new long[i + 1][j + 1];
		for (long[] row : dp) {
			Arrays.fill(row, -1);
		}
		// find(i, j, dp, B, C);

		long ans = 0;
		for (int k = 0; k < A.size(); k++) {

			ans += find(i, A.get(k), dp, B, C);

		}

		return (int) ans;
	}

	private static long find(int i, int j, long[][] dp, List<Integer> b, List<Integer> c) {
		if (j == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (i == 0) {
			dp[i][j] = 1000000000;
			return dp[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (j >= b.get(i - 1)) {
			dp[i][j] = Math.min(find(i - 1, j, dp, b, c), c.get(i - 1) + find(i, j - b.get(i - 1), dp, b, c));
		} else {
			dp[i][j] = find(i - 1, j, dp, b, c);
		}
		return dp[i][j];
	}

}
