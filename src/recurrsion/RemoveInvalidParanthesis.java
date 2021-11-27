package recurrsion;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveInvalidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String s : solve("()())()")) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> solve(String A) {
		int leftRemove = 0;
		int rightRemove = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '(') {
				leftRemove++;
			} else if (A.charAt(i) == ')') {
				if (leftRemove > 0) {
					leftRemove--;
				} else {
					rightRemove++;
				}
			}
		}
		String s = "";
		HashSet<String> resSet = new HashSet();
		int balance = 0;
		find(0, A, s, leftRemove, rightRemove, resSet, balance);
		return new ArrayList<String>(resSet);
	}

	private static void find(int i, String a, String s, int leftRemove, int rightRemove, HashSet<String> resSet,
			int balance) {
		if (i == a.length()) {
			if (leftRemove == 0 && rightRemove == 0) {
				resSet.add(s);
			}
		} else if (balance >= 0) {
			if (a.charAt(i) == '(' && leftRemove > 0) {
				find(i + 1, a, s, leftRemove - 1, rightRemove, resSet, balance);
			}
			if (a.charAt(i) == ')' && rightRemove > 0) {
				find(i + 1, a, s, leftRemove, rightRemove - 1, resSet, balance);
			}
			int diff = 0;
			if (a.charAt(i) == ')') {
				diff = -1;
			}
			if (a.charAt(i) == '(') {
				diff = 1;
			}
			find(i + 1, a, s + a.charAt(i), leftRemove, rightRemove, resSet, balance + diff);
		}
	}

}
