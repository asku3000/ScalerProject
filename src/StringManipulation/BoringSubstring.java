package StringManipulation;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Q1. Boring substring
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

The only argument given is string A.



Output Format

Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input

Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:

 No arrangement of string A can make it free of boring substrings.

 */
public class BoringSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abcd"));
	}
	
	public static int solve(String A) {
	       ArrayList<Character> odd = new ArrayList();
	       ArrayList<Character> even = new ArrayList();
	       for(int i=0; i<A.length(); i++){
	           if(A.charAt(i) % 2== 0){
	               even.add(A.charAt(i));
	           }else{
	               odd.add(A.charAt(i));
	           }
	       }

	       Collections.sort(odd);
	       Collections.sort(even);

	       if(Math.abs(odd.get(odd.size()-1)-even.get(0)) != 1){
	           return 1;
	       }else if(Math.abs(even.get(even.size()-1)-odd.get(0)) != 1){
	           return 1;
	       }

	       return 0;
	    }

}
