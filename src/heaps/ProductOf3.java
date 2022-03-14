package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q3. Product of 3
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A of size N.

You have to find the product of the 3 largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i is -1.



Problem Constraints

1 <= N <= 105
0 <= A[i] <= 103



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [10, 2, 13, 4]


Example Output

Output 1:

 [-1, -1, 6, 24, 60]
Output 2:

 [-1, -1, 260, 520]


Example Explanation

Explanation 1:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].
 
Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].
 


See Expected Output
 */
public class ProductOf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] {11, 5, 6, 2, 8, 10 });
		for (Integer i : solve(A)) {
			System.out.println(i + ",");
		}
	}

	public static ArrayList<Integer> solve(List<Integer> A) {
		ArrayList<Integer> ans = new ArrayList();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		long product = 1;
		for (int i = 0; i < A.size(); i++) {
			
			if (i < 2) {
				minHeap.add(A.get(i));
				product *= A.get(i);
				ans.add(-1);
				continue;
			}
			if (i == 2) {
				minHeap.add(A.get(i));
				product *= A.get(i);
				ans.add((int) product);
				continue;
			}

			if (A.get(i) > minHeap.peek()) {
				int out = minHeap.poll();
				product = product / out;
				minHeap.add(A.get(i));
				product *= A.get(i);
			}

			ans.add((int) product);

		}

		return ans;
	}

}
