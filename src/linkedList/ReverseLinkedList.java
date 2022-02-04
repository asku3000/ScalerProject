package linkedList;

import java.util.Arrays;
import java.util.List;

/*Q3. Reverse Linked List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

NOTE: You have to do it in-place and in one-pass.



Problem Constraints

1 <= Length of linked list <= 105

Value of each node is within the range of a 32-bit integer.



Input Format

First and only argument is a linked-list node A.



Output Format

Return a linked-list node denoting the head of the reversed linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
Input 2:

 A = 3 -> NULL 


Example Output

Output 1:

 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
Output 2:

 3 -> NULL 


Example Explanation

Explanation 1:

 The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
Expalantion 2:

 The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL 

*/
public class ReverseLinkedList {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 46, 95, 96 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		ListNode ans = reverseList(head);
		while(true) {
			System.out.print(ans.val+",");
			ans = ans.next;
			if(ans == null) {
				break;
			}
		}

	}

	public static ListNode reverseList(ListNode A) {
		
		ListNode p1 = null;
		ListNode p2 = A;
		ListNode p3 = null;
		while(p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		
		return p1;
	}

}
