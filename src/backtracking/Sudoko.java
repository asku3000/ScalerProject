package backtracking;

public class Sudoko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a = { { 5, 3, '.', '.', 7, '.', '.', '.', '.' }, { 6, '.', '.', 1, 9, 5, '.', '.', '.' },
				{ '.', 9, 8, '.', '.', '.', '.', 6, '.' }, { 8, '.', '.', '.', 6, '.', '.', '.', 3 },
				{ 4, '.', '.', 8, '.', 3, '.', '.', 1 }, { 7, '.', '.', '.', 2, '.', '.', '.', 6 },
				{ '.', 6, '.', '.', '.', '.', 2, 8, '.' }, { '.', '.', '.', 4, 1, 9, '.', '.', 5 },
				{ '.', '.', '.', '.', 8, '.', '.', 7, 9 } };

		solveSudoku(a);
		for (int i = 0; i < 9; i++) {
			System.out.println("\n");
			for (int j = 0; j < 9; j++) {
				System.out.print(a[i][j]);
			}
		}
	}

	public static void solveSudoku(char[][] A) {
		int r = 0, c = 0;
		solve(r, c, A);
	}

	private static boolean solve(int r, int c, char[][] a) {
		if (c == 9) {
			r++;
			c = 0;
		}

		if (r == 9) {
			return true;
		}

		if (a[r][c] != '.') {
			// already filled
			return solve(r, c + 1, a);
		}

		for (int x = 1; x <= 9; x++) {
			if (check(x, a, r, c)) {
				a[r][c] =(char) x;
				if (solve(r, c + 1, a))
					return true;
				a[r][c] = '.';
			}
		}

		return false;
	}

	private static boolean check(int x, char[][] a, int r, int c) {
		// check the row having x
		for (int i = 0; i < 9; i++) {
			if (a[r][i] == x) {
				return false;
			}
		}

		// check column
		for (int i = 0; i < 9; i++) {
			if (a[i][c] == x) {
				return false;
			}
		}

		int stratRowCube = r - r % 3;
		int endRowCube = stratRowCube + 3;
		int startColCube = c - c % 3;
		int endColCube = startColCube + 3;
		for (int i = stratRowCube; i < endRowCube; i++) {
			for (int j = startColCube; j < endColCube; j++) {
				if (a[i][j] == x) {
					return false;
				}
			}
		}
		return true;
	}

}
