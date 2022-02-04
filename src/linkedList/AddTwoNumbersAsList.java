package linkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Q2. Add Two Numbers as Lists
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given two linked lists, A and B representing two non-negative numbers.

The digits are stored in reverse order and each of their nodes contain a single digit.

Add the two numbers and return it as a linked list.



Problem Constraints

1 <= |A|, |B| <= 105



Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the required linked list.



Example Input

Input 1:

 
 A = [2, 4, 3]
 B = [5, 6, 4]
Input 2:

 
 A = [9, 9]
 B = [1]


Example Output

Output 1:

 
 [7, 0, 8]
Output 2:

 
 [0, 0, 1]


Example Explanation

Explanation 1:

 A = 342 and B = 465. A + B = 807. 
Explanation 2:

 A = 99 and B = 1. A + B = 100. 

 */
public class AddTwoNumbersAsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a = Arrays.asList(new Integer[] { 9, 9, 1 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		List<Integer> a1 = Arrays.asList(new Integer[] { 1 });
		ListNode head1 = new ListNode(a1.get(0));
		ListNode temp1 = head1;
		for (int i = 1; i < a1.size(); i++) {
			temp1.next = new ListNode(a1.get(i));
			temp1 = temp1.next;
		}

		ListNode ans = addTwoNumbers(head, head1);
		while (true) {
			if (ans == null) {
				break;
			}
			System.out.print(ans.val + ",");
			ans = ans.next;
			if (ans == null) {
				break;
			}
		}

	}

	public static ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode ans = null;
		 ListNode prev = ans;
		int carry = 0;
		while (A != null || B != null) {

			int sum = (A != null ? A.val : 0) + (B != null ? B.val : 0) + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			if (ans == null) {
				ans = new ListNode(sum);
				prev = ans;
			} else {
				ans.next = new ListNode(sum);
				ans = ans.next;
			}
			if (A != null)
				A = A.next;
			if (B != null)
				B = B.next;

		}

		if (A == null && B == null && carry > 0) {
			ans.next = new ListNode(carry);
			ans = ans.next;
		}

		return prev;

	}

}
