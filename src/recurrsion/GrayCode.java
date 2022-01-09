package recurrsion;

import java.util.ArrayList;

/*
 * Q2. Gray Code
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints

1 <= A <= 16



Input Format

First argument is an integer A.



Output Format

Return an array of integers representing the gray code sequence.



Example Input

Input 1:

A = 2
Input 1:

A = 1


Example Output

output 1:

[0, 1, 3, 2]
output 2:

[0, 1]


Example Explanation

Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
 */
public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer i: grayCode(3)) {
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ans = new ArrayList();
         ArrayList<Integer> root = new ArrayList();
        solve(a, ans, root);
        return ans;
	}

    static void solve(int a, ArrayList<Integer> ans,  ArrayList<Integer> root){
        if(a == 1){
            ans.add(0);
            ans.add(1);
            return ;
        }

        solve(a-1, ans, root);
        root = ans;
        for(int i=root.size()-1; i>=0; i--){
            int val = root.get(i);
            val = (1<<(a-1))^val;
            ans.add(val);
        }
    }

}
