package searching;

public class SquareRoot {

	/*
	 * Q4. Square Root of Integer
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.



Problem Constraints

0 <= A <= 1010



Input Format

The first and only argument given is the integer A.



Output Format

Return floor(sqrt(A))



Example Input

Input 1:

 11
Input 2:

 9


Example Output

Output 1:

 3
Output 2:

 3


Example Explanation

Explanation:

 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147483647));

	}

	public static int sqrt(int A) {
		int l = 1, r = A;
		int ans = 0;
		int mid = 1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			long val = mid * mid;
			if (val == A) {
				return mid;
			} else if (val > A) {
				r = mid - 1;
			} else {
				ans = mid;
				l = mid + 1;
			}
		}
		return ans;
	}

}
