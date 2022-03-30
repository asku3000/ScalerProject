package backtracking;

import java.util.ArrayList;

/*
 * Q1. NQueens
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints

1 <= A <= 10



Input Format

First argument is an integer n denoting the size of chessboard



Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input

Input 1:

A = 4
Input 2:

A = 1


Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation

Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:


 */
public class NQueens {

	public static void main(String[] args) {
		for(ArrayList<String> li: solveNQueens(4)) {
			for(String s: li) {
				System.out.println(s);
			}
			System.out.print("\n");
		}
	}
	
	public static ArrayList<ArrayList<String>> solveNQueens(int A) {
		int row = 0;
		int column[] = new int[A];
		for (int i = 0; i < column.length; i++) {
			column[i] = -1;
		}
		ArrayList<ArrayList<String>> result = new ArrayList();
		find(row, column, result);
		return result;
	}

	static void find(int row, int[] column, ArrayList<ArrayList<String>> result) {
		// size N
		if (row == column.length) {
			StringBuilder s = null;
			ArrayList<String> temp = new ArrayList<String>();
			for (int i = 0; i < column.length; i++) {
				s = new StringBuilder("");
				for (int j = 0; j < column.length; j++) {
					if (j == column[i]) {
						s.append("Q");
					} else {
						s.append(".");
					}
				}
//				column[i] = -1;
				temp.add(s.toString());
			}
			result.add(temp);
			return;
		}

		for (int c = 0; c < column.length; c++) {
			if (isValid(row, c, column)) {
				column[row] = c;
				find(row + 1, column, result);
				column[row] = -1;
			}
		}

	}

	private static boolean isValid(int row, int c, int[] column) {
		for (int i = 0; i < column.length; i++) {
			if (column[i] == c) {
				return false;
			}
			if (column[i] != -1 && ((row + c) == (i + column[i])) || ((row - c) == (i - column[i]))) {
				return false;
			}
		}
		return true;
	}

}
