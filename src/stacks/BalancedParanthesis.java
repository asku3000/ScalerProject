package stacks;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("{([])}"));
	}

	public static int solve(String A) {
		Stack<Character> stack = new Stack();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else {
				if ((c == '}' && '{' == stack.peek()) || (c == ']' && '[' == stack.peek())
						|| (c == ')' && '(' == stack.peek())) {
					stack.pop();
				} else {
					return 0;
				}
			}
		}

		if (stack.isEmpty()) {
			return 1;
		}

		return 0;
	}

}
