package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * Q3. Maximum Rectangle
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Input Format

The only argument given is the integer matrix A.
Output Format

Return the area of the largest rectangle containing only 1's.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1
 */
public class MaximumRectangleInMatrix {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList();
		A.add(Arrays.asList(new Integer[] { 0, 0, 1 }));
		A.add(Arrays.asList(new Integer[] { 0, 1, 1 }));
		A.add(Arrays.asList(new Integer[] { 1, 1, 1 }));
		System.out.println(solve(A));
	}

	public static int solve(ArrayList<List<Integer>> A) {

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				if (A.get(i).get(j) == 1 && i != 0) {
					A.get(i).set(j, A.get(i - 1).get(j) + 1);
				}
			}
			result = Math.max(result, findMaxAreainHistUsingCumulativeRow(A.get(i)));
		}
		return result;
	}

	private static int findMaxAreainHistUsingCumulativeRow(List<Integer> A) {
		// similar like largest rectangle in histogram
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> leftSmallerElments = new ArrayList<>();
		// finding out next left smaller elements index
		for (int i = 0; i < A.size(); i++) {
			while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				leftSmallerElments.add(-1);
			} else {
				leftSmallerElments.add(stack.peek());
			}

			stack.push(i);
		}

		stack = new Stack();
		ArrayList<Integer> rightSmallerElments = new ArrayList();
		for (int i = A.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				rightSmallerElments.add(A.size());
			} else {
				rightSmallerElments.add(stack.peek());
			}

			stack.push(i);
		}
		Collections.reverse(rightSmallerElments);

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < A.size(); i++) {
			int right = 0;
			right = rightSmallerElments.get(i) - 1;

			int left = 0;

			left = leftSmallerElments.get(i) + 1;
			ans = Math.max(ans, (right - left + 1) * A.get(i));
		}

		return ans;
	}

}
