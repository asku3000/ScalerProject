package searching;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. Rotated Sorted Array Search
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints

1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are disitinct.



Input Format

The first argument given is the integer array A.

The second argument given is the integer B.



Output Format

Return index of B in array A, otherwise return -1



Example Input

Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A = [1]
B = 1


Example Output

Output 1:

 0
Output 2:

 0


Example Explanation

Explanation 1:

 
Target 4 is found at index 0 in A.
Explanation 2:

 
Target 1 is found at index 0 in A.

 */
public class RotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> A = Arrays.asList(
				new Integer[] { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 });
		System.out.println(search(A, 202));
	}

	public static int search(final List<Integer> A, int B) {
        int l=0, r=A.size()-1;
        int mid = 0;
        while(l<=r){
            mid =l+(r-l)/2;
            if(A.get(mid)==B){
                return mid;
            }
            if(B<A.get(0)){ //T is in non rotated part P2
                if(A.get(mid)>=A.get(0)){ // mid is in rotated part therefore directly go left
                    l=mid+1;
                }else{ // simple binary search
                    if(A.get(mid)>B){
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
            }
            if(B>=A.get(0)){ //T is in rotated part
                if(A.get(mid)<=A.get(0)){ // mid is in non-rotated part therefore directly go left
                    r=mid-1;
                }else{
                    if(A.get(mid)>B){
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
            }
        }
        return -1;//doesn't exist;
    }
}