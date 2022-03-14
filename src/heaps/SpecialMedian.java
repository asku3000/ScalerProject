package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q3. Special Median
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
Median is the middle element in the sorted list of elements. If the number of elements are even then median will be (sum of both middle elements)/2.

Return 1 if the array is special else return 0.

NOTE:

For A[0] consider only the median of elements [A[1], A[2], …, A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], …., A[N-2]]


Problem Constraints

1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.



Input Format

First and only argument is an integer array A.



Output Format

Return 1 if the given array is special else return 0.



Example Input

Input 1:

 A = [4, 6, 8, 4]
Input 2:

 A = [2, 7, 3, 1]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explantion 1:

 Here, 6 is equal to the median of [8, 4].
Explanation 2:

 No element satisfies any condition.

 */
public class SpecialMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] {4, 6, 8, 4})));
	}

	public static int solve(List<Integer> A) {

		ArrayList<Double> leftMedians = getMedian(A);

		for (int i = 1; i < A.size(); i++) {
			if (leftMedians.get(i - 1) == (double) A.get(i)) {
				return 1;
			}
		}
		
		Collections.reverse(A);
		ArrayList<Double> rightMedians = getMedian(A);
		
		for (int i = 1; i < A.size(); i++) {
			if (rightMedians.get(i - 1) == (double) A.get(i)) {
				return 1;
			}
		}
		
		return 0;

	}

	private static ArrayList<Double> getMedian(List<Integer> A) {
		ArrayList<Double> ans = new ArrayList<>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

		for (int i = 0; i < A.size(); i++) {

			if (maxHeap.isEmpty()) {
				maxHeap.add(A.get(i));
				ans.add((double) A.get(i));
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

			if (maxHeap.size() == minHeap.size()) {
				ans.add(((double)maxHeap.peek() + minHeap.peek()) / 2);
			} else {
				ans.add((double) maxHeap.peek());
			}

		}

		return ans;
	}

}
