package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class MapSumPairs {

	public static void main(String[] args) {
		List<String> A = Arrays.asList(new String[] { "apple", "ap", "app", "ap" });
		List<Integer> B = Arrays.asList(new Integer[] { 3, -1, 2, -1 });
		for (Integer i : solve(A, B)) {
			System.out.print(i + ",");
		}
	}

	static TrieNode root;
	static HashMap<String, Integer> map;
	static int sum;

	public static ArrayList<Integer> solve(List<String> A, List<Integer> B) {
		root = new TrieNode('$', new TrieNode[26], false, 0);
		map = new HashMap<String, Integer>();
		sum = 0;
		ArrayList<Integer> ans = new ArrayList();
		for (int i = 0; i < A.size(); i++) {
			// insertIn trie
			if (B.get(i) != -1) {
				insert(A.get(i));
				map.put(A.get(i), B.get(i));
			} else {
				// find prefixes
				int value = findWordsWithPrefix(A.get(i));
				ans.add(value);
			}
		}

		return ans;

	}

	private static int findWordsWithPrefix(String prefix) {
		// travel to last char of prefix
		TrieNode curr = root;
		String word = "";
		for (int i = 0; i < prefix.length(); i++) {
			int idx = prefix.charAt(i) - 'a';
			if (curr.children[idx] == null) {
				// no prefix
				return 0;
			}
			word += String.valueOf(curr.data);
			curr = curr.children[idx];
		}

		if (curr == null) {
			return 0;
		}
		word += String.valueOf(curr.data);
		word = word.replace("$", "");
		sum = 0;
		findSumUsingRecc(curr, word);
		return sum;
	}

	private static void findSumUsingRecc(TrieNode curr, String word) {
		if (curr == null) {
			return;
		}

		if (curr.isEnd == true) {
			sum+= map.get(word);
		}

		for (int i = 0; i < 26; i++) {
			if (curr.children[i] != null)
				findSumUsingRecc(curr.children[i], word + String.valueOf(curr.children[i].data));
		}
	}

	private static void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new TrieNode(word.charAt(i), new TrieNode[26], false, 0);
			}

			curr = curr.children[idx];
		}
		curr.isEnd = true;
	}

}
