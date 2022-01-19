package searching;

import java.util.Arrays;
import java.util.List;
/*
 * Q1. Search in Bitonic Array!
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A
 */
public class SearchInBitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 10, 9, 8, 7, 6 }), 5));
	}
	public static int solve(List<Integer> A, int B) {
        int l=0, r=A.size()-1;
        int peakIndex = 0;
        //finding peak element
        while(l<=r){
            int mid = l+((r-l)/2);
            if(mid==0 && A.get(mid)<A.get(mid+1)){
                peakIndex = mid+1;
                break;
            }else if(mid ==0 && A.get(mid)>A.get(mid+1)){
                peakIndex = mid;
                break;
            }
            if(mid==A.size()-1 && A.get(mid)<A.get(mid-1)){
                peakIndex = mid-1;
                break;
            }else if(mid ==A.size()-1 && A.get(mid)>A.get(mid-1)){
                peakIndex = mid;
                break;
            }

            if(A.get(mid-1) < A.get(mid) && A.get(mid) > A.get(mid+1)){
                peakIndex = mid;
                break;
            }else if(A.get(mid)<A.get(mid-1)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        //binary search in first ascending part
        l=0; r=peakIndex-1;
        while(l<=r) {
        	int mid = l+(r-l)/2;
        	if(A.get(mid)==B) {
        		return mid;
        	}else if(A.get(mid)>B) {
        		r=mid-1;
        	}else {
        		l=mid+1;
        	}
        }
        
      //binary search in second descending part
        l=peakIndex; r=A.size()-1;
        while(l<=r) {
        	int mid = l+(r-l)/2;
        	if(A.get(mid)==B) {
        		return mid;
        	}else if(A.get(mid)<B) {
        		r=mid-1;
        	}else {
        		l=mid+1;
        	}
        }
        
        return -1;
    }

}
