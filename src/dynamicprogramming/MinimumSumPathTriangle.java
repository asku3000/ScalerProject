package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q1. Min Sum Path in Triangle
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



Problem Constraints

|A| <= 1000

A[i] <= 1000



Input Format

First and only argument is the vector of vector A defining the given triangle



Output Format

Return the minimum sum



Example Input

Input 1:

 
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output

Output 1:

 11
Output 2:

 1


Example Explanation

Explanation 1:

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:

 Only 2 can be collected.


 */
public class MinimumSumPathTriangle {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 2 }));
		A.add(Arrays.asList(new Integer[] { 3, 4 }));
		A.add(Arrays.asList(new Integer[] { 6, 5, 7 }));
		A.add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
		System.out.println(minimumTotal(A));

	}

	public static int minimumTotal(ArrayList<List<Integer>> A) {
		int i = 0, j = 0;
		int[][] dp = new int[A.size()][A.get(A.size() - 1).size()];
		return findMinPath(i, j, dp, A);
	}

	private static int findMinPath(int i, int j, int[][] dp, ArrayList<List<Integer>> a) {

		if (i == a.size() || j >= a.get(i).size()) {
			return 0;
		}

		if (i == a.size() - 1) {
			return a.get(i).get(j);
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		dp[i][j] = a.get(i).get(j) + Math.min(findMinPath(i + 1, j, dp, a), findMinPath(i + 1, j + 1, dp, a));

		return dp[i][j];
	}

}
