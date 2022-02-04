package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Delete middle node of a Linked List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null node should be returned.


Input Format

The only argument given is the node pointing to the head node of the linked list
 */
public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] { 46, 95, 96, 78 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}
		
		ListNode ans = solve(head);
		while(true) {
			System.out.print(ans.val+",");
			ans = ans.next;
			if(ans == null) {
				break;
			}
		}
//		System.out.println(ans.val);

	}

	public static ListNode solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		if (A == null) {
			return null;
		}
		
		if(A.next == null) {
			return null;
		}

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			if (fast.next == null) {
				slow.next = slow.next.next;
			} else
				slow = slow.next;

		}

		// for odd length
		if (fast.next != null && fast.next.next == null) {
			slow.next = slow.next.next;
			return A;
		}

		return A;
	}

}
