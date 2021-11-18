package primenumbers;

public class CountOfDivisorsOfQqueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'

		for (int a : solve(new int[] {8,9,10})) {
			System.out.print(a + ",");
		}

	}

	public static int[] solve(int[] A) {
		int spf[] = new int[1000000 + 1];
		for (int i = 2; i < spf.length; i++) {
			if (spf[i] == 0) {
				for (int j = i; j < spf.length; j = j + i) {
					if (spf[j] == 0) {
						spf[j] = i;
					}
				}
			}
		}
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int prime = spf[A[i]];
			int ans = 1;
			while (prime > 1) {
				int e = 0;
				while (A[i] % prime == 0) {
					e++;
					A[i] = A[i] / prime;
				}
				ans = ans * (e + 1);
				prime = spf[A[i]];
			}
			result[i] = ans;
		}
		return result;
	}

}
