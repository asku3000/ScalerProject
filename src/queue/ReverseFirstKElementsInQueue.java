package queue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Q1. Reversing Elements Of Queue
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A and an integer B. We need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.

NOTE: You are required to first insert elements into an auxiliary queue then perform Reversal of first B elements.



Problem Constraints

1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000



Input Format

The argument given is the integer array A and an integer B.



Output Format

Return an array of integer after reversing the first B elements of A using queue.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 3
Input 2:

 A = [5, 17, 100, 11]
 B = 2


Example Output

Output 1:

 [3, 2, 1, 4, 5]
Output 2:

 [17, 5, 100, 11]


Example Explanation

Explanation 1:

 Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
Explanation 2:

 Reverse first 2 elements so the array becomes [17, 5, 100, 11]

 */
public class ReverseFirstKElementsInQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer i: solve(Arrays.asList(new Integer[] {43, 35, 25, 5, 34, 5, 8, 7 }), 6)) {
			System.out.print(i+",");
		}
	}

	public static List<Integer> solve(List<Integer> A, int B) {
		Stack<Integer> stack = new Stack();
		int i = 0;
		while (i < B) {
			stack.add(A.get(i));
			i++;
		}
		int j = 0;
		while (j < i) {
//			System.out.print(stack.pop() + ",");
			A.set(j, stack.pop());
			j++;
		}

		return A;
	}

}
