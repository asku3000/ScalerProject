package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
 * Q4. Largest Continuous Sequence Zero Sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints

1 <= N <= 106

-107 <= A[i] <= 107



Input Format

Single argument which is an integer array A.



Output Format

Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input

A = [1,2,-2,4,-4]


Example Output

[2,-2,4,-4]


Example Explanation

[2,-2,4,-4] is the longest sequence with total sum of zero.

 */

public class LongestSequenceWithSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : lszero(Arrays.asList(new Integer[] { 1,2,-3, 3}))) {
			System.out.print(i + ",");
		}

	}

	public static ArrayList<Integer> lszero(List<Integer> A) {
		long pf = 0;
		HashMap<Long, Integer> map = new HashMap();
		map.put((long) 0, -1);
		int longestLength = 0;
		int j = 0, k = 0;
		for (int i = 0; i < A.size(); i++) {
			pf += A.get(i);
			if (map.get(pf) == null) {
				map.put(pf, i);
			} else {
				if (longestLength < (i - map.get(pf))) {
					longestLength = (i - map.get(pf));
					j = map.get(pf);
					k = i;
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList();
		j++;
		while (j <= k) {
			ans.add(A.get(j));
			j++;
		}

		return ans;
	}

}
