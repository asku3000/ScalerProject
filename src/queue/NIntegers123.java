package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q2. N integers containing only 1, 2 & 3
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.

NOTE: All the A integers will fit in 32 bit integer.



Problem Constraints

1 <= A <= 29500



Input Format

The only argument given is integer A.



Output Format

Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input

Input 1:

 A = 3
Input 2:

 A = 7


Example Output

Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation

Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

 */
public class NIntegers123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : solve(7)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(int A) {
		Queue<Integer> queue = new LinkedList();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		ArrayList<Integer> ans = new ArrayList();
		int i = 1;
		while (i <= 3 && i <= A) {
			ans.add(i);
			i++;
		}
		
		while (i <= A) {
			int front = queue.poll();
			int j = 1;
			while (j <= 3 && i <= A) {
				ans.add(Integer.parseInt("" + front + j));
				queue.add(Integer.parseInt("" + front + j));
				j++;
				i++;
			}
		}

		return ans;
	}

}
