package sorting;

import java.util.Arrays;
import java.util.List;

public class AlternatePosAndNegaNumbers {

	/*
	 * Q2. Alternate positive and negative elements
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.

If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

Note: Try solving with O(1) extra space.



Problem Constraints

1 <= length of the array <= 7000
-109 <= A[i] <= 109



Input Format

The first argument given is the integer array A.



Output Format

Return the modified array.



Example Input

Input 1:

 A = [-1, -2, -3, 4, 5]
Input 2:

 A = [5, -17, -100, -11]


Example Output

Output 1:

 [-1, 4, -2, 5, -3]
Output 2:

 [-17, 5, -100, -11]


Example Explanation

Explanation 1:

A = [-1, -2, -3, 4, 5]
Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(Arrays.asList(new Integer[] { -1, -2, 0, 4, 5 }));
	}

	public static List<Integer> solve(List<Integer> A) {

		for (int i = 0; i < A.size(); i++) {
			if (i % 2 == 0 && A.get(i) < 0) {
				continue;
			} else if (i % 2 != 0 && A.get(i) >= 0) {
				continue;
			} else {
				int j = i + 1;
				while (j < A.size()) {
					if (A.get(i) < 0 && A.get(j) >= 0) {
						break;
					} else if (A.get(i) >= 0 && A.get(j) < 0) {
						break;
					} else {
						j++;
					}
				}
				if (j == A.size()) {
					break;
				}
				int k = j;
				int t = A.get(j);
				while (k > i) {
					A.set(k, A.get(k - 1));
					k--;
				}
				A.set(i, t);
			}
		}

		return A;

	}

}
