package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * Q3. Sort stack using another stack
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints

1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format

The only argument given is the integer array A.



Output Format

Return the array of integers after sorting the stack using another stack.



Example Input

Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation

Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.

 */
public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer i: solve(Arrays.asList(new Integer[] {5, 17, 100, 11}))){
			System.out.print(i+",");
		}

	}
	
	 public static ArrayList<Integer> solve(List<Integer> A) {
	        Stack<Integer> s1 = new Stack();
	        for(int i=0; i<A.size(); i++){
	            s1.push(A.get(i));
	        }

	        Stack<Integer> s2 = new Stack();

	        while(!s1.isEmpty()){
	            int x = s1.pop();
	            while(!s2.isEmpty() && x<s2.peek()){
	                s1.push(s2.pop());
	            }
	            s2.push(x);
	        }

	        ArrayList<Integer> ans = new ArrayList();

	        while(!s2.empty()){
	            ans.add(s2.pop());
	        }

	        Collections.reverse(ans);
	        return ans;
	    }

}
