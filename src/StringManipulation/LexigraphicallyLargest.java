package StringManipulation;

import java.util.Arrays;

public class LexigraphicallyLargest {

	public static void main(String[] args) {
		System.out.println(getLargest("abqzzzzzz_qwerty"));

	}
	
	
	 public static String getLargest(String A) {
	        
	        String s = A.substring(0, A.indexOf("_"));
	        
	        String t = A.substring(A.indexOf("_") + 1, A.length());
	        
	        //sortDescending T
	        char tempArray [] = t.toCharArray();
	        Arrays.sort(tempArray);
	        
	        t = new String(tempArray);
	        
	        StringBuilder ans = new StringBuilder(s);
	        
	        int i =0;
	        int j = t.length()-1;
	        
	        while(i<s.length() && j>=0) {
	        	if(s.charAt(i) < t.charAt(j)) {
	        		ans.replace(i, i+1, String.valueOf(t.charAt(j)));
	        		j--;
	        	}
	        	i++;
	        }
	        
	        
	        return ans.toString();
	        
	        
	    }

}
