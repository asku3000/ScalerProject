package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Letter Phone
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints

1 <= |A| <= 10



Input Format

The only argument is a digit string A.



Output Format

Return a string array denoting the possible letter combinations.



Example Input

Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output

Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation

Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations.


 */
public class LetterPhone {

	public static void main(String[] args) {
		for (String s : letterCombinations("234")) {
			System.out.println(s);
		}

	}
	
	public static ArrayList<String> letterCombinations(String A) {
		List<String> letters = Arrays
				.asList(new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" });
		int i=0;
		ArrayList<String> ans = new ArrayList<String>();
		StringBuilder sb = new StringBuilder("");
		find(i, letters, sb, ans, A);
		return ans;
	}

	private static void find(int i, List<String> letters, StringBuilder sb, ArrayList<String> ans, String a) {
		if(i==a.length()) {
			ans.add(sb.toString());
			return;
		}
		
		String letter = letters.get(a.charAt(i)-'0');
		for(int j =0; j<letter.length(); j++) {
			sb.append(String.valueOf(letter.charAt(j)));
			find(i+1, letters, sb, ans, a);
			sb = sb.deleteCharAt(sb.length()-1);
		}
		
	}

}
