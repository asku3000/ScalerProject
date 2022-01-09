package recurrsion;

public class KthSymbol {

	/**
	 * Q3. Kth Symbol
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).



Problem Constraints

1 <= A <= 20

1 <= B <= 2A - 1



Input Format

First argument is an integer A.

Second argument is an integer B.



Output Format

Return an integer denoting the Bth indexed symbol in row A.



Example Input

Input 1:

 A = 2
 B = 1
Input 2:

 A = 2
 B = 2


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 Row 1: 0
 Row 2: 01
Explanation 2:

 Row 1: 0
 Row 2: 01
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(2, 1));
	}

	public static int solve(int A, int B) {
		B = B - 1; // just to make it 0 based indexing
		return find(A, B);
	}

	static int find(int A, int B) {
		if (B == 0 || A == 0)
			return 0;

		int x = find(A - 1, B / 2);
		if (B % 2 == 0) {
			return x;
		} else {
			return 1 - x; // toggling
		}
	}
}
