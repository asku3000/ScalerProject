package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q4. Middle element of linked list
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a linked list of integers. Find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints

1 <= length of the linked list <= 100000

1 <= Node value <= 109



Input Format

The only argument given head pointer of linked list.



Output Format

Return the middle element of the linked list.



Example Input

Input 1:

 1 , 2 , 3 , 4 , 5
Input 2:

 1 , 5 , 6 , 2 , 3 , 4


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.

 */
public class MiddleElementOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] { 14, 42, 98, 26, 36, 28, 57});
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		System.out.println(solve(head));
	}

	public static int solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		if (A == null) {
			return 0;
		}

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//for odd length
		if(fast.next != null && fast.next.next == null) {
			return slow.next.val;
		}

		return slow.val;
	}

}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
