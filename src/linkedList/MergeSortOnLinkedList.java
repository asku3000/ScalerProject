package linkedList;

import java.util.Arrays;
import java.util.List;

public class MergeSortOnLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] { 78, 34, 56, 2, 66, 32, 1, 6, 91, 100 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}

		ListNode ans = sortList(head);
		while (true) {
			System.out.print(ans.val + ",");
			ans = ans.next;
			if (ans == null) {
				break;
			}
		}
	}

	public static ListNode sortList(ListNode A) {

		if (A == null) {
			return null;
		}

		if (A.next == null) {
			return A;
		}

		ListNode m = middle(A);
		ListNode h2 = m.next;
		m.next = null;

		A = sortList(A);
		h2 = sortList(h2);
		return mergeTwoLists(A, h2);
	}

	static ListNode middle(ListNode h1) {
		ListNode slow = h1;
		ListNode fast = h1;
		if (fast == null || fast.next == null) {
			return slow;
		}
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// if(fast != null && fast.next != null){
		// slow = slow.next;
		// }
		return slow;
	}

	static ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode h3 = new ListNode(-1);
		ListNode temp = h3;
		while (A != null && B != null) {
			if (A.val < B.val) {
				temp.next = A;
				temp = temp.next;
				A = A.next;
				temp.next = null;
			} else {
				temp.next = B;
				temp = temp.next;
				B = B.next;
				temp.next = null;
			}
		}
		if (A != null) {
			temp.next = A;
		}
		if (B != null) {
			temp.next = B;
		}

		return h3.next;
	}

}
