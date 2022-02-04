package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q3. Reorder List
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints

1 <= |A| <= 106



Input Format

The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output

Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation

Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].


 */
public class ReorderList {

	public static void main(String[] args) {

		List<Integer> a = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		ListNode ans = reorderList(head);
		while (ans != null) {
			System.out.print(ans.val + ",");
			ans = ans.next;
		}
	}

	 public static ListNode reorderList(ListNode A) {
	        ListNode m = middle(A);
	        ListNode secondHead = m.next;
	        m.next = null;
	        secondHead = reverse(secondHead);
	        ListNode firstHead = A;
	        return merge(firstHead, secondHead);
	    }

	    static ListNode middle(ListNode A){
	       ListNode slow = A;
			ListNode fast = A;
			if (A == null) {
				return null;
			}

			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			//for odd length
			if(fast.next != null && fast.next.next == null) {
				return slow.next;
			}

			return slow;
	    }

	    static ListNode reverse(ListNode A){
	        ListNode p1 = null;
	        ListNode p2 = A;
	        ListNode p3 = null;
	        while(p2!=null){
	            p3 = p2.next;
	            p2.next = p1;
	            p1 = p2;
	            p2 = p3;
	        }

	        return p1;
	    }

	    static ListNode merge(ListNode head1, ListNode head2){
	        ListNode curr = head1;
	        ListNode temp = null;
	        while(head2 != null){
	            temp = head2;
	            head2 = head2.next;
	            temp.next = curr.next;
	            curr.next = temp;
	            curr = curr.next.next;
	        }

	        return head1;
	    }

}
