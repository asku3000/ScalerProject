package recurrsion;

public class StringPallindrome {

	public static void main(String[] args) {
		String A = "Strings";
		System.out.println(isPallin(0, A.length() - 1, A));

	}

	static boolean isPallin(int start, int end, String A) {
		if (start >= end) {
			return true;
		}

		if (A.charAt(start) == A.charAt(end)) {
			return isPallin(start + 1, end - 1, A);
		} else {
			return false;
		}
	}

}
