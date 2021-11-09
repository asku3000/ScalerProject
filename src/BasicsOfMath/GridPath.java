package BasicsOfMath;

public class GridPath {

	public static void main(String[] args) {
		int A = 15, B = 9;

		int n = (A - 1) + (B - 1);
		int r = B - 1;
		if (r == 0) {
			System.out.println(1);
			;
		}

		int factN = fact(n);
		int nMinusR = fact(n - r);
		int factR = fact(r);
		System.out.println(factN / nMinusR * factR);
	}

	static int fact(int A) {
		int fact = 1;
		for (int i = 1; i <= A; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
