package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Maximum & Minimum Magic
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given an array of integers A of size N where N is even.

Divide the array into two subsets such that

1.Length of both subset is equal.
2.Each element of A occurs in exactly one of these subset.
Magic number = sum of absolute difference of corresponding elements of subset.

Note: You can reorder the position of elements within the subset to find the value of magic number.

For Ex:- 
subset 1 = {1, 5, 1}, 
subset 2 = {1, 7, 11}
Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109

N is even



Input Format
The first argument given is the integer array A.



Output Format
Return an array B of size 2, where B[0] = maximum possible value of Magic number % 109 + 7,B[1] = minimum possible value of a Magic number % 109 + 7.



Example Input
Input 1:

 A = [3, 11, -1, 5]
Input 2:

 A = [2, 2]


Example Output
Output 1:

 [14, 10]
Output 2:

 [0, 0]


Example Explanation
Explanation 1:

 All possible magical numbers:-
 sub1 = {3, 11}, sub2 = {-1, 5}, Magic Number = abs(3 - -1) + abs(11 - 5) = 10
 sub1 = {3, -1}, sub2 = {11, 5}, Magic Number = abs(3 - 11) + abs(-1 - 5) = 14 
 sub1 = {3, 5}, sub2 = {11, -1}, Magic Number = abs(3 - 11) + abs(5 - -1) = 14
 sub1 = {11, -1}, sub2 = {3, 5}, Magic Number = abs(11 - 3) + abs(-1 - 5) = 14
 sub1 = {11, 5}, sub2 = {3, -1}, Magic Number = abs(11 - 3) + abs(5 - -1) = 14
 sub1 = {-1, 5}, sub2 = {3, 11}, Magic Number = abs(-1 - 3) + abs(5 - 11) = 10 
 maximum of all magic number = 14 % 10^9 + 7 = 14
 minimum of all magic number = 10 % 10^9 + 7 = 10
Explanation 2:

 Answer is evident.
 */
public class MaximumMinimumMagicNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = solve(Arrays.asList(new Integer[] {3, 11, -1, 5}));
		System.out.println(ans.get(0)+","+ans.get(0));

	}
	
	public static ArrayList<Integer> solve(List<Integer> A) {
        Collections.sort(A);
        long maxDiff = 0;
        long mod = 1000000007;
        int i =0, j=A.size()-1;
        while(i<j){
            maxDiff= (maxDiff%mod + (Math.abs(A.get(j)-A.get(i))%mod))%mod;
            i++; j--;
        }

        long minDiff = 0;
        i=0;
        while(i<A.size()){
            minDiff = (minDiff%mod + Math.abs(A.get(i)-A.get(i+1))%mod)%mod;
            i+=2;
        }

        ArrayList<Integer> ans = new ArrayList();
        ans.add((int) maxDiff);
        ans.add((int) minDiff);
        return ans;
    }

}
