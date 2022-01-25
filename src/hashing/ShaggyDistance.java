package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q2. Shaggy and distances
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array as a special pair if elements at that index in the array are equal.

Shaggy wants you to find a special pair such that distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.



Problem Constraints

1 <= |A| <= 105



Input Format

First and only argument is the array A.



Output Format

Return one integer corresponding to the minimum possible distance between a special pair.



Example Input

Input 1:

A = [7, 1, 3, 4, 1, 7]
Input 2:

A = [1, 1]


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3. 
Explanation 2:

Only possibility is choosing A[1] and A[2].
 */
public class ShaggyDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 7, 1, 3, 4, 1, 7 })));
	}

	public static int solve(List<Integer> A) {
		HashMap<Integer, Integer> map = new HashMap();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			if (map.get(A.get(i)) == null) {
				map.put(A.get(i), i);
			} else {
				ans = Math.min(ans, i - map.get(A.get(i)));
				map.put(A.get(i), i);
			}
		}
		if (ans == Integer.MAX_VALUE) {
			return -1;
		}
		return ans;
	}

}
