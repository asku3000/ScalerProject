package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Q2. Points on same line
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2D plane. A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane.

Find and return the maximum number of points which lie on the same line.



Problem Constraints

1 <= (length of the array A = length of array B) <= 1000

-105 <= A[i], B[i] <= 105



Input Format

First argument is an integer array A.
Second argument is an integer array B.



Output Format

Return the maximum number of points which lie on the same line.



Example Input

Input 1:

 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]
Input 2:

 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]


Example Output

Output 1:

 4
Output 2:

 2


Example Explanation

Explanation 1:

 The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
Explanation 2:

 Any 2 points lie on a same line.
 */
public class PointsOnASameLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { -1, 0, 1, 2, 3, 3 }),
				Arrays.asList(new Integer[] { 1, 0, 1, 2, 3, 4 })));
	}

	public static int solve(List<Integer> A, List<Integer> B) {
		int ans = 0;
		for (int i = 0; i < A.size(); i++) {
			HashMap<String, Integer> map = new HashMap();
			int dup = 0;
			for (int j = i; j < A.size(); j++) {
				if (A.get(i).equals(A.get(j)) && B.get(j).equals(B.get(i)))
					dup++;
				else {
					int dx = A.get(j) - A.get(i);
					int dy = B.get(j) - B.get(i);
					int gcd = findGcd(dx, dy);
					String key = "" + dx / gcd + "_" + dy / gcd;
					if (map.get(key) == null)
						map.put(key, 1);
					else
						map.put(key, map.get(key) + 1);
				}
			}

			ans = Math.max(ans, dup);
			for (Map.Entry<String, Integer> e : map.entrySet()) {
				ans = Math.max(ans, e.getValue() + dup);
			}

		}

		return ans;
	}

	static int findGcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return findGcd(b, a % b);
		}
	}

}
