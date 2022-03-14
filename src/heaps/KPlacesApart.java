package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q2. K Places Apart
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given N persons with different priorities standing in a queue.

Queue is following a property that Each person is standing atmost B places away from it's sorted position.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).


Problem Constraints

1 <= N <= 100000
0 <= B <= N



Input Format

First argument is an integer array A representing the priorities of N persons.
Second argument is an integer B.



Output Format

Return an integer array representing the sorted queue.



Example Input

Input 1:

 A = [1, 40, 2, 3]
 B = 2
Input 2:

 A = [2, 1, 17, 10, 21, 95]
 B = 1


Example Output

Output 1:

 [1, 2, 3, 40]
Output 2:

 [1, 2, 10, 17, 21, 95]


Example Explanation

Explanation 1:

 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
Explanation 2:

 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
 */
public class KPlacesApart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : solve(Arrays.asList(new Integer[] { 1, 40, 2, 3 }), 2)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(List<Integer> A, int B) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i=0; i<=B; i++) {
			minHeap.add(A.get(i));
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i=B+1; i<A.size(); i++) {
			ans.add(minHeap.poll());
			minHeap.add(A.get(i));
		}
		
		while(!minHeap.isEmpty()) {
			ans.add(minHeap.poll());
		}
		
		return ans;
	}

}
