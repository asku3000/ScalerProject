package tries;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. Modified Search
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

NOTE: modification is defined as converting a character into another character.



Problem Constraints

1 <= N <= 30000

1 <= M <= 2500

1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets



Input Format

First argument is the string arrray A.

Second argument is the string array B.



Output Format

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification in B[i], Else C[i] = '0'.



Example Input

Input 1:

 A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]
Input 2:

 A = [hello, world]
 B = [hella, pello, pella]


Example Output

Output 1:

 "10100"
Output 2:

 "110"


Example Explanation

Explanation 1:

 1. date = dat*(can be found in A)
 2. circel =(cannot be found in A using exactly one modification)
 3. crikket = cri*ket(can be found in A)
 4. data = (cannot be found in A using exactly one modification)
 5. circl = (cannot be found in A using exactly one modification)
Explanation 2:

 Only pella cannot be found in A using only one modification.

 */
public class ModifiedSearch {

	public static void main(String[] args) {
		List<String> A = Arrays.asList(new String[] { "data", "circle", "cricket" });
		List<String> B = Arrays.asList(new String[] { "date", "circel", "crikket", "data", "circl" });
		System.out.println(solve(A, B));

	}

	static TrieNode root;

	public static String solve(List<String> A, List<String> B) {
		root = new TrieNode('$', new TrieNode[26], false, 0);
		createTrie(A);

		StringBuilder ans = new StringBuilder("");
		for (int i = 0; i < B.size(); i++) {
			TrieNode curr = root;
			if (find(curr, B.get(i), 0, 0, false)) {
				ans.append("1");
			} else {
				ans.append("0");
			}
		}

		return ans.toString();
    }


    private static boolean find(TrieNode curr, String key, int i, int miss, boolean isEnd) {
		boolean ans = false;
		if (curr == null) {
			return false;
		}

		if (i == key.length()) {
			if (miss == 1 && isEnd) {
				return true;
			}

			return false;
		}

		char ch = key.charAt(i);

		if (miss == 0) {
			for (int j = 0; j < 26; j++) {
				if (curr.children[j] != null)
					if (curr.children[j].data == ch) {
						ans = ans || find(curr.children[j], key, i + 1, miss, curr.children[j].isEnd);
					} else {
						ans = ans || find(curr.children[j], key, i + 1, miss + 1, curr.children[j].isEnd);
					}
                
			}
		} else {
			for (int j = 0; j < 26; j++) {
				if (curr.children[j] != null && ch == curr.children[j].data ) {
					ans = ans || find(curr.children[j], key, i + 1, miss, curr.children[j].isEnd);
				}
			}
		}

		return ans;
	}

	private static void createTrie(List<String> A) {
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
