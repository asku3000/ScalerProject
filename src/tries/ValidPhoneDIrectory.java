package tries;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q2. Valid Phone Directory!
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a phone directory in the form of string array A containing N numeric strings.

If any phone number is prefix of another phone number then phone directory is invalid else it is valid.

You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.



Problem Constraints

2 <= N <= 105

1 <= |A[i]| <= 50

A[i] consists only of numeric digits.



Input Format

First and only argument is an string array A.



Output Format

Return 1 if the given phone directory is valid else return 0.



Example Input

Input 1:

 A = ["1234", "2342", "567"]
Input 2:

 A = ["00121", "001"]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 No number is prefix of any other number so phone directory is valid so we will return 1.
Explanation 2:

 "001" is prefix of "00121" so phone directory is invalid so we will return 0.
 */
public class ValidPhoneDIrectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> A = Arrays.asList(new String[] { "5678", "5678" });
		System.out.println(solve(A));
	}

	static NumberTrieNode root;

	public static int solve(List<String> A) {
		Collections.sort(A, (String e1, String e2) -> {
			int l1 = e1.length();
			int l2 = e2.length();
			if (l1 == l2)
				return 0;
			if (l1 > l2)
				return 1;
			else
				return -1;
		});
		root = new NumberTrieNode('$', false);
		for (int i = 0; i < A.size(); i++) {
			if (insert(A.get(i))) {
				return 0;
			}
		}
		return 1;
	}

	private static boolean insert(String number) {
		NumberTrieNode curr = root;
		for (int i = 0; i < number.length(); i++) {
			int idx = number.charAt(i) - '0';
			if (curr.children[idx] == null) {
				curr.children[idx] = new NumberTrieNode(number.charAt(i), false);
			}

			if (curr.isEnd)
				return true;
			curr = curr.children[idx];
		}
		if (curr.isEnd) {
			return true;
		}
		curr.isEnd = true;
		return false;
	}
}

class NumberTrieNode {
	char data;
	boolean isEnd;
	NumberTrieNode children[];

	public NumberTrieNode(char data, boolean isEnd) {
		this.data = data;
		this.isEnd = isEnd;
		this.children = new NumberTrieNode[10];
	}

}
