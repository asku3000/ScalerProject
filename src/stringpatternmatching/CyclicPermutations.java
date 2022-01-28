package stringpatternmatching;

/*
 * Q2. Cyclic Permutations
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints

1 ≤ length(A) = length(B) ≤ 105



Input Format

First argument is a string A.
Second argument is a string B.



Output Format

Return an integer denoting the required answer.



Example Input

Input 1:

 A = "1001"
 B = "0011"
Input 2:

 A = "111"
 B = "111"


Example Output

Output 1:

 1
Output 2:

 3


Example Explanation

Explanation 1:

 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".  
 There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
Explanation 2:

 All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
public class CyclicPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("1001", "0011"));
	}
	
	public static int solve(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        for(int i=0; i<A.length()-1; i++){
            sb.append(String.valueOf(A.charAt(i)));
        }

        String s = B+"$"+sb.toString();
        int z[] = new int[s.length()];

        int l=0, r=0;
        for(int i=1; i<s.length(); i++){
            if(i>r){
                int j=i;
                int k=0;
                while(j<s.length() && s.charAt(j)==s.charAt(k)){
                    k++; j++;
                }
                z[i] = k;
                l=i;
                r=j-1;
            }else{
                if(z[i-l] < r-i+1){
                    z[i] = z[i-l];
                }else{
                    int j=r+1, k=r-i+1;
                    while(j<s.length() && s.charAt(j) == s.charAt(k)){
                        k++;j++;
                    }
                    z[i] = k;
                    l=i; r=j-1;
                }
            }
        }
        int count =0;
        for(int i=0; i<z.length; i++){
            if(z[i]==B.length()){
                count++;
            }
        }

        return count;

    }

}
