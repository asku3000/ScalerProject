package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Search for a Range
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 First occurence of 8 in A is at index 3
 Second occurence of 8 in A is at index 4
 ans = [3, 4]
Explanation 2:

 There is no occurence of 3 in the a
 */
public class SearchForARange {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
		ArrayList<Integer> result = searchRange(A, 10);
		System.out.println(result.get(0)+" "+result.get(1));

	}

	public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList();
		ans.add(searchFirst(A, B));
		ans.add(searchSecond(A, B));
		return ans;
	}

	static int searchFirst(List<Integer> A, int B) {
		int l = 0, r = A.size() - 1;
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (A.get(mid).equals(B) && (mid == 0 || !A.get(mid).equals(A.get(mid - 1)) )) {
				return mid;
			} else {
				if (A.get(mid).compareTo(B) < 0) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}

		return -1;
	}

	static int searchSecond(List<Integer> A, int B) {
		int l = 0, r = A.size() - 1;
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (A.get(mid).equals(B) && ( mid == A.size() - 1 || !A.get(mid).equals(A.get(mid + 1)))) {
				return mid;
			} else {
				if (A.get(mid).compareTo(B) <= 0) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}

		return -1;
	}

}
