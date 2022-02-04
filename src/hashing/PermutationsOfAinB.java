package hashing;

/**
 * Q2. Permutations of A in B
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints

1 <= N < M <= 105



Input Format

Given two argument, A and B of type String.



Output Format

Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input

Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output

Output 1:

 5
Output 2:

 2


Example Explanation

Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
 * @author ASHISH KUMAR
 *
 */
public class PermutationsOfAinB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("aca", "acaa"));

	}
	
	public static int solve(String A, String B) {
        int freq[] = new int[26];
        int need = A.length();
        int count =0;
        for(int i=0; i<need; i++){
            freq[A.charAt(i)-'a']++;
        }
        
        for(int i=0; i<A.length(); i++){
            freq[B.charAt(i)-'a']--;
            if(freq[B.charAt(i)-'a'] >= 0) {
            	need--;
            }
        }
        
        if(need == 0) {
        	count++;
        }
        
        for(int i=A.length(); i<B.length(); i++) {
        	freq[B.charAt(i)-'a']--;
        	freq[B.charAt(i-A.length())-'a']++;
        	if(B.charAt(i) != B.charAt(i-A.length())) {
        		if(freq[B.charAt(i)-'a'] >= 0) {
        			need--;
        		}
        		
        		if(freq[B.charAt(i-A.length())-'a']>0) {
        			need++;
        		}
        	}
        	if(need == 0) {
        		count++;
        	}
        }
        
        return count;
    }

}
