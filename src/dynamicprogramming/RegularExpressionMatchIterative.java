package dynamicprogramming;

public class RegularExpressionMatchIterative {

	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "a*"));
		System.out.println(isMatch("acz", "a?a"));
		System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*"));
	}

	public static int isMatch(final String A, final String B) {
		int[][] dp = new int[A.length()+ 1][B.length() + 1];
		dp[0][0] = 1;
		for(int i=0; i<A.length(); i++) {
			dp[i][0] = 0;
		}
		for(int i = 1;i<A.length(); i++) {
			for(int j=1; j<B.length(); j++) {
			}
		}
		
		return 0;
	}
}
