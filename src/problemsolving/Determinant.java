package problemsolving;

public class Determinant {

	public int solve(final int[][] A) {
		if (A.length == 2) {
			return Math.abs(A[0][0] * A[1][1] - A[0][1] * A[1][0]);
		} else {
			return Math.abs(A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
					- A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
					+ A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]));
		}
	}
}
