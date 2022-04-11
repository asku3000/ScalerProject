package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Unbounded Knapsack
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format

Return the maximum value that fills the knapsack completely



Example Input

Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output

Output 1:

 5
Output 2:

14


Example Explanation

Explanation 1:

Only valid possibility is to take the given item.
Explanation 2:

Take the second item twice.
 */
public class UnboundedKnapsack {

	public static void main(String[] args) {
		int A = 10;
		List<Integer> B = Arrays.asList(new Integer[] { 6, 7 });
		List<Integer> C = Arrays.asList(new Integer[] { 5, 5 });
		System.out.println(solve(A, B, C));
	}

	public static int solve(int A, List<Integer> B, List<Integer> C) {
		int i = B.size(), j = A;
		int[][] dp = new int[i + 1][j + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return find(i, j, dp, B, C);
	}

	private static int find(int i, int j, int[][] dp, List<Integer> b, List<Integer> c) {

		if (i == 0 || j == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (j >= c.get(i - 1)) {
			dp[i][j] = Math.max(find(i - 1, j, dp, b, c), b.get(i - 1) + find(i, j - c.get(i - 1), dp, b, c));
		} else {
			dp[i][j] = find(i - 1, j, dp, b, c);
		}
		return dp[i][j];
	}

}
