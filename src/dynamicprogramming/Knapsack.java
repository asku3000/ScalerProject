package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. 0-1 Knapsack
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints
1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format
First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format
Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input
Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output
Output 1:

 220
Output 2:

 0


Example Explanation
Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.



See Expected Output
 */
public class Knapsack {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 60, 100, 120 });
		List<Integer> B = Arrays.asList(new Integer[] { 10, 20, 30 });
		int C = 50;
		System.out.println(solve(A, B, C));
	}

	public static int solve(List<Integer> A, List<Integer> B, int C) {
		int[][] dp = new int[A.size() + 1][C + 1];
		int i = A.size(), j = C;
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return find(i, j, dp, A, B);
	}

	private static int find(int i, int j, int[][] dp, List<Integer> a, List<Integer> b) {
		if (i == 0 || j == 0) {
			dp[i][j] = 0;
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (j >= b.get(i - 1)) {
			dp[i][j] = Math.max(find(i - 1, j, dp, a, b), a.get(i - 1) + find(i - 1, j - b.get(i - 1), dp, a, b));
		} else {
			dp[i][j] = find(i - 1, j, dp, a, b);
		}

		return dp[i][j];

	}

}
