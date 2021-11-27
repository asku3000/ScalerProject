package combinatorics;

public class Geeks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lexRank("asasdsdsadasdadsadasdsa"));

	}

	static int lexRank(String s) {
		long n = s.length();
		long t_count = 1;

		for (int i = 0; i < n; i++) {
			long less_than = 0;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) > s.charAt(j)) {
					less_than += 1;
				}
			}
			long[] d_count = new long[52];
			for (int j = i; j < n; j++) {
				if ((s.charAt(j) >= 'A') && s.charAt(j) <= 'Z')
					d_count[s.charAt(j) - 'A'] += 1;
				else
					d_count[s.charAt(j) - 'a' + 26] += 1;
			}

			long d_fac = 1;
			for (long ele : d_count)
				d_fac *= fac(ele);

			t_count += (fac(n - i - 1) * less_than) / d_fac;
		}
		return (int) t_count;
	}
	
	static long fac(long n)
    {
        if (n == 0 || n == 1)
            return 1;
        return n * fac(n - 1);
    }

}