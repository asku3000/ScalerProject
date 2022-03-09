package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q1. Map Sum Pairs!
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Rishabh was sitting ideally in his office and then suddenly his boss gave him some operations to perform.

You being his friend tried to help him in finishing the task fast.

So you have to perform Q operation of two types:

Operation 1: INSERT : You are given an pair of (string, integer).The string represents the key and the integer represents the value. Insert the key-value pair in the hash and If the key already exists in hash, then the original key-value pair will be overridden to the new one.
Operation 2: SUM : you'll be given an pair of (string, -1) where string representing the prefix, and you need to return the sum of all the pairs' value in the hash whose key starts with the prefix.


Problem Constraints

1 <= Q <= 103

1 <= Length of string in any operation <= 30

Strings in each operations only consists of lowercase characters.

1 <= Integer in Operation 1 <= 100

Integer in operation 2 is always -1 so this parameter will help you in distinguishing between the two opearations.



Input Format

First argument is an string array A of size Q denoting the first parameter of each operations.

Seond argument is an integer array B of size Q denoting the second parameter of each operations.

NOTE: ith query will be like (A[i], B[i])



Output Format

Return an integer array denoting the answer for each operation of type: 2



Example Input

Input 1:

 A = ["apple", "ap", "app", "ap"]
 B = [3, -1, 2, -1]
Input 2:

 A = ["ban", "banana", "ba"]
 B = [10, -1, -1]


Example Output

Output 1:

 [3, 5]
Output 2:

 [0, 10]


Example Explanation

Explanation 1:

 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "apple" in our hash and store its value as 3.
 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ap". Only "apple" has its prefix as "ap" so we will return 3
 3. (A[2], B[2]) is a type-1 operation as B[2] != -1 so we will insert "app" in our hash and store its value as 2.
 4. (A[3], B[3]) is a type-2 operation as B[3] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ap". So both ["apple", "app"] has its prefix as "ap" so we will return 3 + 2 i.e 5
Explanation 2:

 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "ban" in our hash and store its value as 10.
 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "banana". So there doesn't exist any string whose prefix is "banana" so we will return 0
 3. (A[2], B[2]) is a type-2 operation as B[2] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ba". Only "ban" has its prefix as "ba" so we will return 10.

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
