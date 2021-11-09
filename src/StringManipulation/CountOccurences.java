package StringManipulation;

public class CountOccurences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abbobabtbobl"));
	}
	
	
	 public static int solve(String A) {
	        int i =0;
	        int count = 0;
	        while(i<A.length()) {
	        	
	        	if(A.indexOf("bob", i) >= 0) {
	        		count++;
	        		i = A.indexOf("bob", i)+2;
	        	}else {
	        		return count;
	        	}
	        	
	        }
	        return count;}

}
