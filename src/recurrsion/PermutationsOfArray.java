package recurrsion;

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
public class PermutationsOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (ArrayList<Integer> list : permute(Arrays.asList(new Integer[] { 1, 2, 3 }))) {
			System.out.println("\n");
			for (Integer li : list) {
				System.out.print(li + " ");
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		int i = 0;
		solve(i, A, result);
		return result;
	}

	static void solve(int i, List<Integer> A, ArrayList<ArrayList<Integer>> result) {
		if (i == A.size()) {
			ArrayList<Integer> li = new ArrayList();
			li.addAll(A);
			result.add(li);
			return;
		}

		for (int j = i; j < A.size(); j++) {
			swap(A, i, j);
			solve(i + 1, A, result);
			swap(A, j, i);
		}
	}

	static void swap(List<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
