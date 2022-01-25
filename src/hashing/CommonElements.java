package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Q3. Common Elements
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109



Input Format

First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format

Return an integer array denoting the common elements.



Example Input

Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output

Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation

Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.

 */
public class CommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : solve(Arrays.asList(new Integer[] { 1, 2, 2, 1 }),
				Arrays.asList(new Integer[] { 2, 3, 1, 2 }))) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
		HashMap<Integer, Integer> mapA = new HashMap();
		for (Integer i : A) {
			if (mapA.get(i) == null) {
				mapA.put(i, 1);
			} else {
				mapA.put(i, mapA.get(i) + 1);
			}
		}

		HashMap<Integer, Integer> mapB = new HashMap();
		for (Integer i : B) {
			if (mapB.get(i) == null) {
				mapB.put(i, 1);
			} else {
				mapB.put(i, mapB.get(i) + 1);
			}
		}

		ArrayList<Integer> ans = new ArrayList();
		for (Map.Entry<Integer, Integer> e : mapA.entrySet()) {
			if (mapB.get(e.getKey()) != null) {
				int count = Math.min(mapB.get(e.getKey()), e.getValue());
				while (count > 0) {
					ans.add(e.getKey());
					count--;
				}

			}

		}

		return ans;
	}

}
