package multidimarray;

import java.util.ArrayList;

public class RotateNinetyDegrees {
	
		public static void main(String [] args) {
			
		}
	
	
	   public static void solve(ArrayList<ArrayList<Integer>> A) {
		   
		   // 1st (i,j)
		   // 2nd (j, n-i-1)
		   // 3rd (n-i-1, n-j-1)
		   // 4th (n-j-1, i)
		   int n = A.size();
		   for(int i=0; i<n/2; i++) {
			   for(int j=0; j<n-i-1; j++) {
				   int temp = A.get(i).get(j);
				   // 1st replaced by 4th
				   A.get(i).set(j, A.get(n-j-1).get(i));
				   //4th replaced by 3rd
				   A.get(n-j-1).set(i, A.get(n-i-1).get(n-j-1));
				   //3rd replaced by 2nd
				   A.get(n-i-1).set(n-j-1, A.get(j).get(n-i-1));
				   //2nd replaced by 1
				   A.get(j).set(n-i-1, temp);
			   }
			   
		   }
		   
		   
		   
		   
	    }

}
