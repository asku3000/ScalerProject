package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Q2. Evaluate Expression
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

An arithmetic expression is given by a charater array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints

1 <= N <= 105



Input Format

The only argument given is character array A.



Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output

Output 1:
    9
Output 2:
    6


Example Explanation

Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    1 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluatePostFix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evalRPN(Arrays.asList(new String[] { "4", "13", "5", "/", "+" })));
	}

	public static int evalRPN(List<String> A) {
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < A.size(); i++) {
			int first = 0, second = 0;
			switch (A.get(i)) {
			case "+":
				second = stack.pop();
				first = stack.pop();
				stack.push(first + second);
				break;
			case "-":
				second = stack.pop();
				first = stack.pop();
				stack.push(first - second);
				break;
			case "*":
				second = stack.pop();
				first = stack.pop();
				stack.push(first * second);
				break;
			case "/":
				second = stack.pop();
				first = stack.pop();
				stack.push(first / second);
				break;
			default:
				stack.push(Integer.parseInt(A.get(i)));
				break;
			}
		}
		return stack.peek();
	}

}
