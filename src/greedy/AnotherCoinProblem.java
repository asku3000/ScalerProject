package greedy;

import java.util.ArrayList;

public class AnotherCoinProblem {

	public static void main(String[] args) {
		System.out.println(solve(47));
	}

	public static int solve(int A) {
		ArrayList<Long> coins = new ArrayList<Long>();
		coins.add(1l);
		int i=0;
		while(coins.get(i)*5<= A) {
			coins.add(coins.get(i)*5);
			i++;
		}
		int ans =0;
		i = coins.size()-1;
		while(A>=0 && i>=0) {
			if(coins.get(i) <= A) {
				A = (int) (A-coins.get(i));
				ans++;
			}else {
				i--;
			}
		}
		return ans;
	}

}
