package problemsolving;

public class SquareGranites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(6, 6, 4));
	}

	public static int solve(int A, int B, int C) {
		
		double rows = A/C + (A%C == 0?0:1);
		double columns = B/C + (B%C == 0?0:1);
		return (int) (rows * columns);

	}

}
