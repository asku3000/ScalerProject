package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairsWithGivenSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] {1, 2, 6, 6, 7, 9, 9 }), 13));
	}
	
	public static int solve(List<Integer> A, int B) {
        HashMap<Integer, Integer> freq = new HashMap();
        for(Integer i: A){
            if(freq.get(i) == null){
                freq.put(i, 1);
            }else{
                freq.put(i, freq.get(i)+1);
            }
        }

        long ans = 0;
        long mod = 1000000007;
        for(int i=0; i<A.size(); i++){
            int secondEle = B-A.get(i);
            freq.put(A.get(i), freq.get(A.get(i))-1);
            if(freq.get(secondEle) != null){
                ans = (ans%mod + (freq.get(secondEle))%mod)%mod;
            }
            freq.put(A.get(i), freq.get(A.get(i))+1);
        }
        ans = ans/2;
        return (int) (ans%mod);
    }


}
