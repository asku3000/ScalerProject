package BasicsOfMath;

public class SortedPermutationRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRank("view"));

	}

	public static int findRank(String A) {
		long mod = 1000003;
		long ans = 0;
		for (int i = 0; i < A.length(); i++) {
			long countOfSmall = 0;
			for (int j = i; j < A.length(); j++) {
				if (A.charAt(j) < A.charAt(i)) {
					countOfSmall++;
				}
			}

			if (countOfSmall != 0) {
				long fact = factorial((A.length() - 1) - i);

				ans += ((countOfSmall) % mod * (fact) % mod) % mod;
			}
		}
		return (int) (ans % mod)+1;
	}

	public static long factorial(int N) {
		if (N == 1)
			return 1;
		return N * factorial(N - 1);
	}
}
