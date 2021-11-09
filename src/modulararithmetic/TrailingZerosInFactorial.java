package modulararithmetic;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(9247));

	}

	public static int trailingZeroes(int A) {
		int ans = 0;
		int pow = 1;
		int deno = (int) Math.pow(5, pow);
		while (A >= deno) {
			ans += Math.floor(A / deno);
			pow++;
			deno = (int) Math.pow(5, pow);
		}
		return ans;
	}

}
