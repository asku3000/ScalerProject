package sorting;

import java.util.Arrays;
import java.util.List;
/*
 * Q2. Reverse pairs
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints

1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109



Input Format

The only argument given is the integer array A.



Output Format

Return the number of important reverse pairs in the given array A.



Example Input

Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
 */
public class ReversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] {1, 3, 2, 3, 1})));
	}
	static int reversePairs;
	public static int solve(List<Integer> A) {
		int l=0, r= A.size()-1;
		reversePairs = 0;
		sort(A, l, r);
		return reversePairs;
	}

	static void sort(List<Integer> a, int l, int r) {
		if(l==r) return;
		int mid = l+(r-l)/2;
		sort(a, l, mid);
		sort(a, mid+1, r);
		merge(a, l, mid, r);
	}

	static void merge(List<Integer> a, int l, int mid, int r) {
		int i, j, k=0;
		int left[] = new int[mid-l+1];
		int right[] = new int[r-mid];
		
		for(i =0; i<left.length; i++) {
			left[i] = a.get(l+i);
		}
		
		for(i =0; i<right.length; i++) {
			right[i] = a.get(mid+1+i);
		}
		
		i=0;j=0;
		
		while(i<left.length && j<right.length) {
			if(left[i]>2l*right[j]) {
				reversePairs+= left.length-i;
				j++;
			}else {
				i++;
			}
		}
		k=l;
		i=0;
		j=0;
	    while (i < left.length && j < right.length)    
	    {    
	        if(left[i] <= right[j])    
	        {    
	            a.set(k, left[i]);    
	            i++;    
	        }    
	        else    
	        {    
	            a.set(k, right[j]);    
	            j++;    
	        }    
	        k++;    
	    }    
	    while (i<left.length)    
	    {    
	    	a.set(k, left[i]);    
	        i++;    
	        k++;    
	    }    
	      
	    while (j<right.length)    
	    {    
	    	a.set(k, right[j]);    
	        j++;    
	        k++;    
	    } 
	}

}
