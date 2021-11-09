package modulararithmetic;

import java.util.Arrays;
import java.util.List;

public class PairSumDivisibleByM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] {1,2,3,4,5}), 2));

	}
	
	public static int solve(List<Integer> A, int B) {
        int [] count = new int[B];
        int mod = 1000000007;
        //counting number of pairs for remainder
        for(int i =0; i< A.size(); i++){
            int remainder = A.get(i)%B;
            count[remainder] = count[remainder] + 1;
        }
        
        long ans =0;
        ans = (count[0]*(count[0]-1))/2;
        ans%= mod;
        
        int i = 1, j = B-1;
        
        while(i<=j){
            if(i==j){
                ans+= (count[B/2] * (count[B/2]-1))/2;
                ans%= mod;
            }else{
                ans += count[i] * count[j];
                ans%= mod;
            }
            i++;
            j--;
            
        }
        return (int) ans;
    }

}
