package StringManipulation;

public class ClosestPallindrome {

	public static void main(String[] args) {
		System.out.println(solve("aaaaaaaaaabaaaaaaaaa"));

	}

	public static String solve(String A) {

		int count = 0;
		int length = A.length();
		
		for (int i = 0, j = A.length()-1; i <= A.length() / 2 && j >= A.length() / 2; i++, j--) {

			System.out.println("A: "+A.charAt(i)+" B: "+A.charAt(j));
			if (A.charAt(i) != A.charAt(j)) {
				count++;
			}

		}

		if (A.length() % 2 == 0 && count == 1) {
			return "YES";
		}

		if (A.length() % 2 != 0 && (count == 0 || count == 1)) {
			return "YES";

		}
		return "NO";

	}

}
