package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q2. Unique Paths in a Grid
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.



Problem Constraints

1 <= n, m <= 100
A[i][j] = 0 or 1



Input Format

Firts and only argument A is a 2D array of size n * m.



Output Format

Return an integer denoting the number of unique paths from (1, 1) to (n, m).



Example Input

Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output

Output 1:

 2
Output 2:

 0


Example Explanation

Explanation 1:

 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 
Explanation 2:

 It is not possible to reach (n, m) from (1, 1). So, ans is 0.


See Expected Output
 */
public class UniquePathsInAGrid {

	public static void main(String[] args) {
		// Test 1
//		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
//		A.add(Arrays.asList(new Integer[] { 0, 0, 0 }));
//		A.add(Arrays.asList(new Integer[] { 0, 1, 0 }));
//		A.add(Arrays.asList(new Integer[] { 0, 0, 0 }));

		// test 2
//		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
//		A.add(Arrays.asList(new Integer[] { 0 }));

		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 1, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 0 }));

		System.out.println(uniquePathsWithObstacles(A));
	}

	public static int uniquePathsWithObstacles(ArrayList<List<Integer>> A) {
		int i = A.size() - 1, j = A.get(0).size() - 1;
		int dp[][] = new int[A.size()][A.get(0).size()];
		findUniquePaths(i, j, A, dp);
		return dp[A.size() - 1][A.get(0).size() - 1];
	}

	private static int findUniquePaths(int i, int j, ArrayList<List<Integer>> a, int[][] dp) {
		// if closed no of ways to reach that and from that will be zero only
		if (a.get(i).get(j) == 1) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (dp[i][j] > 0)
			return dp[i][j];
		if (i == 0 && j == 0) {
			dp[i][j] = 1;
			return dp[i][j];
		} else if (i == 0) {
			dp[i][j] = findUniquePaths(i, j - 1, a, dp);
			return dp[i][j];
		} else if (j == 0) {
			dp[i][j] = findUniquePaths(i - 1, j, a, dp);
			return dp[i][j];
		}

		dp[i][j] = findUniquePaths(i - 1, j, a, dp) + findUniquePaths(i, j - 1, a, dp);
		return dp[i][j];
	}

}
