package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q4. Kth Smallest Element in a Sorted Matrix
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A are sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.



Problem Constraints

1 <= N, M <= 500

1 <= A[i] <= 109

1 <= B <= N * M



Input Format

The first argument given is the integer matrix A.
The second argument given is an integer B.



Output Format

Return the B-th smallest element in the matrix.



Example Input

Input 1:

 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:

 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12


Example Output

Output 1:

 17
Output 2:

 16


Example Explanation

Explanation 1:

 6th smallest element in the sorted matrix is 17.
Explanation 2:

 12th smallest element in the sorted matrix is 16.


 */
public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();

		A.add(Arrays.asList(new Integer[] { 5, 6 }));
		A.add(Arrays.asList(new Integer[] { 9, 12 }));
		A.add(Arrays.asList(new Integer[] { 11, 14 }));
		A.add(Arrays.asList(new Integer[] { 12, 15}));
		A.add(Arrays.asList(new Integer[] { 14, 17 }));
		A.add(Arrays.asList(new Integer[] { 16, 18}));

		System.out.println(solve(A, 10));

	}

	public static int solve(ArrayList<List<Integer>> A, int B) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int b = B;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size() && B > 0; j++, B--) {
				maxHeap.add(A.get(i).get(j));
			}
		}
		int row = b / A.get(0).size();
		int col = b % (A.get(0).size());
//		row--;
		for (int i = row; i < A.size() && i < row+1; i++) {

			for (int j = col; j < A.get(0).size(); j++) {
				if (maxHeap.peek() > A.get(i).get(j)) {
					maxHeap.poll();
					maxHeap.add(A.get(i).get(j));
				}
			}
		}

		for (int i = row + 1; i < A.size(); i++) {

			for (int j = 0; j < A.get(0).size(); j++) {
				if (maxHeap.peek() > A.get(i).get(j)) {
					maxHeap.poll();
					maxHeap.add(A.get(i).get(j));
				}
			}
		}

		return maxHeap.peek();
	}

}
