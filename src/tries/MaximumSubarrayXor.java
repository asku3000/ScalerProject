package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q2. Maximum XOR Subarray
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of integers of size N. Find the subarray AL, AL+1, AL+2, … AR with 1<=L<=R<=N which has maximum XOR value.

NOTE: If there are multiple subarrays with same maximum value, return the subarray with minimum length. If length is same, return the subarray with minimum starting index.



Problem Constraints

1 <= N <= 100000
0 <= A[i] <= 109



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.



Example Input

Input 1:

 A = [1, 4, 3]
Input 2:

 A = [8]


Example Output

Output 1:

 [2, 3]
Output 2:

 [1, 1]


Example Explanation

Explanation 1:

 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].
Explanation 2:

 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1]. 


 */
public class MaximumSubarrayXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 5, 2, 3, 4, 1 });
		for (Integer i : solve(A)) {
			System.out.print(i + ",");
		}
	}

	static BinaryTrieNode root;
	static int l, r;

	public static ArrayList<Integer> solve(List<Integer> A) {
		root = new BinaryTrieNode();
		l = 0;
		r = 0;
		// preXor Creation
		ArrayList<Integer> preXor = new ArrayList<Integer>();
		preXor.add(0);
		for (int i = 0; i < A.size(); i++) {
			preXor.add(A.get(i) ^ preXor.get(i));
		}

		long maxXor = 0;
		insertElement(preXor.get(0));
		for (int i = 0; i < preXor.size(); i++) {
			maxXor = Math.max(maxXor, findXor(preXor.get(i)));
			insertElement(preXor.get(i));
		}

		HashMap<Integer, Integer> map = new HashMap();
		int length = Integer.MAX_VALUE;
		map.put(preXor.get(0), 0);

		for (int i = 0; i < preXor.size(); i++) {

			long leftXor = maxXor ^ preXor.get(i);
			int lIndex = map.getOrDefault((int) leftXor, -2);
			if (lIndex != -2) {
				int subLength = i - lIndex;
				if (subLength < length) {
					length = subLength;
					l = lIndex + 1;
					r = i;
				}

			}

			map.put(preXor.get(i), i);

		}

		ArrayList<Integer> ans = new ArrayList<Integer>();

		ans.add(l);
		ans.add(r);
		return ans;
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

		for (int i = 31; i >= 0; i--) {
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
