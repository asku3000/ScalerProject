package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Shortest Unique Prefix
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a list of N words. Find shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is prefix of another. In other words, the representation is always possible



Problem Constraints

1 <= Sum of length of all words <= 106



Input Format

First and only argument is a string array of size N.



Output Format

Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input

Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output

Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]


Example Explanation

Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:

 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.

 */
public class ShortestUniquePrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> A = Arrays.asList(new String[] { "id", "qscdxrjmow", "rxsjybldbe", "sarcbyne", "dyggxxp", "lorel", "nmpa" });
		for (String s : prefix(A)) {
			System.out.println(s);
		}
	}

	static TrieNode root;

	public static ArrayList<String> prefix(List<String> A) {
		root = new TrieNode('$', new TrieNode[26], false, 2);
		createTrie(A);
		return findPrefixes(A);
	}

	private static void createTrie(List<String> a) {
		for (int i = 0; i < a.size(); i++) {
			TrieNode curr = root;
			for (int j = 0; j < a.get(i).length(); j++) {
				int idx = a.get(i).charAt(j) - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode(a.get(i).charAt(j), new TrieNode[26], false, 1);
				} else {
					curr.children[idx].freq++;
				}
				curr = curr.children[idx];
			}
			curr.isEnd = true;
		}

	}

	static ArrayList<String> findPrefixes( List<String> A) {
		ArrayList<String> ans = new ArrayList();
		for(int i=0;i<A.size();i++) {
			TrieNode curr = root;
			StringBuilder sb = new StringBuilder("");
			for(int j=0; j<A.get(i).length(); j++) {
				int idx = A.get(i).charAt(j)-'a';
				sb.append(curr.children[idx].data);
				if(curr.children[idx].freq == 1) {
					ans.add(sb.toString().replace("$", ""));
					break;
				}
				curr = curr.children[idx];
			}
		}
		return ans;
	}

}
