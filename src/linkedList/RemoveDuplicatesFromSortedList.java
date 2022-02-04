package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. Remove Duplicates from Sorted List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.



Problem Constraints

0 <= length of linked list <= 106



Input Format

First argument is the head pointer of the linked list.



Output Format

Return the head pointer of the linked list after removing all duplicates.



Example Input

Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output

Output 1:

 1->2
Output 2:

 1->2->3


Example Explanation

Explanation 1:

 Each element appear only once in 1->2.


 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		ListNode ans = deleteDuplicates(head);
		while (ans != null) {
			System.out.print(ans.val + ",");
			ans = ans.next;
		}

	}

	public static ListNode deleteDuplicates(ListNode A) {
		if (A == null) {
			return null;
		}

		ListNode temp = A;
		while (temp != null) {

			if (temp.next != null && temp.next.val == temp.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}

		return A;
	}

}
