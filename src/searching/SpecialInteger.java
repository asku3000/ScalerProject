package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Special Integer
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the maximum value of K (sub array length).



Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3.


 */
public class SpecialInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }), 10));
	}

	public static int solve(List<Integer> A, int B) {
		ArrayList<Long> prefixSum = new ArrayList();
		prefixSum.add(0l);
		for (int i = 0; i < A.size(); i++) {
			prefixSum.add((long) (A.get(i) + prefixSum.get(i)));
		}

		int l = 1, r = A.size();
		int mid = 0;
		int ans = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (check(mid, prefixSum, B, A)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

	static boolean check(int k, ArrayList<Long> prefix, int B, List<Integer> A) {
		int i = 1, j = k;
		while (j < A.size() + 1) {
			if ((prefix.get(j) - prefix.get(i - 1)) > B) {
				return false;
			}
			i++;
			j++;
		}
//		if (j >= A.size() + 1) {
//			return false;
//		}
		return true;
	}

}
