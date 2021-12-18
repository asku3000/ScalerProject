package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Subarray with given sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output

Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation

Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.

 */
public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = solve(Arrays.asList(new Integer[] {  42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37}), 100);
		System.out.print(ans.get(0) + ": " + (ans.get(1) != null ? ans.get(1) : ""));
	}

	public static ArrayList<Integer> solve(List<Integer> A, int B) {
        // Collections.sort(A);
		int i = 0, j = 0;
		long sum = 0;
		ArrayList<Integer> ans = new ArrayList();
		sum = A.get(j);
		while (i < A.size() && j < A.size()) {
			if (sum == B) {
				break;
			} else if (sum < B) {
				j++;
				if (j >= A.size()) {
					ans.add(-1);
					return ans;
				}
				sum += A.get(j);
			} else {
				sum -= A.get(i);
				i++;
			}
		}

        if(i>=A.size() || j>=A.size()){
            ans.add(-1);
            return ans;
        }
        for(int k=i; k<j+1; k++){
            ans.add(A.get(k));
        }
		return ans;
	}

}
