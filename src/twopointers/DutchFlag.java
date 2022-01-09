package twopointers;

import java.util.Arrays;
import java.util.List;

/*
 * Q3. Sort by Color
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.



Problem Constraints

1 <= N <= 1000000
0 <= A[i] <= 2


Input Format

First and only argument of input contains an integer array A.


Output Format

Return an integer array in asked order


Example Input

Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output

Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation

Explanation 1:
    [0 0 1 1 2 2] is the required order.

 */
public class DutchFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer i: sortColors(Arrays.asList(new Integer[] {0 ,1, 2, 0, 1, 2}))) {
			System.out.print(i+",");
		}
	}
	
	 public static List<Integer> sortColors(List<Integer> A) {
	        int l=0, m=0, h=A.size()-1;
	        while(m<=h){
	            switch(A.get(m)){
	                case 0: swap(l, m, A);
	                        l++; m++;
	                        break;
	                case 1: m++;
	                        break;
	                case 2: swap(m, h, A);
	                        h--;
	                        break;
	            }
	        }

	        return A;
	    }

	    static void swap(int a, int b, List<Integer> A){
	        int temp = A.get(a);
	        A.set(a, A.get(b));
	        A.set(b, temp);
	    }

}
