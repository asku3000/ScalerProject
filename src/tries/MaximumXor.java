package tries;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Maximum XOR
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.



Problem Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer denoting the maximum result of A[i] XOR A[j].



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 7
Output 2:

 117


Example Explanation

Explanation 1:

 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
Explanation 2:

 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */
public class MaximumXor {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 5, 17, 100, 11 });
		System.out.println(solve(A));
	}

	static BinaryTrieNode root;

	public static int solve(List<Integer> A) {
		root = new BinaryTrieNode();
		if (A.size() > 0) {
			insertElement(A.get(0));
		}

		long ans = 0;
		for (int i = 0; i < A.size(); i++) {
			ans = Math.max(ans, findXor(A.get(i)));
			insertElement(A.get(i));
		}

		return (int) ans;
	}

	private static int findXor(Integer ele) {
		long currAns = 0;
		BinaryTrieNode curr = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (ele >> i) & 1;
			if (bit == 0) {
				if (curr.one != null) {
					curr = curr.one;
					currAns += (1 << i);
				} else {
					curr = curr.zero;
				}
			} else {
				if (curr.zero != null) {
					curr = curr.zero;
					currAns += (1 << i);
				} else {
					curr = curr.one;
				}
			}
		}

		return (int) currAns;
	}

	private static void insertElement(Integer ele) {
		BinaryTrieNode curr = root;

		for (int i = 31; i >=0; i--) {
			int bit = (ele >> i) & 1;
			if (bit == 0) {
				if (curr.zero == null) {
					curr.zero = new BinaryTrieNode();
				}
				curr = curr.zero;
			} else {
				if (curr.one == null) {
					curr.one = new BinaryTrieNode();
				}

				curr = curr.one;
			}
		}

	}

}

class BinaryTrieNode {
	BinaryTrieNode zero;
	BinaryTrieNode one;

}
