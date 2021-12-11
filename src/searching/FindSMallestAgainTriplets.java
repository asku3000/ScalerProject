package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Find Smallest Again
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A of size N.

If we store the sum of each triplet of the array A in a new list then find the Bth smallest element among the list.

NOTE: A triplet consist of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.



Problem Constraints

3 <= N <= 500
1 <= A[i] <= 108
1 <= B <= (N*(N-1)*(N-2))/6



Input Format

First argument is an integer array A.
Second argument is an integer B.



Output Format

Return an integer denoting the Bth element of the list.



Example Input

Input 1:

 A = [2, 4, 3, 2]
 B = 3
Input 2:

 A = [1, 5, 7, 3, 2]
 B = 9


Example Output

Output 1:

 9 
Output 2:

 14


Example Explanation

Explanation 1:

 All the triplets of the array A are:
 (2, 4, 3) = 9
 (2, 4, 2) = 8
 (2, 3, 2) = 7
 (4, 3, 2) = 9
So the 3rd smallest element is 9.
 */

public class FindSMallestAgainTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				solve(Arrays.asList(new Integer[] { 22, 10, 5, 11, 16, 2, 11, 7, 16, 2, 17, 6, 15, 3, 9, 6 }), 183));
	}

	public static int solve(List<Integer> A, int B) {
		Collections.sort(A);
		long l = A.get(0) + A.get(1) + A.get(2);
		int n = A.size();
		long r = A.get(n - 1) + A.get(n - 2) + A.get(n - 3);
		long mid = 0;
		long ans = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (check(A, mid, B)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return (int) ans;
	}

	static boolean check(List<Integer> A, long mid, int B) {
		int count = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				long val = mid - i - j;
				if (val <= 0) {
					break;
				}
				int idx = lowerBound(A, val);
				if (idx > j) {
					count += idx - j - 1;
				}
			}
		}

		if (count < B) {
			return true;
		}

		return false;
	}

	static int lowerBound(List<Integer> A, long val) {
		// int idx =0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= val) {
				return i;
			}
		}
		return A.size();
	}

}
