package searching;

import java.util.Arrays;
import java.util.List;
/*
 * Q3. Find a peak element
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the peak element.



Example Input

Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output

Output 1:

 5
Output 2:

 100


Example Explanation

Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.

 */
public class LocalMaxima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 2, 3 })));
	}

	public static int solve(List<Integer> A) {
		int l = 0, r = A.size() - 1;
		if (l == r) {
			return A.get(l);
		}
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (mid == 0) {
				return Math.max(A.get(mid), A.get(mid + 1));
			}
			if (mid == A.size() - 1) {
				return Math.max(A.get(mid), A.get(mid - 1));
			}
			// previous element < mid > next element that is the answer
			if (mid > 0 && (A.get(mid) >= A.get(mid - 1) && A.get(mid) >= A.get(mid + 1))) {
				return A.get(mid);
			}
			// previous element > mid > next element then move left
			else if (mid > 0 && (A.get(mid - 1) >= A.get(mid)) && (A.get(mid) > A.get(mid + 1))) {
				r = mid - 1;
			} else if (mid > 0 && (A.get(mid - 1) < A.get(mid)) && (A.get(mid) <= A.get(mid + 1))) {
				l = mid + 1;
			}
		}
		return -1;
	}

}
