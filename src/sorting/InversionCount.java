package sorting;

import java.util.Arrays;
import java.util.List;

/*
 * Inversion count in an array
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.

 */
public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 28, 18, 44, 49, 41, 14  });
		System.out.println(solve(A));
	}

	static long inversionCount;
	static long mod = 1000000007;
	public static int solve(List<Integer> A) {
		int l = 0;
		int r = A.size() - 1;
		inversionCount = 0;
		mergeSort(A, l, r);
		return (int) inversionCount;
	}

	private static void mergeSort(List<Integer> a, int l, int r) {
		if (l == r)
			return;
		int mid = l + ((r - l) / 2);
		mergeSort(a, l, mid);
		mergeSort(a, mid + 1, r);
		inversionCount += merge(a, l, mid, r);
	}

	private static long merge(List<Integer> A, int l, int mid, int r) {
		long inversionCount = 0;
		int temp[] = new int[r - l + 1];

		int i = l, j = mid + 1, k = 0;

		while (i <= mid && j <= r) {
			if (A.get(i) <= A.get(j)) {
				temp[k] = A.get(i);
				i++;
			} else {
				temp[k] = A.get(j);
				inversionCount = ((inversionCount%mod) + (mid - i + 1)%mod)%mod;
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = A.get(i);
			i++;
			k++;
		}

		while (j <= r) {
			temp[k] = A.get(j);
			j++;
			k++;
		}

		for (i = l; i <= r; i++) {
			A.set(i, temp[i - l]);
		}

		return inversionCount;
	}

}
