package recurrsion;

import java.util.ArrayList;

public class Combinations {

	/*
	 * Problem Description
	 * 
	 * Given two integers A and B, return all possible combinations of B numbers out
	 * of 1 2 3 … A .
	 * 
	 * Make sure the combinations are sorted.
	 * 
	 * To elaborate,
	 * 
	 * Within every entry, elements should be sorted. [1, 4] is a valid entry while
	 * [4, 1] is not. Entries should be sorted within themselves. WARNING: DO NOT
	 * USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
	 * 
	 * 
	 * 
	 * Problem Constraints
	 * 
	 * 1 <= A, B <= 10
	 * 
	 * 
	 * 
	 * Input Format
	 * 
	 * First argument is an integer A. Second argument is an integer B.
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Return a 2-D vector denoting all possible combinations.
	 * 
	 * 
	 * 
	 * Example Input
	 * 
	 * Input 1:
	 * 
	 * A = 4 B = 2 Input 2:
	 * 
	 * A = 3 B = 2
	 * 
	 * 
	 * Example Output
	 * 
	 * Output 1:
	 * 
	 * [ [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4], ] Output 2:
	 * 
	 * [ [1, 2], [1, 3], [2, 3] ]
	 * 
	 * 
	 * Example Explanation
	 * 
	 * Explanation 1:
	 * 
	 * All the possible combinations of size 2 in sorted order.
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (ArrayList<Integer> li : combine(4, 2)) {
			System.out.println("\n");
			for (Integer i : li) {
				System.out.print(i + " ");
			}
		}
	}

	static int BSize;

	public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
		int i = 1;
		ArrayList<Integer> temp = new ArrayList();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		BSize = B;
		solve(i, A, B, temp, result);
		return result;
	}

	static void solve(int i, int a, int b, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
		 
        if (b == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(temp);
			result.add(list);
			return;
		}
		if (i > a)
			return;
		
		for (int j = i; j <=a; j++) {
			temp.add(i);  
			solve(i+1, a, b - 1, temp, result);
			temp.remove(temp.size() - 1);
		}

	}

}
