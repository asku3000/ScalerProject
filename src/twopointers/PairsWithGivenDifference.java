package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Q2. Pairs with Given Difference
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints

1 <= N <= 104

0 <= A[i], B <= 105



Input Format

First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format

Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input

Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output

Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation

Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.*/
public class PairsWithGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 1, 1, 2, 2 }), 0));
	}

	public static int solve(List<Integer> A, int B) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < A.size(); i++) {
			if (map.get(A.get(i)) != null) {
				map.put(A.get(i), map.get(A.get(i)) + 1);
			} else {
				map.put(A.get(i), 1);
			}
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			if (B == 0) {
				if (map.get(m.getKey()) > 1)
					count++;
			} else {
				if (map.get(B + m.getKey()) != null)
					count++;
			}
		}

		return count;
	}

}
