package bitmanipulation;

/*
 * Q3. Smallest XOR
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.



Problem Constraints

0 <= A <= 109
0 <= B <= 30



Input Format

First argument contains a single integer A. Second argument contains a single integer B.



Output Format

Return a single integer X.



Example Input

Input 1:

 A = 3
 B = 3
Input 2:

 A = 15
 B = 2


Example Output

Output 1:

 7
Output 2:

 12


Example Explanation

Explanation 1:

 3 xor 7 = 4 which is minimum
Explanation 2:

 15 xor 12 = 3 which is minimum

 */
public class SmallestXOR {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(9, 3));
	}
	 public static int solve(int A, int B) {
	        int totalSetBitsInA = 0;
	        long a = A;
	        while(A>0){
	            totalSetBitsInA += A&1;
	            A = A/2;
	        }
	        
	        if(totalSetBitsInA<B){
	            for(int i =0;i<31; i++){
	            	long pow = 1l<<i;
	                if((pow&a) != 0 ){
	                    continue;
	                }
	                a= a|(pow);
	                totalSetBitsInA++;
	                if(B==totalSetBitsInA)
	                break;
	            }
	            return (int) a;
	        }else if(totalSetBitsInA > B){
	        	
	             for(int i =0;i<31; i++){
	            	 long pow = 1l<<i;
	                if(((1l<<i)&a) == 0 ){
	                    continue;
	                }
	                a= a^(1<<i);
	                totalSetBitsInA --;
	                if(B==totalSetBitsInA)
	                break;
	            }
	            return (int) a;
	        }else{
	            return (int) a;
	        }
	    }
}
