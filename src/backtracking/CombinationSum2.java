package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Combination Sum II
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.



Problem Constraints

1 <= N <= 20



Input Format

First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.



Output Format

Return all unique combinations in A where the candidate numbers sums to B.



Example Input

Input 1:

 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
Input 2:

 A = [2, 1, 3]
 B = 3


Example Output

Output 1:

 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]
Output 2:

 [
  [1, 2 ],
  [3 ]
 ]


Example Explanation

Explanation 1:

 1 + 1 + 6 = 8
 1 + 2 + 5 = 8
 1 + 7 = 8
 2 + 6 = 8
 All the above combinations sum to 8 and are arranged in ascending order.
Explanation 2:

 1 + 2 = 3
 3 = 3
 All the above combinations sum to 3 and are arranged in ascending order.
 */
public class CombinationSum2 {

	public static void main(String[] args) {
		for (ArrayList<Integer> li : combinationSum(Arrays.asList(new Integer[] { 10, 1, 2, 7, 6, 1, 5 }), 8)) {
			System.out.println(" ");
			for (Integer i : li) {
				System.out.print(i + " ");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		int sum = 0;
		int i = 0;
		find(i, sum, A, B, curr, result);
		return result;
	}

	private static void find(int i, int sum, List<Integer> a, int b, ArrayList<Integer> curr,
			ArrayList<ArrayList<Integer>> result) {
		if (sum > b) {
			return;
		}

		if (sum == b) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}

		if (i >= a.size()) {
			return;
		}

		int x = i;
		while (x < a.size() && a.get(i).equals(a.get(x))) {
			// rejecting jo same h for unselcting part
			x++;
		}

		// reject
		find(x, sum, a, b, curr, result);

		// select
		curr.add(a.get(i));// do
		sum += a.get(i);// do
		find(i + 1, sum, a, b, curr, result);
		curr.remove(curr.size() - 1);
		sum -= a.get(i);

	}

}
