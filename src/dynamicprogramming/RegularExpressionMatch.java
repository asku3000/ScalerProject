package dynamicprogramming;

import java.util.Arrays;

/*
 * Q3. Regular Expression Match
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:

 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.
 */
public class RegularExpressionMatch {

	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "a*"));
		System.out.println(isMatch("acz", "a?a"));
		System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*"));
	}

	public static int isMatch(final String A, final String B) {
		boolean allStar = true;
		for(int i=0; i<B.length(); i++) {
			if(B.charAt(i)!='*') {
				allStar = false;
			}
		}
		
		if(allStar) {
			return 1;
		}
		int i = A.length(), j = B.length();
		int[][] dp = new int[i + 1][j + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return find(i, j, dp, A, B);
	}

	private static int find(int i, int j, int[][] dp, String a, String b) {

		if (i == 0 && j == 0) {
			dp[i][j] = 1;
			return dp[i][j];
		} else if (i == 0) {
			for(int k=0; k<b.length(); k++) {
				if(b.charAt(k)!= '*') {
					dp[i][j] = 0;
					return dp[i][j];
				}
			}
			dp[i][j] = 1;
			return dp[i][j];
		} else if (j == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (a.charAt(i - 1) == b.charAt(j - 1) || b.charAt(j - 1) == '?') {
			dp[i][j] = find(i - 1, j - 1, dp, a, b);
		} else if (b.charAt(j - 1) == '*') {

			int zeroCharsMatch = find(i, j - 1, dp, a, b);
			int someCharsMatch = find(i - 1, j, dp, a, b);
			if (zeroCharsMatch == 1 || someCharsMatch == 1) {
				dp[i][j] = 1;
			} else {
				dp[i][j] = 0;
			}
		} else {
			dp[i][j] = 0;
		}
		return dp[i][j];
	}

}
