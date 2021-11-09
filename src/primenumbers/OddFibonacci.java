package primenumbers;

public class OddFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(2, 6));

	}

	public static int solve(int A, int B) {
		int countEven = (int) ((B / 3) - ((A - 1) / 3));
		return (B - A + 1) - countEven;
	}

}
