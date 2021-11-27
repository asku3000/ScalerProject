package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePaths3 {

	/*
	 * Unique Paths III Solved character backgroundcharacter Stuck somewhere? Ask
	 * for help from a TA & get it resolved Get help from TA Problem Description
	 * 
	 * Given a matrix of integers A of size N x M . There are 4 types of squares in
	 * it:
	 * 
	 * 1. 1 represents the starting square. There is exactly one starting square. 2.
	 * 2 represents the ending square. There is exactly one ending square. 3. 0
	 * represents empty squares we can walk over. 4. -1 represents obstacles that we
	 * cannot walk over. Find and return the number of 4-directional walks from the
	 * starting square to the ending square, that walk over every non-obstacle
	 * square exactly once.
	 * 
	 * Note: Rows are numbered from top to bottom and columns are numbered from left
	 * to right.
	 * 
	 * 
	 * 
	 * Problem Constraints
	 * 
	 * 2 <= N * M <= 20 -1 <= A[i] <= 2
	 * 
	 * 
	 * 
	 * Input Format
	 * 
	 * The first argument given is the integer matrix A.
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Return the number of 4-directional walks from the starting square to the
	 * ending square, that walk over every non-obstacle square exactly once.
	 * 
	 * 
	 * 
	 * Example Input
	 * 
	 * Input 1:
	 * 
	 * A = [ [1, 0, 0, 0] [0, 0, 0, 0] [0, 0, 2, -1] ] Input 2:
	 * 
	 * A = [ [0, 1] [2, 0] ]
	 * 
	 * 
	 * Example Output
	 * 
	 * Output 1:
	 * 
	 * 2 Output 2:
	 * 
	 * 0
	 * 
	 * 
	 * Example Explanation
	 * 
	 * Explanation 1:
	 * 
	 * We have the following two paths: 
	 * 1.(0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
	 * 
	 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
	 * Explanation 1:
	 * 
	 * Answer is evident here.
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, 0, 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 0, 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 0, 2, -1 }));
		solve(A);
		System.out.println(result);
	}

	static int result;

	public static int solve(ArrayList<List<Integer>> A) {
		int N = A.size();
		int M = A.get(0).size();
		int x = -1;
		int y = -1;
		result = 0;
		int count = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				if (A.get(i).get(j) == 1) {
					x = i;
					y = j;
				} else if (A.get(i).get(j) == 0) {
					count++;
				}
			}
		}
		check(x, y, N, M, A, count + 1);
		return result;
	}

	private static void check(int x, int y, int n, int m, ArrayList<List<Integer>> a, int count) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			// outside;
			return;
		}
		if (a.get(x).get(y) == 2) {
			// System.out.println(count);
			if (count == 0)
				result++;
			return;
		}
		if (a.get(x).get(y) == -1) {
			// blocked //already visited
//			a.get(x).set(y, 0);
			return;
		}

		if (a.get(x).get(y) == -2) {
			// already visited
//			a.get(x).set(y, 0);
			return;
		}
		// marking the visited cell
		a.get(x).set(y, -2);
		check(x + 1, y, n, m, a, count - 1);
		check(x, y + 1, n, m, a, count - 1);
		check(x - 1, y, n, m, a, count - 1);
		check(x, y - 1, n, m, a, count - 1);
		a.get(x).set(y, 0);
	}

}
