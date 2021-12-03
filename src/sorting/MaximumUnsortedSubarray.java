package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q2. Maximum Unsorted Subarray
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,…, Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.



Problem Constraints

1 <= N <= 1000000
1 <= A[i] <= 1000000



Input Format

First and only argument is an array of non-negative integers of size N.



Output Format

Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.



Example Input

Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output

Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation

Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.
 */

public class MaximumUnsortedSubarray {

	public static void main(String[] args) {

		for (Integer i : subUnsort(Arrays.asList(new Integer[] { 1, 1 }))) {
			System.out.print(" " + i);
		}

	}

	public static ArrayList<Integer> subUnsort(List<Integer> A) {
		ArrayList<Integer> ans = new ArrayList();
		int i = 0, j = A.size() - 1;

		while (i < A.size() - 1 && A.get(i) <= A.get(i + 1))
			i++;

		while (j > 0 && A.get(j) >= A.get(j - 1))
			j--;

		if (i == A.size() - 1) {
			ans.add(-1);
			return ans;
		}
		int min = A.get(i), max = A.get(j);
		for (int k = i; k <= j; k++) {
			min = Math.min(min, A.get(k));
			max = Math.max(max, A.get(k));
		}

		int l = 0, r = A.size() - 1;

		while (A.get(l) <= min && l <= i) {
			l++;
		}

		while (A.get(r) >= max && r >= j) {
			r--;
		}

		ans.add(l);
		ans.add(r);
		return ans;
	}

}
