package dynamicprogramming;

import java.util.Arrays;

/*
 * Q1. Longest Common Subsequence
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.



Problem Constraints
1 <= Length of A, B <= 1005



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return an integer denoting the length of the longest common subsequence.



Example Input
Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
Input 2:

 A = "aaaaaa"
 B = "ababab"


Example Output
Output 1:

 5
Output 2:

 3


Example Explanation
Explanation 1:

 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:

 The longest common subsequence is "aaa", which has a length of 3.

 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(solve("abbcdgf", "bbadcgf"));
	}

	public static int solve(String A, String B) {
		int i= A.length(), j= B.length();
		int [][] dp = new int[i+1][j+1];
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		return findLCS(i, j, dp, A, B);
	}

	private static int findLCS(int i, int j, int[][] dp, String a, String b) {
		
		if(i==0 || j==0) {
			dp[i][j] = 0;
			return dp[i][j];
		}
		
		if(dp[i][j]!= -1) {
			return dp[i][j];
		}
		
		if(a.charAt(i-1) == b.charAt(j-1)) {
			dp[i][j] = 1+findLCS(i-1, j-1, dp, a, b);
		}else {
			dp[i][j] = Math.max(findLCS(i-1, j, dp, a, b), findLCS(i, j-1, dp, a, b));
		}
		
		return dp[i][j];
	}

}
