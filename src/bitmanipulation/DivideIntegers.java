package bitmanipulation;

public class DivideIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(7, 1));
	}

	public static int divide(int A, int B) {
		long ans = 0;
		int max = Integer.MAX_VALUE;

		int sign = ((A < 0) ^ (B < 0)) ? -1 : 1;
		A = Math.abs(A);
		B = Math.abs(B);

		for (int i = 31; i >= 0; i--) {
			long pow = (B<<i);
			long midSub = A - pow;
			if (midSub > 0) {
				ans += 1 << i;
				A -= pow;
			}

			if (ans > max) {
				return (int) max;
			}
		}
		if (sign == -1)
			return (int) -ans;
		else
			return (int) ans;
	}

}
