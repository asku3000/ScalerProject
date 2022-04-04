package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q2. Max Sum Without Adjacent Elements
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.



Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000



Input Format

The first and the only argument of input contains a 2d matrix, A.



Output Format

Return an integer, representing the maximum possible sum.



Example Input

Input 1:

 A = [   
        [1]
        [2]    
     ]
Input 2:

 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]


Example Output

Output 1:

 2
Output 2:

 8


Example Explanation

Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5.


 */
public class MaxSumWithoutAdjacentElements {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		A.add(Arrays.asList(new Integer[] { 2, 3, 4, 5 }));
		System.out.println(adjacent(A));
	}

	public static int adjacent(ArrayList<List<Integer>> A) {
		int dp[] = new int[A.get(0).size() + 1];
		int i = A.get(0).size() - 1;
		return findSum(A, dp, i);

	}

	private static int findSum(ArrayList<List<Integer>> A, int[] dp, int i) {
		if (i == 0) {
			return Math.max(A.get(0).get(i), A.get(1).get(i));
		}
		if (i == 1) {
			return Math.max(Math.max(A.get(0).get(i), A.get(1).get(i)), Math.max(A.get(0).get(0), A.get(1).get(0)));
		}

		if (dp[i] != 0) {
			return dp[i];
		}

		dp[i] = Math.max(Math.max(A.get(0).get(i), A.get(1).get(i)) + findSum(A, dp, i - 2), findSum(A, dp, i - 1));

		return dp[i];
	}

}
