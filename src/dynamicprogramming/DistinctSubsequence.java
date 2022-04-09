package dynamicprogramming;

/*
 * Q1. Distinct Subsequences
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



Problem Constraints

1 <= length(A), length(B) <= 700



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format

Return an integer representing the answer as described in the problem statement.



Example Input

Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit" 
 B = "rabbit" 


Example Output

Output 1:

 1
Output 2:

 3


Example Explanation

Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit" 
    => A = "rab_bit" 
    => A = "rabb_it"

 Note: "_" marks the removed character.

 */
public class DistinctSubsequence {

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}

	public static int numDistinct(String A, String B) {
		int i = A.length(), j = B.length();
		int[][] dp = new int[i + 1][j + 1];
		return find(i, j, dp, A, B);
	}

	private static int find(int i, int j, int[][] dp, String a, String b) {
		if (i == 0 && j == 0) {
			dp[i][j] = 1;
			return dp[i][j];
		} else if (j == 0) {
			dp[i][j] = 1;
			return dp[i][j];
		} else if (i == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (a.charAt(i-1) != b.charAt(j-1)) {
			dp[i][j] = find(i - 1, j, dp, a, b);
		} else {
			dp[i][j] = find(i - 1, j - 1, dp, a, b) + find(i - 1, j, dp, a, b);
		}

		return dp[i][j];
	}

}
