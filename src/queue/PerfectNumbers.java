package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q1. Perfect Numbers
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints

1 <= A <= 100000



Input Format

The only argument given is an integer A.



Output Format

Return a string that denotes the Ath Perfect Number.



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 22
Output 2:

 1111


Example Explanation

Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221

 */
public class PerfectNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4));
	}

	public static String solve(int A) {
		ArrayList<String> list = new ArrayList();
		Queue<String> queue = new LinkedList();
		queue.add("1");
		queue.add("2");
		int i = 1;
		while (i <= A) {
			StringBuilder init = new StringBuilder(queue.poll());
			int j = 1;
			while (j <= 2) {
				queue.add(init.toString() + j);
				j++;
			}
			list.add(init.toString() + init.reverse().toString());
			i++;
		}

		return list.get(A - 1);
	}

}
