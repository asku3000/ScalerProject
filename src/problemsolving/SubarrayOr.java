package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayOr {

	public static void main(String[] args) {
		
		System.out.println(solve(Arrays.asList(new Integer[] {1, 2, 3, 4, 5 })));
		
	}
	
	
	 public static int solve(List<Integer> A) {
	        
	        long ans =0;
	        for(int i=0; i<32; i++){
	            ArrayList<Integer> bits = new ArrayList();
	            for(int j=0;j<A.size(); j++){
	                bits.add((A.get(j)>>i) & 1);
	            }
	            
	            ans += Math.pow(2, i) * getSubarrSumOfZeroAndOne(bits);
	            
	        }
	        
	        return (int) (ans %1000000007);
	    }
	
	public static int getSubarrSumOfZeroAndOne(ArrayList<Integer> bits){
        int j =0, totalz = 0, cz =0;
            
            while(j<bits.size()){
                if(bits.get(j).equals(1)){
                    totalz += (cz*(cz+1))/2;
                    cz =0;
                }else{
                    cz++;
                }
                
                j++;
            }
            
            totalz += (cz*(cz+1))/2;
            
            return (bits.size()*(bits.size()+1))/2 - totalz;
    }

}
