package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Q2. Aggressive cows
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints

2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return the largest minimum distance possible among the cows.



Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 
John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
So the minimum distance will be 2.
Explanation 2:

 
The minimum distance will be 1.
 */
public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] {5, 17, 100, 11  });
		System.out.println(solve(A, 2));
	}

	public static int solve(List<Integer> A, int B) {
		Collections.sort(A);
		long l = 1, r = (A.get(A.size() - 1) - A.get(0));
		long mid = 0l;
		long ans = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (check(mid, B, A)) {
				l = mid + 1;
				ans = mid;
			} else {
				r = mid - 1;
			}
		}
		return (int) ans;
	}

	static boolean check(long mid, int B, List<Integer> A) {
		int recentPlaced = A.get(0);
		int cowsPlaced = 1;
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) - recentPlaced >= mid) {
				recentPlaced = A.get(i);
				cowsPlaced++;
			}
		}

		if (cowsPlaced >= B) {
			return true;
		}
		return false;
	}

}
