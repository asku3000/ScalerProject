package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Q2. Number of Squareful Arrays
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints

1 <= length of the array <= 12

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the number of permutations of A that are squareful.



Example Input

Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1].


 */
public class SquarefullArrays {

	public static void main(String[] args) {
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 17, 8 })));
	}

	static int count = 0;

	public static int solve(List<Integer> A) {
		count = 0;
		if (A.size() == 1) {
			return 0;
		}
		find(A, 0);
		return count;
	}

	static void find(List<Integer> A, int i) {

		if (i == A.size()) {
			// if (isSquareFul(i))
			count++;
			return;
		}
		HashSet<Integer> visited = new HashSet();
		for (int j = i; j < A.size(); j++) {
			if (i != j && A.get(i) == A.get(j)) {
				continue;
			}
			swap(A, i, j); // do

			if ((i == 0 || (i > 0 && isSquareFul(A.get(i - 1) + A.get(i)))) && !visited.contains(A.get(i))) {
				find(A, i + 1); // recursion
				visited.add(A.get(i));
			}
			swap(A, j, i); // undo

		}
	}

	static boolean isSquareFul(int i) {
		int t = (int) Math.floor(Math.sqrt(i));
		return (t * t) == i;
	}

	static void swap(List<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
