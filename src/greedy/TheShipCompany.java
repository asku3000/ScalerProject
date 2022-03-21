package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q3. The ship company
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

The local ship renting service has a special rate plan:

It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then goes the second one, and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.



Problem Constraints

1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.



Input Format

First argument is a integer A denoting the number of passengers in the queue.
Second arugument is a integer B deonting the number of ships.
Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.



Output Format

Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.



Example Input

Input 1:

 A = 4
 B = 3
 C = [2, 1, 1]
Input 2:

 A = 4
 B = 3
 C = [2, 2, 2]


Example Output

Output 1:

 [5, 5]
Output 2:

[7, 6]


Example Explanation

Explantion 1:

 Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 So, the cost will be 5.
 Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
 So, the cost will be 5.
Explanation 2:

 Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 So, the cost will be 7.
 Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
 So, the cost will be 6.
 */
public class TheShipCompany {

	public static void main(String[] args) {
		for (Integer i : solve(4, 3, Arrays.asList(new Integer[] { 2, 1, 1 }))) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(int A, int B, List<Integer> C) {
		int max = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int i = 0; i < C.size(); i++) {
			maxHeap.add(C.get(i));
		}

		for (int i = 0; i < A; i++) {
			max += maxHeap.peek();
			maxHeap.add(maxHeap.poll() - 1);
		}

		int min = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < C.size(); i++) {
			minHeap.add(C.get(i));
		}

		for (int i = 0; i < A; i++) {
			int smallEle = minHeap.poll();
			min += smallEle;
			if (smallEle - 1 != 0)
				minHeap.add(smallEle - 1);
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(max);
		ans.add(min);
		return ans;
	}

}
