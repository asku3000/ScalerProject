package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumTheDifference {

	/*
	 * Q2. Sum the Difference
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A of size N.
You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints

1 <= N <= 10000

1<= A[i] <=1000



Input Format

First argument is an integer array A.



Output Format

Return an integer denoting the output.



Example Input

Input 1:

A = [1, 2]
Input 2:

A = [1]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1
Explanation 2:

 Only 1 subsequence of 1 element is formed.
	 */
	public static void main(String args[]) {
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 2, 3 })));
	}

	public static int solve(List<Integer> A) {
		Collections.sort(A);
		long mod = 1000000007;
        ArrayList<Long> powers = new ArrayList();
        powers.add(1l);
        for(int i=1;i<=10000; i++){
            long value = ((2*powers.get(i-1))%mod);
            powers.add(value);
        }
		
		long max = 0;
		long min = 0;

		for (int i = 0; i < A.size(); i++) {
			long value = ((powers.get(i)%mod) * (A.get(i)%mod));
			max = (max % mod + (value % mod)) % mod;
		}
		Collections.reverse(A);
		for (int i = 0; i < A.size(); i++) {
			long value = ((powers.get(i)%mod) * (A.get(i)%mod));
			min = (min % mod + (value % mod)) % mod;
		}

		return (int) (((max%mod) - (min%mod) + mod)%mod);}

}
