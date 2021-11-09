package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XorQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> A = Arrays.asList(new Integer[] { 1, 0, 0, 0, 1 });
		List<List<Integer>> B = new ArrayList<List<Integer>>();
		
		B.add(Arrays.asList(new Integer[] {2, 4}));
		B.add(Arrays.asList(new Integer[] {1, 5}));
		B.add(Arrays.asList(new Integer[] {3, 5}));
		
		for(List<Integer> a: solve(A, B)) {
			System.out.println(a.get(0)+" "+a.get(1));
		}
	}

public static ArrayList<ArrayList<Integer>> solve(List<Integer> A, List<List<Integer>> B) {
        
        ArrayList<Integer> prefixSum = new ArrayList();
        prefixSum.add(A.get(0));
        for(int i=1; i<A.size(); i++){
            prefixSum.add( A.get(i) + prefixSum.get(i-1));
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        for(int i=0; i< B.size(); i++){
            ArrayList<Integer> ans = new ArrayList();
            int pfSum = 0;
            if(B.get(i).get(0) == 1){
                pfSum = prefixSum.get(B.get(i).get(1) -1);
            }else{
                pfSum = prefixSum.get(B.get(i).get(1) -1) - prefixSum.get(B.get(i).get(0) -2);
            }
            
            if(pfSum % 2==0){
                ans.add(0);
            }else{
                ans.add(1);
            }
            
            ans.add((B.get(i).get(1)-B.get(i).get(0)+1) - pfSum);
            res.add(ans);
        }
        return res;
        
    }
}
