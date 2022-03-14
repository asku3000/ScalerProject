package heaps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q4. Maximum array sum after B negations
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



Problem Constraints

1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format

First argument given is an integer array A.
Second argument given is an integer B.



Output Format

Return an integer denoting the maximum array sum after B modifications.



Example Input

Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output

Output 1:

 196
Output 2:

 362


Example Explanation

Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */
public class MaximumArraySumAfterBNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] {24, -68, -29, -9, 84});
		System.out.println(solve(A, 4));
	}

	public static int solve(List<Integer> A, int B) {
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		for (int i = 0; i < A.size(); i++) {
			minHeap.add(A.get(i));
		}

		for (int i = B; i > 0; i--) {
			int min = minHeap.poll();
			minHeap.add(-min);
		}

		Iterator<Integer> itr = minHeap.iterator();
		long sum = 0;
		while (itr.hasNext()) {
			sum += itr.next();
		}

		return (int) sum;
	}

}
