package searching;

import java.util.Arrays;
import java.util.List;

public class UniqueELement {
	
	public static void main(String args[]) {
		List<Integer> A = Arrays.asList(new Integer[] {13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493 });
		System.out.println(solve(A));
	}
	
	public static int solve(List<Integer> A) {
        int l=0, r=A.size()-1;
        int mid =0;
        while(l<=r){
            mid = l+(r-l)/2;
            if((mid==0 || !A.get(mid).equals(A.get(mid-1))) && (mid==A.size()-1 || !A.get(mid).equals(A.get(mid+1)))){
                return A.get(mid);
            }
            if(mid==0 || !A.get(mid).equals(A.get(mid-1))){
                if(mid%2==0)
                    l=mid+1;
                else
                    r=mid-1;
            }
           else{
                if(mid%2==0)
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return -1;

    }

}
