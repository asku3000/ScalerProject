package searching;

public class AthMagicalNumber {
	/*
	 * Q3. Maximum height of staircase
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.

The first stair would require only one block, the second stair would require two blocks and so on.

Find and return the maximum height of the staircase.



Problem Constraints

0 <= A <= 109


Input Format

The only argument given is integer A.



Output Format

Return the maximum height of the staircase using these blocks.



Example Input

Input 1:

 A = 10
Input 2:

 20


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation


	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(14, 10, 12));
	}

	public static int solve(int A, int B, int C) {
		long mod = 1000000007;
		long gcd = gcd(B, C);
		long product = B * C;
		long lcm = product / gcd;
		long l = Math.min(B, C);
		long r = (long) A * Math.min(B, C);
		long mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			long noOFFators = (mid / B) + (mid / C) - (mid / lcm);
			if (noOFFators == A && (mid % B != 0 && mid % C != 0)) {
				r = mid - 1;
			} else if (noOFFators == A && (mid % B == 0 || mid % C == 0)) {
				return (int) (mid%mod);
			} else if (noOFFators > A) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) (mid % mod);
    }

    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
