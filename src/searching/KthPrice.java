package searching;

import java.util.Arrays;
import java.util.List;
/*
 * Q2. KthPrice
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

Answer : 2
Constraints :

1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list
 */
public class KthPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> A = Arrays.asList(new Integer[] { 74, 90, 85, 58, 69, 77, 90, 85, 18, 36 });
		System.out.println(kthsmallest(A, 1));
	}

	public static int kthsmallest(final List<Integer> A, int B) {
		int min = A.get(0);
		int max = A.get(0);
		for (int i = 0; i < A.size(); i++) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}
		int l = min, r = max;
		int ans = 0;
		while (l <= r) {
			int mid = l + ((r - l) / 2);
			if (check(A, mid, B)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return ans;
	}

	static boolean check(List<Integer> A, int mid, int B) {
		int count = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) <= mid) {
				count++;
			}

		}

		if (count >= B) {
			return true;
		} else {
			return false;
		}
	}

}
