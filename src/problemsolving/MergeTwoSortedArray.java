package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[]{-4, 3 });
		List<Integer> B = Arrays.asList(new Integer[] {-2, -2});
		
		for(Integer a: solve(A, B)) {
			System.out.print(a);
		}

	}
	
public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        
        ArrayList<Integer> res = new ArrayList();
        
        int i=0;
        int j=0;
        
        while(i<A.size() && j<B.size()){
            
            if(A.get(i) < B.get(j)){
                res.add(A.get(i));
                i++;
            }else{
                res.add(B.get(j));
                j++;
            }
            
        }
        
        while(i<A.size()){
            res.add(A.get(i));
            i++;
        }        
        
        while(j<B.size()){
            res.add(B.get(j));
            j++;
        }
        
        return res;
    }

}
