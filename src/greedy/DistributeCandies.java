package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Distribute Candy
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?



Problem Constraints

1 <= N <= 105
-109 <= A[i] <= 109



Input Format

First and only argument is an integer array A representing the rating of children.



Output Format

Return an integer, representing the minimum candies to be given.



Example Input

Input 1:

 A = [1, 2]
Input 2:

 A = [1, 5, 2, 1]


Example Output

Output 1:

 3
Output 2:

 7


Example Explanation

Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. 
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:

 Candies given = [1, 3, 2, 1]
 */
public class DistributeCandies {

	public static void main(String[] args) {
		System.out.println(candy(Arrays.asList(new Integer[] { 2, 6, 3, 1, 10, 12, 20, 5, 2 })));
	}

	public static int candy(List<Integer> A) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		left.add(1);
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i - 1) < A.get(i)) {
				left.add(left.get(i - 1) + 1);
			} else {
				left.add(1);
			}
		}

		Collections.reverse(A);
		ArrayList<Integer> right = new ArrayList<Integer>();
		right.add(1);
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i - 1) < A.get(i)) {
				right.add(right.get(i - 1) + 1);
			} else {
				right.add(1);
			}
		}

		Collections.reverse(right);

		int ans = 0;
		for (int i = 0; i < left.size(); i++) {
			ans += Math.max(left.get(i), right.get(i));
		}

		return ans;
	}

}
