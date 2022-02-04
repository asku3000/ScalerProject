package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * Q2. Maximum Frequency stack
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints

1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the array of integers denoting answer to each operation.



Example Input

Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output

Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation

Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations

 */
public class MaxFreqStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		
		A.add(Arrays.asList(new Integer[] {1, 5}));
		A.add(Arrays.asList(new Integer[] {1, 7}));
		A.add(Arrays.asList(new Integer[] {1, 5}));
		A.add(Arrays.asList(new Integer[] {1, 7}));
		A.add(Arrays.asList(new Integer[] {1, 4}));
		A.add(Arrays.asList(new Integer[] {1, 5}));
		A.add(Arrays.asList(new Integer[] {2, 0}));
		A.add(Arrays.asList(new Integer[] {2, 0}));
		A.add(Arrays.asList(new Integer[] {2, 0}));
		A.add(Arrays.asList(new Integer[] {2, 0}));
		for(Integer i: solve(A)) {
			System.out.println(i+",");
		}
	}

	public static ArrayList<Integer> solve(ArrayList<List<Integer>> A) {
		ArrayList<Integer> ans = new ArrayList();
		HashMap<Integer, Integer> freqMap = new HashMap();
		HashMap<Integer, Stack<Integer>> freqStack = new HashMap();
		int maxFreq = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).get(0) == 1) {
				int a = A.get(i).get(1);
				int freq = freqMap.getOrDefault(a, 0) + 1;
				if (freq > maxFreq)
					maxFreq = freq;
				freqMap.put(a, freq);
				Stack<Integer> s = freqStack.getOrDefault(freq, new Stack<Integer>());
				s.push(a);

				freqStack.put(freq, s);
				ans.add(-1);
			} else {
				int top = freqStack.get(maxFreq).pop();
				freqMap.put(top, freqMap.get(top)-1);
				ans.add(top);
				if(freqStack.get(maxFreq).isEmpty()) {
					maxFreq--;
				}
					
			}
		}
		return ans;

	}
}
