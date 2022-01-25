package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q2. Count Right Triangles
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints

1 <= N <= 105

0 <= A[i], B[i] <= 109



Input Format

The first argument given is an integer array A.
The second argument given is the integer array B.



Output Format

Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).



Example Input

Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]


Example Output

Output 1:

 1
Output 2:

 6


Example Explanation

Explanation 1:

 All three points make a right angled triangle. So return 1.
Explanation 2:

 6 quadruplets which make a right angled triangle are: (1, 1), (1, 2), (2, 2)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
 */
public class CountRightTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				solve(Arrays.asList(new Integer[] { 1, 1, 2, 3, 3 }), Arrays.asList(new Integer[] { 1, 2, 1, 2, 1 })));
	}

	public static int solve(List<Integer> A, List<Integer> B) {
		HashMap<Integer, Integer> x = new HashMap();
		for (Integer i : A) {
			if (x.get(i) == null) {
				x.put(i, 1);
			} else {
				x.put(i, x.get(i) + 1);
			}
		}

		HashMap<Integer, Integer> y = new HashMap();
		for (Integer i : B) {
			if (y.get(i) == null) {
				y.put(i, 1);
			} else {
				y.put(i, y.get(i) + 1);
			}
		}
		long ans = 0;
		long mod = 1000000007;
		for (int i = 0; i < A.size(); i++) {
			ans = ans % mod + ((((x.get(A.get(i)) - 1) % mod) * ((y.get(B.get(i)) - 1) % mod)) % mod) % mod;
		}

		return (int) ans;
	}

}
