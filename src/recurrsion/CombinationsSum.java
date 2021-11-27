package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsSum {
	
	/*Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints

1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format

First argument is the vector A.

Second argument is the integer B.



Output Format

Return a vector of all combinations that sum up to B.



Example Input

Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output

Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]


Example Explanation

Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed.
*/

	public static void main(String[] args) {
		for (ArrayList<Integer> li : combinationSum(Arrays.asList(new Integer[] { 2, 3, 6, 7 }), 7)) {
			System.out.println(" ");
			for (Integer i : li) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B) {
		int i = 0;
		int sum = 0;
		ArrayList<Integer> temp = new ArrayList();
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		Collections.sort(A);
		solve(i, B, A, sum, temp, result);
		Collections.sort(result, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			for (int k = 0; k < first.size() && k < second.size(); k++) {
				if (first.get(k) < second.get(k))
					return -1;
				if (first.get(k) > second.get(k))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return result;
	}

	static void solve(int i, int b, List<Integer> a, int sum, ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> result) {
		if (sum > b) {
			return;
		}
		if (sum == b) {
			ArrayList<Integer> li = new ArrayList();
			li.addAll(temp);
			result.add(li);
			return;
		}

		for (int j = i; j < a.size(); j++) {
			temp.add(a.get(j));
			sum += a.get(j);
			solve(j, b, a, sum, temp, result);
			temp.remove(temp.size() - 1);
			sum -= a.get(j);
			while ((j + 1) < a.size() && a.get(j + 1) == a.get(j)) {
				j++;
			}
		}
	}

}
