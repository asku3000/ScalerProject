package primenumbers;

import java.util.ArrayList;

public class LuckyNumbers {

	/*
	 * Problem Description
	 * 
	 * A lucky number is a number which has exactly 2 distinct prime divisors.
	 * 
	 * You are given a number A and you need to determine the count of lucky numbers
	 * between the range 1 to A (both inclusive).
	 * 
	 * 
	 * 
	 * Problem Constraints
	 * 
	 * 1 <= A <= 50000
	 * 
	 * 
	 * 
	 * Input Format
	 * 
	 * The first and only argument is an integer A.
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Return an integer i.e the count of lucky numbers between 1 and A, both
	 * inclusive.
	 * 
	 * 
	 * 
	 * Example Input
	 * 
	 * Input 1:
	 * 
	 * A = 8 Input 2:
	 * 
	 * A = 12
	 * 
	 * 
	 * Example Output
	 * 
	 * Output 1:
	 * 
	 * 1 Output 2:
	 * 
	 * 3
	 * 
	 * 
	 * Example Explanation
	 * 
	 * Explanation 1:
	 * 
	 * Between [1, 8] there is only 1 lucky number i.e 6. 6 has 2 distinct prime
	 * factors i.e 2 and 3. Explanation 2:
	 * 
	 * Between [1, 12] there are 3 lucky number: 6, 10 and 12.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(8));
	}

	public static int solve(int A) {
		ArrayList<Integer>[] primeFactors = new ArrayList[A + 1];
		for (int i = 2; i <= A; i++) {
			if (primeFactors[i] == null || primeFactors[i].isEmpty()) {
				for (int j = i; j <= A; j = j + i) {
					if (primeFactors[j] == null) {
						primeFactors[j] = new ArrayList();
					}
					primeFactors[j].add(i);
				}
			}
		}

		int ans = 0;
		for (int i = 2; i <= A; i++) {
			if (!primeFactors[i].isEmpty() && primeFactors[i].size() == 2) {
				ans++;
			}
		}
		return ans;
	}

}
