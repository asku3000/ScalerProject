package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q1. Spelling Checker
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.



Problem Constraints
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000



Input Format
First argument is array of strings A.

First argument is array of strings B.



Output Format
Return the binary array of integers according to the given format.



Example Input
Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output
Output 1:

[1, 0]
Output 2:

[0, 0]


Example Explanation
Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.
 * @author ASHISH KUMAR
 *
 */
public class SpellingChecker {

	public static void main(String[] args) {
		List<String> A = Arrays.asList(new String[] { "hat", "cat", "rat" });
		List<String> B = Arrays.asList(new String[] { "cat", "ball" });
		for (Integer i : solve(A, B)) {
			System.out.print(i + ",");
		}
	}

	static TrieNode root;

	public static ArrayList<Integer> solve(List<String> A, List<String> B) {
		root = new TrieNode('$', new TrieNode[26], false, 0);
		createTrie(root, A);
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < B.size(); i++) {
			TrieNode curr = root;
			if (checkWordInDic(B.get(i), curr)) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}
		return ans;
	}

	private static boolean checkWordInDic(String word, TrieNode curr) {
		for (int j = 0; j < word.length(); j++) {
			int idx = word.charAt(j) - 'a';
			if (curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		if (curr.isEnd == true) {
			return true;
		} else {
			return false;
		}
	}

	private static void createTrie(TrieNode r, List<String> A) {
		for (int i = 0; i < A.size(); i++) {
			TrieNode curr = root;
			for (int j = 0; j < A.get(i).length(); j++) {
				int idx = A.get(i).charAt(j) - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode(A.get(i).charAt(j), new TrieNode[26], false, 0);
				}
				curr = curr.children[idx];
			}
			curr.isEnd = true;
		}
	}

}
