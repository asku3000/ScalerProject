package recurrsion;

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
		// TODO Auto-generated method stub
		for(String s : letterCombinations("234")) {
			System.out.println(s);
		}
	}

	static ArrayList<String> ans;
	static String a;

	public static ArrayList<String> letterCombinations(String A) {
		List<String> letters = Arrays
				.asList(new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" });

		int i = 0;
		int j = i;
		ans = new ArrayList();
		ArrayList<String> temp = new ArrayList<String>();
		a = A;
		solve(i, new StringBuilder(""), letters, temp);
		return ans;
	}

	static void solve(int i, StringBuilder s, List<String> letters, ArrayList<String> temp) {
		if(i==a.length()) {
			ans.add(s.toString());
			return;
		}
		String letter = letters.get(a.charAt(i)-'0');
		for(int j = 0; j<letter.length(); j++) {
			solve(i+1, s.append(String.valueOf(letter.charAt(j))), letters, temp);			
		}
		
	}

}
