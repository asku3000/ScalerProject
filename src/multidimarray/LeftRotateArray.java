package multidimarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeftRotateArray {

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 4, 5 };
		Integer[] b = { 2, 3 };

		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);

		ArrayList<ArrayList<Integer>> result = solve(A, B);

		for (ArrayList<Integer> innerList : result) {
			System.out.println("\n");
			for (Integer i : innerList) {
				System.out.print(i+", ");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> solve(List<Integer> A, List<Integer> B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		for (int i = 0; i < B.size(); i++) {
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			innerList.addAll(A);
			int b =B.get(i) % A.size() ;
			for (int j = 0; j < b; j++) {
				innerList.add(A.get(j));
			}
			
			Iterator<Integer> itr = innerList.iterator();
			for(int k =0; k<b; k++){
				itr.next();
	            itr.remove();
	        }
			result.add(innerList);
		}
		return result;

	}

}
