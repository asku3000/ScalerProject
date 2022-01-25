package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleCommonElements {

	public static void main(String[] args) {
		Integer [] a = {1, 2, 2, 1};
		Integer [] b = { 2, 3, 1, 2};
		
		ArrayList<Integer> result = solve(Arrays.asList(a),Arrays.asList(b));
		
		for(Integer i: result) {
			System.out.print(i+", ");
		}

	}
	 public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
	        
	        HashMap<Integer, Integer> mapA = new HashMap();
	        
	        for(int i =0; i<A.size(); i++){
	            if(mapA.get(A.get(i)) != null){
	                mapA.put(A.get(i), mapA.get(A.get(i))+1);
	            }else{
	                mapA.put(A.get(i), 1);
	            }
	        }
	        
	        HashMap<Integer, Integer> mapB = new HashMap();
	        
	        for(int i =0; i<B.size(); i++){
	            if(mapB.get(B.get(i)) != null){
	                mapB.put(B.get(i), mapB.get(B.get(i))+1);
	            }else{
	                mapB.put(B.get(i), 1);
	            }
	        }
	        ArrayList<Integer> result = new ArrayList();
	        
	        for(Map.Entry<Integer, Integer> entry: mapA.entrySet()) {
				int count = 0;
				
				if(mapB.get(entry.getKey()) != null){
				    count = Math.min(entry.getValue(), mapB.get(entry.getKey()));
				}else{
				    continue;
				}
				
				while(count>0){
				    result.add(entry.getKey());
				    count--;
				}
			}
			
			return result;
	        
	    }
}
