package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, 1, 1 }));
		A.add(Arrays.asList(new Integer[] { 1, 0, 1 }));
		A.add(Arrays.asList(new Integer[] { 0, 0, 1 }));
		for (List<Integer> li : solve(A)) {
			System.out.println("\n");
			for (Integer i : li) {
				System.out.print(i + ",");
			}
		}
	}

	public static ArrayList<List<Integer>> solve(ArrayList<List<Integer>> A) {
		int n = A.size();
		int m = A.get(0).size();
		int i = 0, j = 0;
		findPath(i, j, n, m, A);
		return A;
	}

	private static boolean findPath(int i, int j, int n, int m, ArrayList<List<Integer>> a) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			// out of bound
			return false;
		}

		if (a.get(i).get(j) == 0)// blocked or visted
		{
			return false;
		}
		if (i == n - 1 && j == m - 1) {
			// ans
			return true;
		}

		a.get(i).set(j, 0);// visited

		if(findPath(i + 1, j, n, m, a)) {
			a.get(i).set(j, 1);
			return true;
		}else if(findPath(i - 1, j, n, m, a)) {
			a.get(i).set(j, 1);
			return true;
		}else if(findPath(i, j - 1, n, m, a)) {
			a.get(i).set(j, 1);
			return true;
		}else if(findPath(i, j + 1, n, m, a)) {
			a.get(i).set(j, 1);
			return true;
		}
//		return findPath(i + 1, j, n, m, a, ans) || findPath(i - 1, j, n, m, a, ans) || findPath(i, j - 1, n, m, a, ans)
//				|| findPath(i, j + 1, n, m, a, ans);
		return false;
	}

}
