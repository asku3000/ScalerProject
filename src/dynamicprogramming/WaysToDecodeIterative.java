package dynamicprogramming;

public class WaysToDecodeIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int numDecodings(String A) {
		if(A.isBlank() || A.isEmpty()) {
			return 0;
		}
		if(A.equals("0")) {
			return 0;
		}
		int dp[] = new int[A.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<A.length(); i++) {
			if(A.charAt(i-1) >= '1' && A.charAt(i-1)<='9') {
				dp[i] = dp[i-1];
			}
			
			if(A.charAt(i-2) == '1') {
				dp[i] += dp[i-2];
			}
			else if(A.charAt(i-2) == '2' && A.charAt(i-1)>= '0' && A.charAt(i-1) <= '6') {
				dp[i] += dp[i-2];
			}
		}
		
		return dp[A.length()-1];
	}

}
