package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
