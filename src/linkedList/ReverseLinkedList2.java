package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q5. Reverse Link List II
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format

The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output

Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation

Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
 */
public class ReverseLinkedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		ListNode ans = reverseBetween(head, 1, 5);
		while (true) {
			System.out.print(ans.val + ",");
			ans = ans.next;
			if (ans == null) {
				break;
			}
		}
	}

	public static ListNode reverseBetween(ListNode A, int B, int C) {
		if (A.next == null) {
			return A;
		}
		int count = 0;
		ListNode temp = A;
		ListNode first = null;
		ListNode from = null;
		ListNode to = null;
		ListNode last = null;
		while (temp != null) {
			count++;
			if (count < B) {
				first = temp;
			}
			if (count == B) {
				from = temp;
			}
			if (count == C) {
				to = temp;
				last = to.next;
				to.next = null;
				break;
			}
			temp = temp.next;
		}

		ListNode p1 = null;
		ListNode p2 = from;
		ListNode p3 = null;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}

		if (first != null) {
			first.next = p1;
		} else {
			A = to;
		}
		from.next = last;

		return A;
	}

}
