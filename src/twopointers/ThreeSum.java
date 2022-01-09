package twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Q5. 3 Sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints

-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format

First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format

Return a single integer denoting the sum of three integers which is closest to B.



Example Input

Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output

Output 1:

2
Output 2:

6


Example Explanation

Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(threeSumClosest(Arrays.asList(new Integer[] {2, 1, -9, -7, -8, 2, -8, 2, 3, -8}), -1));
	}

	public static int threeSumClosest(List<Integer> A, int B) {
		Collections.sort(A);
		int ans = Integer.MAX_VALUE;
		for (int k = 0; k < A.size() - 2; k++) {
			int i = k + 1, j = A.size() - 1;
			while (i < j) {
				int sum = (A.get(k) + A.get(i) + A.get(j));
				if(Math.abs(ans-Math.abs(B))>Math.abs(sum-Math.abs(B))) {
					ans = sum;
				}
				if (sum == B) {
					return sum;
				} else if (sum < B) {
					i++;
				} else {
					j--;
				}
			}
		}

		return ans;
	}

}
