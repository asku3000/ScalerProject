package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = {20, 7, 12, 3, 13, 2};
		Integer[][] b = { { 1, 3 }};
		System.out.println(solve(Arrays.asList(a), Arrays.asList(b)));
	}

	public static ArrayList<Integer> solve(List<Integer> A, List<Integer []> B) {
		ArrayList<Integer> copy = new ArrayList<Integer>();
		copy.addAll(A);
		A.set(0, 0);
		for (int i = 1; i < A.size(); i++) {
			if (copy.get(i) < copy.get(i - 1)) {
				A.set(i, 1);
			} else {
				A.set(i, 0);
			}
		}
		
		for (int i = 1; i < A.size(); i++) {
			A.set(i, A.get(i) + A.get(i - 1));
		}
		ArrayList<Integer> res = new ArrayList();
		for (int i = 0; i < B.size(); i++) {
			int L = B.get(i)[0]-1;
			int R = B.get(i)[1]-1;
			if(L-1 == 0){
			    L=0;
			}
			if (A.get(R) - A.get(L) <=0) {
				res.add(1);
			} else {
				res.add(0);
			}
		}
		return res;
	}

}
