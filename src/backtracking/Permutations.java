package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q4. Permutations
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints

1 <= N <= 9



Input Format

Only argument is an integer array A of size N.



Output Format

Return a 2-D array denoting all possible permutation of the array.



Example Input

A = [1, 2, 3]


Example Output

[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]


Example Explanation

All the possible permutation of array [1, 2, 3].


 */
public class Permutations {

	public static void main(String[] args) {
		for (ArrayList<Integer> list : permute(Arrays.asList(new Integer[] { 1, 2, 3 }))) {
			System.out.println("\n");
			for (Integer li : list) {
				System.out.print(li + " ");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
		int i = 0;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		find(i, A, result);
		return result;
	}

	private static void find(int i, List<Integer> a, ArrayList<ArrayList<Integer>> result) {
		if (i == a.size()) {
			result.add(new ArrayList<Integer>(a));
			return;
		}

		for (int j = i; j < a.size(); j++) {
			swap(a, i, j);// do
			find(i + 1, a, result);
			swap(a, j, i);// undo
		}
	}

	private static void swap(List<Integer> A, int j, int i) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
