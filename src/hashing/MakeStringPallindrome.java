package hashing;

import java.util.HashMap;
import java.util.Map;

public class MakeStringPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("bb"));
	}

	public static int solve(String A) {
		int length = A.length();
		HashMap<Character, Integer> map = new HashMap();

		for (int i = 0; i < A.length(); i++) {
			int freq = map.getOrDefault(A.charAt(i), 0) + 1;
			map.put(A.charAt(i), freq);
		}

		int countOfMisMatchedChars = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()%2 != 0) {
				countOfMisMatchedChars++;
			}
		}

		if(length%2 == 0) {
			return countOfMisMatchedChars;
		}else {
			return countOfMisMatchedChars-1;
		}
	}

}
