package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q1. Running Median
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A denoting a stream of integers. New arrays of integer B and C are formed. Each time an integer is encountered in a stream, append it at the end of B and append median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements are N in B and N is odd then consider medain as B[N/2] ( B must be in sorted order).
If the number of elements are N in B and N is even then consider medain as B[N/2-1]. ( B must be in sorted order).


Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of first i elements.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation

Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 
 */
public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : solve(Arrays.asList(new Integer[] { 1, 2, 5, 4, 3 }))) {
			System.out.println(i + ",");
		}
	}

	public static ArrayList<Integer> solve(List<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

		for (int i = 0; i < A.size(); i++) {

			if (maxHeap.isEmpty()) {
				maxHeap.add(A.get(i));
				ans.add(A.get(i));
				continue;
			}

			if (A.get(i) < maxHeap.peek()) {
				maxHeap.add(A.get(i));

				if (maxHeap.size() - minHeap.size() > 1) {
					int max = maxHeap.poll();
					minHeap.add(max);
				}
			} else {
				minHeap.add(A.get(i));
				if (minHeap.size() > maxHeap.size()) {
					int min = minHeap.poll();
					maxHeap.add(min);
				}

			}

			ans.add(maxHeap.peek());

		}

		return ans;
	}

}
