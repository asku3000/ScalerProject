package recurrsion;

import java.util.ArrayList;

public class Paranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(2));
	}

	public static ArrayList<String> generateParenthesis(int A) {
		int open = 0;
		int close = 0;
		ArrayList<String> result = new ArrayList();
		String s = "";
		solve(A, s, open, close, result);
		return result;
	}

	static void solve(int a, String s, int open, int close, ArrayList<String> result) {
		// TODO Auto-generated method stub
		if (s.length() == 2 * a) {
			result.add(s.toString());
			return;
		}

		if (open < a)
			solve(a, s + "(", open + 1, close, result);

		if (close < open)
			solve(a, s + ")", open, close + 1, result);

	}

}
