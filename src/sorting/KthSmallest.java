package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Q1. Kth Smallest Element
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints

1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format

First argument is vector A.

Second argument is integer B.



Output Format

Return the Bth smallest element in given array.



Example Input

Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output

Output 1:

 2
Output 2:

 2


Example Explanation

Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.

 */
public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> A = Arrays.asList(new Integer[] {47, 7});
		System.out.println(kthsmallest(A, 2));
	}
	
	public static int kthsmallest(final List<Integer> A, int B) {
		if(B==0) {
			return A.get(0);
		}
        List<Integer> a = new ArrayList(A);
        int b = B;
        for(int i =0; i<a.size()-1; i++){
            int minIndex = i;
            for(int j=i+1; j<a.size(); j++){
                if(a.get(j)<a.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = a.get(i);
            a.set(i, a.get(minIndex));
            a.set(minIndex, temp);
            B--;
            if(B<=0){
                break;
            }
        }

        return a.get(b-1);
    }

}
