package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q1. Sub-array with 0 sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints

1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return whether the given array contains a subarray with a sum equal to 0.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.
 */
public class SubArraySumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 1, 2, 0, -2 };

		List<Integer> A = Arrays.asList(a);
		System.out.println(solve(A));

	}

	public static int solve(List<Integer> A) {
		if (A.get(0) == 0) {
			return 1;
		}

		HashMap<Long, Integer> map = new HashMap();

		ArrayList<Long> prefixSum = new ArrayList();
		prefixSum.add(Long.valueOf(A.get(0)));

		for (int i = 1; i < A.size(); i++) {
			Long value =  A.get(i) + prefixSum.get(i - 1);
			prefixSum.add(Long.valueOf(value));
			if (prefixSum.get(i) == 0 || A.get(i) == 0) {
				return 1;
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (map.get(prefixSum.get(i)) != null) {
				return 1;
			} else {
				map.put(prefixSum.get(i), 1);
			}
		}

		return 0;

	}

}
