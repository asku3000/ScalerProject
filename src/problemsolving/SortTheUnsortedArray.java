package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheUnsortedArray {

	public static void main(String[] args) {
		Integer [] a = {-146316343, 179840175, 760528516 };
		System.out.println(solve(Arrays.asList(a)));

	}
	
	 public static int solve(List<Integer> A) {
	        
	        ArrayList<Integer> sorted = new ArrayList();
	        sorted.addAll(A);
	        Collections.sort(sorted);
	        
	        int start =0;
	        int end = A.size()-1;
	        
	        while(start<=end){
	            if(A.get(start) == sorted.get(start)){
	                start++;
	            }else if(A.get(end) == sorted.get(end)){
	                end--;
	            }else{
	                break;
	            }
	        }
	        
	        return end-start+1;
	    }

}
