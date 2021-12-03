package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q2. Unique Elements
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.

Find the minimum number of steps.



Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109



Input Format

The only argument given is an Array A, having N integers.



Output Format

Return the Minimum number of steps required to make all elements unique.



Example Input

Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 4, 5]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
Explanation 2:

 All elements are distinct.
 */
public class MinDiffMaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer [] arr = {1, 1, 7 };
		System.out.println(solve(Arrays.asList(arr), 7));

	}
	

    public static int solve(List<Integer> A, int B) {
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i =0; i < A.size(); i++){
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
            if(map.get(A.get(i)) != null){
                map.put(A.get(i), map.get(A.get(i))+1);
            }else{
                map.put(A.get(i), 1);
            }
        }
        
        
        while((min<max) && B!=0){
            if( map.get(min) < map.get(max)){
                if(B<map.get(min)){
                    break;
                }
                
                map.put(min+1,  map.get(min+1) == null ? map.get(min) : map.get(min+1) + map.get(min));
                B=B-map.get(min);
                min++;
                
            }else{
                if(B<map.get(max)){
                    break;
                }
                
                map.put(max-1, map.get(max-1) == null ? map.get(max) : map.get(max-1) + map.get(max));
                B = B-map.get(max);
                max--;
            }
        }
        
        return max-min;
    }


}
