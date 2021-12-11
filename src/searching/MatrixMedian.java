package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMedian {
	/*
	 * Q3. Matrix Median
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of the matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format

The first and only argument given is the integer matrix A.



Output Format

Return the overall median of the matrix A.



Example Input

Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2:

A = [   [5, 17, 100]    ]


Example Output

Output 1:

 5
Output 2:

 17


Example Explanation

Explanation 1:

 
A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.
Explanation 2:

 
Median is 17.

	 */

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
//		A.add(Arrays.asList(new Integer[] { 1, 3, 5 }));
//		A.add(Arrays.asList(new Integer[] { 2, 6, 9 }));
//		A.add(Arrays.asList(new Integer[] { 3, 6, 9 }));
		
		A.add(Arrays.asList(new Integer[] { 1, 1, 3, 3, 3, 3, 3 }));
		
		System.out.println(findMedian(A));

	}

	public static int findMedian(ArrayList<List<Integer>> A) {
		// finding search space
		int lowerBound = A.get(0).get(0);
		int higherBound = A.get(A.size() - 1).get(A.get(0).size() - 1);
		for (int i = 0; i < A.size(); i++) {
			lowerBound = Math.min(lowerBound, A.get(i).get(0));
			higherBound = Math.max(higherBound, A.get(i).get(A.get(i).size() - 1));
		}

		int desiredCount = (1 + (A.size() * A.get(0).size()) / 2);
		int mid = 0;
		int countOfSmallEle = 0;
		while (lowerBound <= higherBound) {
			mid = lowerBound + (higherBound - lowerBound) / 2;
			countOfSmallEle = 0;
			for (int i = 0; i < A.size(); i++) {
				countOfSmallEle += countSmallElementsThanMidInEacRow(A.get(i), mid);
			}
			if (countOfSmallEle < desiredCount) {
				lowerBound = mid + 1;
			} else if (countOfSmallEle > desiredCount) {
				higherBound = mid - 1;
			} else {
				higherBound = mid - 1;
			}

		}
		return lowerBound;

	}

	private static int countSmallElementsThanMidInEacRow(List<Integer> arrayList, int mid) {

		int l = 0, h = arrayList.size() - 1;
		int midOfRow = 0;
		while(l<=h) {
			midOfRow = l+(h-l)/2;
			if(arrayList.get(midOfRow)<=mid) {
				l=midOfRow+1;
			}else {
				h = midOfRow-1;
			}
		}
		return l;
	}

}
