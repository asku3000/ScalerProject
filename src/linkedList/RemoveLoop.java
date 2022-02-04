package linkedList;

/*
 * Q2. Remove Loop from Linked List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.



Problem Constraints

1 <= number of nodes <= 1000



Input Format

Only argument is the head of the linked list.



Output Format

return the head of the updated linked list.



Example Input

Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output

Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation

Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
 */
public class RemoveLoop {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head.next.next.next.next.next = head.next.next;

		ListNode ans = solve(head);
		while (ans != null) {
			System.out.print(ans.val + ",");
			ans = ans.next;
		}

	}

	public static ListNode solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;

		boolean isLoop = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				isLoop = true;
				break;
			}
		}

		if (!isLoop) {
			return null;
		}

		ListNode temp = A;
		ListNode ptr = fast;
		while (temp != ptr) {
			if (temp.next == ptr.next) {
				ptr.next = null;
				break;
			}
			temp = temp.next;
			ptr = ptr.next;

		}
		return A;
	}

}
