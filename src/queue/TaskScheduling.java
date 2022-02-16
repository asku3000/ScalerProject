package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				solve(Arrays.asList(new Integer[] { 2, 3, 1, 5, 4 }), Arrays.asList(new Integer[] { 1, 3, 5, 4, 2 })));
	}

	public static int solve(List<Integer> A, List<Integer> B) {
		Queue<Integer> a = new LinkedList<>();
		for (Integer i : A) {
			a.add(i);
		}

		Queue<Integer> b = new LinkedList<>();
		for (Integer i : B) {
			b.add(i);
		}

		int clockCycle = 0;
		while (!b.isEmpty()) {
			if (a.peek().equals(b.peek())) {
				a.poll();
				b.poll();
				clockCycle++;
			} else {
				int ele = a.poll();
				a.add(ele);
				clockCycle++;
			}
		}

		return clockCycle;
	}

}
