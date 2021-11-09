package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] {4,4,4,2});
		System.out.println(singleNumber(A));
	}
	
	public static int singleNumber(final List<Integer> A) {
        ArrayList<Integer> bits = new ArrayList<Integer>();
        for(int i=0; i<32; i++ ){
            Integer bitSum =0;
            for(int j=0; j<A.size(); j++){
                bitSum += ((A.get(j)>>i)&1);
            }
            bits.add(bitSum);
        }
        int ans =0;
        for(int i=0; i<bits.size(); i++){
            ans+= (1<<i)*(bits.get(i)%3);
        }
        return ans;
    }

}
