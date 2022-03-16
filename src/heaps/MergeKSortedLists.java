package heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q4. Merge K Sorted Lists
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a list containing head pointers of N sorted linked lists. Merge these N given sorted linked lists and return it as one sorted list.



Problem Constraints

1 <= total number of elements in given linked lists <= 100000



Input Format

First and only argument is a list containing N head pointers.



Output Format

Return a pointer to the head of the sorted linked list after merging all the given linked lists.



Example Input

Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:

 10 -> 12
 13
 5 -> 6


Example Output

Output 1:

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:

 5 -> 6 -> 10 -> 12 ->13


Example Explanation

Explanation 1:

 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:

 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.


See Expected Output
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 1, 10, 20 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp1 = head;
		for (int i = 1; i < a.size(); i++) {
			temp1.next = new ListNode(a.get(i));
			temp1 = temp1.next;
		}

		List<Integer> b = Arrays.asList(new Integer[] { 4, 11, 13 });
		ListNode head1 = new ListNode(b.get(0));
		temp1 = head1;
		for (int i = 1; i < a.size(); i++) {
			temp1.next = new ListNode(b.get(i));
			temp1 = temp1.next;
		}

		List<Integer> c = Arrays.asList(new Integer[] { 3, 8, 9 });
		ListNode head2 = new ListNode(c.get(0));
		temp1 = head2;
		for (int i = 1; i < a.size(); i++) {
			temp1.next = new ListNode(c.get(i));
			temp1 = temp1.next;
		}

		List<ListNode> A = Arrays.asList(new ListNode[] { head, head1, head2 });

		ListNode ans = mergeKLists(A);
		while (ans != null) {
			System.out.print(ans.val+",");
			ans = ans.next;
		}

	}

	public static ListNode mergeKLists(List<ListNode> a) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new NodeComparator());

		for (int i = 0; i < a.size(); i++) {
			minHeap.add(a.get(i));
		}

		ListNode ans = new ListNode(-1);
		ListNode ptr = ans;

		while (!minHeap.isEmpty()) {
			ListNode top = minHeap.poll();
			ptr.next = top;
			ptr = ptr.next;
			if (ptr.next != null)
				minHeap.add(ptr.next);

		}

		return ans.next;

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

class NodeComparator implements Comparator<ListNode> {

	public int compare(ListNode k1, ListNode k2) {
		if (k1.val > k2.val)
			return 1;
		else if (k1.val < k2.val)
			return -1;
		return 0;
	}
}
