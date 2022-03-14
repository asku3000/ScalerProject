package heaps;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q3. B-th Smallest Prime Fraction
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

A sorted array of integers, A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.



Problem Constraints

1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2



Input Format

The first argument of input contains the integer array, A.
The second argument of input contains an integer B.



Output Format

Return an array of two integers, where answer[0] = p and answer[1] = q.



Example Input

Input 1:

 A = [1, 2, 3, 5]
 B = 3
Input 2:

 A = [1, 7]
 B = 1


Example Output

Output 1:

 [2, 5]
Output 2:

 [1, 7]


Example Explanation

Explanation 1:

 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.
Explanation 2:

 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7.

 */

public class BThSmallestPrimFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer i : solve(Arrays.asList(new Integer[] { 1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297 }), 42)) {
			System.out.println(i + ",");
		}
	}

	public static ArrayList<Integer> solve(List<Integer> A, int B) {
		Collections.sort(A);
		PriorityQueue<PrimeFactorPair> minHeap = new PriorityQueue<PrimeFactorPair>(new PrimeFactorPairComparator());
		for (int i = 0; i < A.size() -1; i++) {
			for (int j = A.size() - 1; j > i; j--) {
//				System.out.println("Pairs are: " + A.get(i) +": "+ A.get(j));
				minHeap.add(new PrimeFactorPair(((double)A.get(i) / A.get(j)), A.get(i), A.get(j)));
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < B-1; i++) {
//			System.out.println("Going out: "+minHeap.peek().numerator +": "+minHeap.peek().denominator +" decimal : "+ minHeap.peek().decimalValue);
			minHeap.poll();
		}
		
		ans.add(minHeap.peek().numerator);
		ans.add(minHeap.peek().denominator);
		return ans;
	}

}

class PrimeFactorPair {
	double decimalValue;
	int numerator;
	int denominator;

	public PrimeFactorPair(double decimalValue, int numerator, int denominator) {
		this.decimalValue = decimalValue;
		this.numerator = numerator;
		this.denominator = denominator;
	}

}

class PrimeFactorPairComparator implements Comparator<PrimeFactorPair> {

	@Override
	public int compare(PrimeFactorPair o1, PrimeFactorPair o2) {
		if (o1.decimalValue > o2.decimalValue)
			return 1;
		else if (o1.decimalValue == o2.decimalValue)
			return 0;
		else
			return -1;
	}

}
