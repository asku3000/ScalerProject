package bitmanipulation;

public class DivideIntegers {

	/*
	 * Q2. Divide Integers Unsolved character backgroundcharacter Stuck somewhere?
	 * Ask for help from a TA & get it resolved Get help from TA Problem Description
	 * 
	 * Divide two integers without using multiplication, division and mod operator.
	 * 
	 * Return the floor of the result of the division.
	 * 
	 * Also, consider if there can be overflow cases i.e output is greater than
	 * INT_MAX, return INT_MAX.
	 * 
	 * NOTE: INT_MAX = 2^31 - 1
	 * 
	 * 
	 * 
	 * Problem Constraints
	 * 
	 * -231 <= A, B <= 231-1
	 * 
	 * B!= 0
	 * 
	 * 
	 * 
	 * Input Format
	 * 
	 * First argument is an integer A denoting the dividend. Second argument is an
	 * integer B denoting the divisor.
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Return an integer denoting the floor value of the division.
	 * 
	 * 
	 * 
	 * Example Input
	 * 
	 * Input 1:
	 * 
	 * A = 5 B = 2 Input 2:
	 * 
	 * A = 7 B = 1
	 * 
	 * 
	 * Example Output
	 * 
	 * Output 1:
	 * 
	 * 2 Output 2:
	 * 
	 * 7
	 * 
	 * 
	 * Example Explanation
	 * 
	 * Explanation 1:
	 * 
	 * floor(5/2) = 2
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, -1));
	}

	public static int divide(int A, int B) {
		int max = Integer.MAX_VALUE;
		long ans = 0;
		int sign = 0;
		if (A < 0 || B < 0) {
			sign = -1;
		} else {
			sign = 1;
		}
		long a = A;
		a = Math.abs(a);
		long b = B;
		b = Math.abs(b);
		for (int i = 31; i >= 0; i--) {
			long quotient = b * (1l << i);
			long midSub = a - quotient;
			if (midSub >= 0) {
				ans += 1l << i;
				a = midSub;
			}
		}
		if (sign == -1) {
			ans = -ans;
		}
		if (ans < Integer.MIN_VALUE || ans > max) {
			return max;
		}
		return (int) ans;
	}

}
