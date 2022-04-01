package dynamicprogramming;

/*
 * Q4. Minimum Number of Squares
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



Problem Constraints

1 <= A <= 105



Input Format

First and only argument is an inetegr A.



Output Format

Return an integer denoting the minimum count.



Example Input

Input 1:

 A = 6
Input 2:

 A = 5


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3. 
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5


 */
public class MinimumNumberOfSquares {

	public static void main(String[] args) {
		System.out.println(countMinSquares(6));
	}

	public static int countMinSquares(int A) {
		int[] dp = new int[A + 1];
		return count(A, dp);
	}

	private static int count(int a, int[] dp) {
		if (a == 0)
			return 0;
		if (a == 1)
			return 1;
		if (dp[a] != 0)
			return dp[a];
		int temp = Integer.MAX_VALUE;
		for(int x=1; x*x<=a; x++) {
			temp = Math.min(temp, count((int) (a-Math.pow(x, 2)), dp));
		}
		dp[a] = 1+ temp;
		return dp[a];
	}
}
