package linkedList;

import java.util.Arrays;
import java.util.List;

public class SwapListPairWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] { 46, 95, 96, 78 });
		ListNode head = new ListNode(a.get(0));
		ListNode temp = head;
		for (int i = 1; i < a.size(); i++) {
			temp.next = new ListNode(a.get(i));
			temp = temp.next;
		}
		
		ListNode ans = swapPairs(head);
		while(true) {
			System.out.print(ans.val+",");
			ans = ans.next;
			if(ans == null) {
				break;
			}
		}
	}
	
	public static ListNode swapPairs(ListNode A) {
        if(A == null){
            return null;
        }

        ListNode curr = A;
        while(curr != null && curr.next!= null){
            ListNode h2 = curr.next.next;
            curr.next.next = curr;
            curr.next = h2;
            curr = curr.next;
            if(h2 != null && h2.next!= null)
                h2 = h2.next.next;
        }

        return A;

    }

}
