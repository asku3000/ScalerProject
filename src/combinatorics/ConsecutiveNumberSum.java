package combinatorics;

public class ConsecutiveNumberSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(1));

	}

	public static int solve(int A) {
		int k = 1;
		int numerator = A - ((k * (k - 1)) / 2);
		int count = 0;
		while (numerator > 0) {
			if (numerator % k == 0)
				count++;
			k++;
			numerator = A - ((k * (k - 1)) / 2);
		}
		return count;
	}

}
