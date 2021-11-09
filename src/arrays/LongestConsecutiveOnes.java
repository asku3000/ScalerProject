package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LongestConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve("1101001100101110"));

	}

	public static int solve(String A) {
		ArrayList<Integer> a = new ArrayList();
		for (int i = 0; i < A.length(); i++) {
			a.add(Integer.parseInt(String.valueOf(A.charAt(i))));
		}

		ArrayList<Integer> left = new ArrayList();
		ArrayList<Integer> right = new ArrayList();
		int ans = 0;
		int totalOnes = 0;
		// left ko bhar ra h
		int countOfOnes = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).equals(0)) {
				countOfOnes = 0;
			} else {
				countOfOnes++;
				totalOnes++;
			}
			ans = Math.max(ans, countOfOnes);
			left.add(countOfOnes);
		}

		countOfOnes = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.get(i).equals(0)) {
				countOfOnes = 0;
			} else {
				countOfOnes++;
			}
			right.add(countOfOnes);
		}
		Collections.reverse(right);
		for (int i = 1; i < a.size() - 1; i++) {
			if (a.get(i) == 0) {
				ans = Math.max(ans, left.get(i - 1) + right.get(i + 1) + 1);
			}
		}

		return Math.min(totalOnes, ans);

	}

}
