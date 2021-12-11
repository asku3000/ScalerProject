package searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q2. Number of sextuplets
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A, find the number of sextuplets that satisfy the equation ( (a * b + c) / d ) - e = f.

where a, b, c, d, e, f belong to the given array A.

NOTE: Since the answer can be very large, return the number of ways modulo (109 + 7).



Problem Constraints

1 <= |A| <= 100

-106 <= A[i] <= 106

All elements of array A are distinct.



Input Format

The only argument given is the integer array A.



Output Format

Return the find the number of sextuplets that satisfy the equation.



Example Input

Input 1:

A = [1]
Input 2:

A = [1, -1]


Example Output

Output 1:

 1
Output 2:

 24


Example Explanation

Explanation 1:

a = b = c = d = e = f = 1 satisfy the equation.
Explanation 2:

Multiple instances satisfy the equation. Their count is 24.

 */

public class NumberOfSextuplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 13, -25, 9, -27, -5, -23, 19, 1, -21, 25, 15, -29, -3, 21, 3, 23, -15, -17, -1, 0, -19, -11, -9, -7, 5, 17, -13, 11, 27, 7 })));
	}
	
	 public static int solve(List<Integer> A) {
	        HashMap<Long, Integer> map = new HashMap();
	        for(int a=0;a<A.size();a++){
	            for(int b=0;b<A.size(); b++){
	                for(int c=0; c<A.size(); c++){
	                    long firstPart = ((long)A.get(a)*A.get(b))+A.get(c);
	                    if(map.get(firstPart) == null){
	                        map.put(firstPart, 1);
	                    }else{
	                        map.put(firstPart, map.get(firstPart)+1);
	                    }
	                }
	            }
	        }
	        long count = 0;
	        long mod = 1000000007;
	         for(int f=0;f<A.size();f++){
	            for(int e=0;e<A.size(); e++){
	                for(int d=0; d<A.size(); d++){
	                    if(A.get(d)==0){
	                        continue;
	                    }
	                    long secondPart = ((long)A.get(d)*(A.get(f))+A.get(e));
	                    if(map.get(secondPart) != null){
	                        count = (count%mod + map.get(secondPart)%mod)%mod;
	                    }
	                }
	            }
	        }

	        return (int) count;

	    }

}
