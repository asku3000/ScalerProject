package multidimarray;

public class SubsequenceAG {

	public static void main(String[] args) {
		String A = "CABGEGAXGLG";
		System.out.println(solve(A));
	}

	public static int solve(String A) {
		int ans = 0, gcount = 0;

		for (int i = A.length() - 1; i >= 0; i--) {
			if (A.charAt(i) == 'A') {
				ans += gcount;
			}
			if (A.charAt(i) == 'G') {
				gcount++;
			}
		}
		return ans;

	}

}
