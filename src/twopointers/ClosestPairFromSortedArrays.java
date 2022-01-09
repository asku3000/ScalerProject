package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q4. Closest pair from sorted arrays
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.



Problem Constraints

1 <= length of both the arrays <= 100000

1 <= A[i], B[i] <= 109

1 <= C <= 109



Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.



Output Format

Return an array of size 2 denoting the pair which has sum closest to C.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:

 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13


Example Output

Output 1:

 [1, 8]
Output 2:

 [10, 2]


Example Explanation

Explanation 1:

 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
Explanation 2:

 [10, 2] is the only pair such abs(10+2-13) is minimum.
 */
public class ClosestPairFromSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = solve(Arrays.asList(new Integer[] {1}), Arrays.asList(new Integer[] {2, 4 }), 4);
		System.out.print(ans.get(0)+","+ans.get(1));
	}
	
	public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B, int C) {
        int i =0, j= B.size()-1;
        int diff = Integer.MAX_VALUE;
        int l=0, r=0;
        while(i<A.size() && j>=0){
            int currdiff = Math.abs(A.get(i) + B.get(j) - C);
            if(currdiff<diff){
                diff = currdiff;
                l = i;
                r= j;
            }
            if(currdiff == diff && l==i) {
            	r=j;
            }
            if((A.get(i)+B.get(j)) < C){
                i++;
            }else{
                j--;
            }
        }

        ArrayList<Integer> ans = new ArrayList();
        ans.add(A.get(l));
        ans.add(B.get(r));
        return ans;
    }

}
