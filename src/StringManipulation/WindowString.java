package StringManipulation;

import java.util.HashMap;

/*
 * Q3. Window String
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )


Problem Constraints

1 <= size(A), size(B) <= 106



Input Format

First argument is a string A.
Second argument is a string B.



Output Format

Return a string denoting the minimum window.



Example Input

Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output

Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation

Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.
 */
public class WindowString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(minWindow("Aa91b", "ab"));
	}

	public static String minWindow(String A, String B) {
		 HashMap<Character, Integer> map = new HashMap();
			for (int i = 0; i < B.length(); i++) {
				if (map.get(B.charAt(i)) == null) {
					map.put(B.charAt(i), 1);
				} else {
					map.put(B.charAt(i), map.get(B.charAt(i)) + 1);
				}
			}
			int need = B.length();
			int ans = Integer.MAX_VALUE;
			int l = 0, r = 0;
			int i=0, j=0;
			while (r < A.length()) {
				if (map.get(A.charAt(r)) == null) {
					map.put(A.charAt(r), -1);
				} else {
					map.put(A.charAt(r), map.get(A.charAt(r)) - 1);
				}
				if (map.get(A.charAt(r)) >= 0) {
					need--;
				}

				if (need == 0) {
					while (map.get(A.charAt(l)) < 0) {
						map.put(A.charAt(l), map.get(A.charAt(l)) + 1);
						l++;
					}

					map.put(A.charAt(l), map.get(A.charAt(l)) + 1);
					if (map.get(A.charAt(l)) == 1)
						need++;
					if(r-l+1<ans) {
						ans = r-l+1;
						i=l; j=r;
					}
					l++;

				}
				r++;
			}
			StringBuilder sb = new StringBuilder("");
			if (ans != Integer.MAX_VALUE) {
				if (l != 0) {
					l = l - 1;
				}
				for (int k = i; k <= j; k++) {
					sb.append(String.valueOf(A.charAt(k)));
				}
			}
			return sb.toString();
	}

}
