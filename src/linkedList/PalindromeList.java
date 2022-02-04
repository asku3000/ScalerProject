package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Palindrome List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a singly linked list A, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.



Problem Constraints

1 <= |A| <= 105



Input Format

The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format

Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input

Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output

Output 1:

 1 
Output 2:

 0 


Example Explanation

Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

 */
public class PalindromeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a = Arrays.asList(new Integer[] { 8, 8, 8, 8 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		System.out.println(lPalin(head));

	}

	public static int lPalin(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;

		ListNode prevSlow = slow;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prevSlow = slow;
			slow = slow.next;
		}

		if (fast != null) {
			prevSlow.next = null;
			if (slow.next != null)
				slow = slow.next;
		}

		ListNode h2 = reverse(slow);

		while (h2 != null && A != null) {
			if (h2.val != A.val) {
				return 0;
			}

			h2 = h2.next;
			A = A.next;
		}

		return 1;
	}

	private static ListNode reverse(ListNode A) {
		// TODO Auto-generated method stub
		ListNode p1 = null;
		ListNode p2 = A;
		ListNode p3 = null;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		return p1;
	}

}
