package multidimarray;

import java.util.ArrayList;

public class PatternPrint1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(ArrayList<Integer> innerList: solve(3)) {
			for(Integer i: innerList) {
				System.out.print(i+" ");
			}
			System.out.println("\n");
		}
	}
	
	 public static ArrayList<ArrayList<Integer>> solve(int A) {
	        ArrayList<ArrayList<Integer>> outerList = new ArrayList();
	        
	        for(int i=0; i<A; i++){
	            ArrayList<Integer> innerList = new ArrayList();
	            for(int j=1; j<=i+1; j++){
	                innerList.add(j);
	            }
	            for(int k=innerList.size(); k<A; k++) {
	            	innerList.add(0);
	            }
	            outerList.add(innerList);
	        }
	        
	        return outerList;    
	        
	    }

}
