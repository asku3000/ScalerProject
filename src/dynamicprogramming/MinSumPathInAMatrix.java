package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q4. Min Sum Path in Matrix
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints

1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000



Input Format

First and only argument is a 2-D grid A.



Output Format

Return an integer denoting the minimum sum of the path.



Example Input

Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output

Output 1:

 8
Output 2:

 -1


Example Explanation

Explanation 1:

 The path will be: 1 -> 3 -> 2 -> 1 -> 1.
Input 2:

 The path will be: 1 -> -3 -> 5 -> -5 -> 1.

 */
public class MinSumPathInAMatrix {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, -3, 2 }));
		A.add(Arrays.asList(new Integer[] { 2, 5, 10 }));
		A.add(Arrays.asList(new Integer[] { 5, -5, 1}));
		System.out.println(minPathSum(A));
	}

	public static int minPathSum(ArrayList<List<Integer>> A) {
		int [][] dp = new int [A.size()][A.get(0).size()];
		int n = A.size()-1, m= A.get(0).size()-1;
		
		dp[0][0] = A.get(0).get(0);
		for(int i=1; i<A.get(0).size(); i++) {
			dp[0][i] = dp[0][i-1]+A.get(0).get(i);
		}
		for(int i=1; i<A.size(); i++) {
			dp[i][0] = dp[i-1][0]+A.get(i).get(0);
		}
		int i=n, j=m;
		return findCost(i, j, A, dp, n, m);
	}

	private static int findCost(int i, int j, ArrayList<List<Integer>> a, int[][] dp, int n, int m) {
		if(i==0 && j==0) {
			return dp[0][0];
		}
		if(i==0) {
			return dp[0][j];
		}else if(j==0) {
			return dp[i][0];
		}
		
		if(dp[i][j] != 0 && i!=0 && j!=0) return dp[i][j];
		
		dp[i][j] = a.get(i).get(j) + Math.min(findCost(i-1, j, a, dp, n, m), findCost(i, j-1, a, dp, n, m));
		
		return dp[i][j];
		
	}


}
