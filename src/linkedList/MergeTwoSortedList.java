package linkedList;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Merge Two Sorted Lists
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Merge two sorted linked lists A and B and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.



Problem Constraints

0 <= |A|, |B| <= 105



Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the merged linked list.



Example Input

Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output

Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3


Example Explanation

Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 
Explanation 2:

 We don't need to merge as B is empty. 

 */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a = Arrays.asList(new Integer[] { 46, 95, 96, 78 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}
		
		List<Integer> a1 = Arrays.asList(new Integer[] { 5, 55, 73, 100 });
		ListNode head2 = new ListNode(a.get(0));
		ListNode temp2 = head2;
		for (int i = 1; i < a1.size(); i++) {
			temp2.next = new ListNode(a1.get(i));
			temp2 = temp2.next;
		}
		
		ListNode ans = mergeTwoLists(head, head2);
		while(true) {
			System.out.print(ans.val+",");
			ans = ans.next;
			if(ans == null) {
				break;
			}
		}
	}
	
	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h3 = new ListNode(-1);
        ListNode temp = h3;
        while(A != null && B!= null){
            if(A.val<B.val){
                temp.next = A;
                temp = temp.next;
                A = A.next;
                temp.next = null;
            }else{
                temp.next = B;
                temp = temp.next;
                B = B.next;
                temp.next = null;
            }
        }
        if(A != null){
            temp.next = A;
        }
        if( B != null){
            temp.next = B;
        }

        return h3.next;
    }

}
