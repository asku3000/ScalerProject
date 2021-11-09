package StringManipulation;

import java.util.Arrays;
import java.util.List;

public class ToLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character[] arr = { 'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0' };
		List<Character> a = Arrays.asList(arr);
		for (Character c : to_lower(a)) {
			System.out.print(c + ",");
		}
	}

	public static List<Character> to_lower(List<Character> A) {

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= 'A' && A.get(i) <= 'Z') {
				A.set(i, Character.valueOf((char) (A.get(i) + 'a' - 'A')));
			}
		}
		return A;

	}

}
