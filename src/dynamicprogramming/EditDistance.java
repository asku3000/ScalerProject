package dynamicprogramming;

import java.util.Arrays;

/*
 * 2. Edit Distance
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints

1 <= length(A), length(B) <= 450



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.



Output Format

Return an integer, representing the minimum number of steps required.



Example Input

Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 */
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("Anshuman", "Antihuman"));
	}

	public static int minDistance(String A, String B) {
		int i = A.length(), j = B.length();
		int[][] dp = new int[i + 1][j + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int costi = 1, costd = 1, costr = 1;
		return minCost(i, j, dp, A, B, costd, costi, costr);
	}

	private static int minCost(int i, int j, int[][] dp, String a, String b, int costd, int costi, int costr) {

		if (i == 0 && j == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

        if(dp[i][j] != -1){
            return dp[i][j];
        }

		if (i == 0 && j != 0) {
			dp[i][j] = j * 1;
			return dp[i][j];
		}

		if (i != 0 && j == 0) {
			dp[i][j] = i * 1;
			return dp[i][j];
		}

		if (a.charAt(i - 1) == b.charAt(j - 1)) {
			dp[i][j] = minCost(i - 1, j - 1, dp, a, b, costr, costr, costr);
		} else {
			dp[i][j] = Math.min(costr + minCost(i - 1, j - 1, dp, a, b, costd, costi, costr),
					Math.min(costi + minCost(i, j - 1, dp, a, b, costd, costi, costr),
							costd + minCost(i - 1, j, dp, a, b, costd, costi, costr)));
		}

		return dp[i][j];
	}

}
