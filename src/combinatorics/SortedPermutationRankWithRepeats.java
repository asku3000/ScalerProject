package combinatorics;

public class SortedPermutationRankWithRepeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRank("bbbbaaaa"));

	}

	public static int findRank(String A) {
		int freq[] = new int[52];

		for (int i = 0; i < A.length(); i++) {
			if ((A.charAt(i) >= 'A') && A.charAt(i) <= 'Z')
				freq[A.charAt(i) - 'A'] += 1;
			else
				freq[A.charAt(i) - 'a' + 26] += 1;
		}

		long mod = 1000003;
		long ans = 0;
		for (int i = 0; i < A.length(); i++) {
			long countOfSmall = 0;
			for (int j = i+1; j < A.length(); j++) {
				if (A.charAt(j) < A.charAt(i)) {
					countOfSmall++;
				}
			}
			if (countOfSmall != 0) {

				long factNr = factorial((A.length() - 1) - i);
				long factDr = 1;
				for (int c : freq) {
					factDr *= factorial(c);
				}
				factNr = factNr / factDr;

				ans += ((countOfSmall) % mod * (factNr) % mod) % mod;
			}

			if ((A.charAt(i) >= 'A') && A.charAt(i) <= 'Z')
				freq[A.charAt(i) - 'A'] -= 1;
			else
				freq[A.charAt(i) - 'a' + 26] -= 1;

		}
		return (int) (ans % mod) + 1;
	}

	public static long factorial(int N) {
		if (N <= 1)
			return 1;
		return (N * factorial(N - 1)) % 1000003;
	}

	/*
	 * Problem Description
	 * 
	 * Given a string A, find the rank of the string amongst its permutations sorted
	 * lexicographically. Note that the characters might be repeated. If the
	 * characters are repeated, we need to look at the rank in unique permutations.
	 * Look at the example for more details.
	 * 
	 * NOTE:
	 * 
	 * The answer might not fit in an integer, so return your answer % 1000003 where
	 * 1000003 is a prime number. String A can consist of both lowercase and
	 * uppercase letters. Characters with lesser ascii value are considered smaller
	 * i.e. 'a' > 'Z'.
	 * 
	 * 
	 * Problem Constraints
	 * 
	 * 1 <= len(A) <= 1000000
	 * 
	 * 
	 * 
	 * Input Format
	 * 
	 * First argument is a string A.
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Return an integer denoting the rank.
	 * 
	 * 
	 * 
	 * Example Input
	 * 
	 * Input 1:
	 * 
	 * A = "aba" Input 2:
	 * 
	 * A = "bca"
	 * 
	 * 
	 * Example Output
	 * 
	 * Output 1:
	 * 
	 * 2 Output 2:
	 * 
	 * 4
	 * 
	 * 
	 * Example Explanation
	 * 
	 * Explanation 1:
	 * 
	 * The order permutations with letters 'a', 'a', and 'b' : aab aba baa So, the
	 * rank is 2. Explanation 2:
	 * 
	 * The order permutations with letters 'a', 'b', and 'c' : abc acb bac bca cab
	 * cba So, the rank is 4.
	 */

}
