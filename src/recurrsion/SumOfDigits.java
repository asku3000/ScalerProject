package recurrsion;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(123));

	}

	static int sum(int A) {
		
		if(A == 0) {
			return 0;
		}
		
		return A%10 + sum((int)Math.floor(A/10));

	}

}
