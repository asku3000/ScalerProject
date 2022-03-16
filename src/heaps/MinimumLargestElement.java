package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q1. Minimum largest element
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add original value(value stored at index before we did any operations) to it's current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimised. Find the minimum possible largest element after B operations.



Problem Constraints

1 <= N <= 106
0 <= B <= 105
-105 <= A[i] <= 105



Input Format

First argument is an integer array A.
Second argument is an integer B.



Output Format

Return an integer denoting the minimum possible largest element after B operations.



Example Input

Input 1:

 A = [1, 2, 3, 4] 
 B = 3
Input 2:

 A = [5, 1, 4, 2] 
 B = 5


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.


 */
public class MinimumLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 5, 1, 4, 2 }), 5));
	}

	public static int solve(List<Integer> A, int B) {
		PriorityQueue<PairMinimum> minHeap = new PriorityQueue<PairMinimum>(new PairMinimumComparator());
		ArrayList<Integer> currState = new ArrayList<Integer>(A);

		for (int i = 0; i < A.size(); i++) {
			minHeap.add(new PairMinimum(2*A.get(i), i));
		}

		while (B > 0) {
			PairMinimum top = minHeap.poll();
			currState.set(top.index, top.value);
			minHeap.add(new PairMinimum(A.get(top.index) + top.value, top.index));
			B--;
		}

		int maxAns = currState.get(0);
		for (int i = 0; i < currState.size(); i++) {
			maxAns = Math.max(maxAns, currState.get(i));
		}

		return maxAns;
	}

}

class PairMinimum {
	int value;
	int index;

	public PairMinimum(int value, int index) {
		this.value = value;
		this.index = index;
	}

}

class PairMinimumComparator implements Comparator<PairMinimum> {

	@Override
	public int compare(PairMinimum o1, PairMinimum o2) {
		if (o1.value > o2.value)
			return 1;
		if (o1.value == o2.value)
			return 0;
		else
			return -1;
	}

}
