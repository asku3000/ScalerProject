package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * Q3. Largest Rectangle in Histogram
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format

The only argument given is the integer array A.



Output Format

Return the area of largest rectangle in the histogram.



Example Input

Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output

Output 1:

 10
Output 2:

 2


Example Explanation

Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				largestRectangleArea(Arrays.asList(new Integer[] { 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 })));
	}

	public static int largestRectangleArea(List<Integer> A) {
		Stack<Integer> stack = new Stack();
		ArrayList<Integer> leftSmallerElments = new ArrayList();
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
			// if(rightSmallerElments.get(i)!= 0) {
			right = rightSmallerElments.get(i) - 1;
			// }

			int left = 0;

			// if(leftSmallerElments.get(i) == A.size()-1) {
			// left = A.size()-1;
			// }else if(leftSmallerElments.get(i)!=0){
			left = leftSmallerElments.get(i) + 1;
			// }
			ans = Math.max(ans, (right - left + 1) * A.get(i));
		}

		return ans;

	}

}
