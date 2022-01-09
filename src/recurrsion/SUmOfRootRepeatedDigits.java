package recurrsion;

public class SUmOfRootRepeatedDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(83557));
	}

	static int sum;

	public static int solve(int A) {
		sum = 0;
		sum = calculate(A);
		while (sum > 9) {
			sum = calculate(sum);
		}
		return sum;
	}

	static int calculate(int A) {
		if (A <= 9) {
			return A;
		}
		return A%10 + calculate(A / 10);
	}

}
