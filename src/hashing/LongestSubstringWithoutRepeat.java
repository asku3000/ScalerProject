package hashing;

import java.util.HashSet;

/*
 * Q2. Longest Substring Without Repeat
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints

1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format

Single Argument representing string A.



Output Format

Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input

Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("dadc"));
	}

	public static int lengthOfLongestSubstring(String A) {
		 int ans = 0;
			HashSet<Character> set = new HashSet();
			int i = 0, j = 0;
			while (i < A.length() && j < A.length()) {
				if (set.add(A.charAt(j))) {
					ans = Math.max(ans, j - i+1);
					j++;
				} else {
					while (i <= j) {
	                    set.remove(A.charAt(i));
						if (A.charAt(i) == A.charAt(j)) {
							i++;
							break;
						}
	                    
						i++;
					}
				}
			}

			return ans;
	}

}
