package stacks;

import java.util.Stack;

/*
 * Q2. Infix to Postfix
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given string A denoting an infix expression. Convert the infix expression into postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints

1 <= length of the string <= 500000



Input Format

The only argument given is string A.



Output Format

Return a string denoting the postfix conversion of A.



Example Input

Input 1:

 A = "x^y/(a*z)+b"
Input 2:

 A = "a+b*(c^d-e)^(f+g*h)-i"


Example Output

Output 1:

 "xy^az*'/b+" //ignore '
Output 2:

 "abcd^e-fgh*+^*+i-"


Example Explanation

Explanation 1:

 Ouput dentotes the postfix expression of the given input.
 */
public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("x^y/(a*z)+b"));
	}

	public static String solve(String A) {
		Stack<Character> stack = new Stack();
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);

			if (Character.isLetterOrDigit(ch)) {
				sb.append(String.valueOf(ch));
			} else if (ch == '(') {
				stack.push('(');
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
					sb.append(String.valueOf(stack.pop()));
				}
				stack.push(ch);
			}

		}

		while (!stack.isEmpty()) {
			sb.append(String.valueOf(stack.pop()));
		}

		return sb.toString();
	}

	static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

}
