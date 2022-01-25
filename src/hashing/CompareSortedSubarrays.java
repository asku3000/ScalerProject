package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Q1. Compare Sorted Subarrays
Attempted
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of length N. You have to answer Q queires.

Each query will contain 4 integers l1, r1, l2 and r2. If sorted segment from [l1, r1] is same as sorted segment from [l2 r2] then answer is 1 else 0.

NOTE The queries are 0-indexed.



Problem Constraints

0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000



Input Format

First argument is an array A.
Second will be 2-D array B denoting queries with dimension Q * 4.
Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].



Output Format

Return an array of length Q with answer of the queries in the same order in input.



Example Input

Input 1:

 A = [1, 7, 11, 8, 11, 7, 1]
 B = [ 
       [0, 2, 4, 6]
     ]
Input 2:

 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ] 


Example Output

Output 1:

 [1]
Output 2:

 [0]


Example Explanation

Explanation 1:

 (0, 2) -> [1, 7, 11]
 (4, 6) -> [11, 7, 1]
 Both are same when sorted hence 1.
Explanation 2:

 (0, 1) -> [1, 3]
 (1, 2) -> [3, 2] 
 Both are different when sorted hence -1.

 */
public class CompareSortedSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 5, 3, 4, 4 });
		ArrayList<List<Integer>> B = new ArrayList<List<Integer>>();
		B.add(Arrays.asList(new Integer[] { 0, 1, 2, 3}));
//		B.add(Arrays.asList(new Integer[] { 1, 1, 1, 1 }));
//		B.add(Arrays.asList(new Integer[] { 0, 1, 0, 1 }));
		for (Integer i : solve(A, B)) {
			System.out.print(i + ",");
		}
	}
	
	public static long getHashCode() {
		return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	}

	public static ArrayList<Integer> solve(List<Integer> A, ArrayList<List<Integer>> B) {
		//generating hash fixed values for integers
		HashMap<Integer, Long> mapOfHash = new HashMap();
		long mod = 1000000003;
		for (int i = 0; i < A.size(); i++) {
			if (mapOfHash.get(A.get(i)) == null) {
				mapOfHash.put(A.get(i), (getHashCode()) % mod);
			}
		}

		ArrayList<Long> pf = new ArrayList();
		pf.add(mapOfHash.get(A.get(0)));
		for (int i = 1; i < A.size(); i++) {
			pf.add(mapOfHash.get(A.get(i)) + pf.get(i - 1));
		}

		ArrayList<Integer> ans = new ArrayList();
		for (int i = 0; i < B.size(); i++) {

			long v1 = pf.get(B.get(i).get(1)) - (B.get(i).get(0) == 0 ? 0 : pf.get(B.get(i).get(0) - 1));
			long v2 = pf.get(B.get(i).get(3)) - (B.get(i).get(2) == 0 ? 0 : pf.get(B.get(i).get(2) - 1));
			if (v1 == v2) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}
		return ans;

		//second approach
		/*
		 * ArrayList<Integer> ans = new ArrayList(); for (int j = 0; j < B.size(); j++)
		 * { HashMap<Integer, Integer> mapA = new HashMap(); for (int i =
		 * B.get(j).get(0); i <= B.get(j).get(1); i++) { if (mapA.get(A.get(i)) == null)
		 * { mapA.put(A.get(i), 1); } else { mapA.put(A.get(i), mapA.get(A.get(i)) + 1);
		 * } }
		 * 
		 * HashMap<Integer, Integer> mapB = new HashMap(); for (int i = B.get(j).get(2);
		 * i <= B.get(j).get(3); i++) { if (mapB.get(A.get(i)) == null) {
		 * mapB.put(A.get(i), 1); } else { mapB.put(A.get(i), mapB.get(A.get(i)) + 1); }
		 * } boolean willBeSorted = false; for (Map.Entry<Integer, Integer> e :
		 * mapA.entrySet()) { if (mapB.get(e.getKey()) != null &&
		 * mapB.get(e.getKey()).equals(e.getValue())) { willBeSorted = true; } else {
		 * willBeSorted = false; break; } } if (willBeSorted) { ans.add(1); } else {
		 * ans.add(0); } }
		 */
	}

}
