package BasicsOfMath;

import java.util.ArrayList;
import java.util.Collections;

public class ExcelTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(1));
	}

	public static String convertToTitle(int A) {
		
        StringBuilder res= new StringBuilder("");
       while(A>0){
           res.append(String.valueOf(
               (char)('A' + A%26))
               );
           A = (A-1)/26;
       }
       return res.toString();
		

		/*
		 * ArrayList<Integer> result = new ArrayList<Integer>();
		 * 
		 * while (A > 0) { result.add(A % 26); A = A / 26; }
		 * Collections.reverse(result); StringBuilder res = new StringBuilder(""); for
		 * (Integer i : result) { if (i == 0) { res.append(String.valueOf('Z')); } else
		 * { res.append(String.valueOf((char) ('A' + (i - 1)))); } }
		 * 
		 * return res.toString();
		 */
	}

}
