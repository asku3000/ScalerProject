package problemsolving;

import java.util.Arrays;
import java.util.List;

public class NBy3RepeatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a = Arrays.asList(new Integer[] { 1000441, 1000441, 1000994 });
		System.out.println(repeatedNumber(a));

	}

	public static int repeatedNumber(final List<Integer> a) {

		int count1 = 0;
		int count2 = 0;

		Integer candidate1 = null;
		Integer candidate2 = null;

		for (Integer n : a) {

			if (candidate1 != null && candidate1.equals(n)) {
				count1++;
			} else if (candidate2 != null && candidate2.equals(n)) {
				count2++;
			} else if (count1 == 0) {
				count1++;
				candidate1 = n;
			} else if (count2 == 0) {
				count2++;
				candidate2 = n;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (Integer n : a) {

			if (candidate1 != null && candidate1.equals(n)) {
				count1++;
			}

			if (candidate2 != null && candidate2.equals(n)) {
				count2++;
			}

			if (count1 > a.size() / 3) {
				return candidate1;
			}
			if (count2 > a.size() / 3) {
				return candidate2;
			}

		}

		if (count1 > a.size() / 3) {
			return candidate1;
		} else if (count2 > a.size() / 3) {
			return candidate2;
		} else {
			return -1;
		}

	}

}
