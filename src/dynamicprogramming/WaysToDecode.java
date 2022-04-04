package dynamicprogramming;

/*
 * Q3. Ways to Decode
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints
1 <= length(A) <= 105



Input Format
The first and the only argument is a string A.



Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input
Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.

 */
public class WaysToDecode {

	public static void main(String[] args) {
//		System.out.println(numDecodings("2163"));
		System.out.println(numDecodings("875361268549483279131"));
//		System.out.println(numDecodings("10"));
//		System.out.println(numDecodings("4612"));
	}

	static long mod = 1000000007;

	public static int numDecodings(String A) {
		int dp[] = new int[A.length() + 1];
		int i = 0;
		if (A.equals("0")) {
			return 0;
		}
		return findWays(A, i, dp);
	}

	private static int findWays(String A, int i, int[] dp) {
		if (i == A.length()) {
			return 1;
		}

		if (dp[i] != 0) {
			return dp[i];
		}

		int oneIndex = 0;
		if (A.charAt(i) >= '1' && A.charAt(i) <= '9') {
			oneIndex = findWays(A, i + 1, dp);
		}

		int twoIndex = 0;

		if (i + 2 <= A.length()) {
			if (A.charAt(i) == '1') {
				if (A.charAt(i + 1) >= '0' && A.charAt(i + 1) <= '9') {
					twoIndex = findWays(A, i + 2, dp);
				}
			}

			if (A.charAt(i) == '2') {
				if (A.charAt(i + 1) >= '0' && A.charAt(i + 1) <= '6') {
					twoIndex = findWays(A, i + 2, dp);
				}
			}
		}

		dp[i] = (int) ((oneIndex % mod + twoIndex % mod) % mod);
		return dp[i];
	}

}
