package bitmanipulation;

public class BinaryStrings {

	public static void main(String[] args) {
		String A= "1010110111001101101000";
		String B = "1000011011000000111100110";
		System.out.println(addBinary(A, B));
	}

	 public static String addBinary(String A, String B) {
	        int i=A.length()-1, j=B.length()-1;
	        int sum =0;
	        StringBuilder result = new StringBuilder("");
	        while(i>=0 && j>=0){
	            sum += A.charAt(i) == '1'? 1:0;
	            sum += B.charAt(j) == '1'? 1:0;
	            result.append(String.valueOf((char)(sum%2+'0')));
	            sum = sum/2;
	            i--;j--;
	        }

	        while(i>=0){
	            sum+= A.charAt(i) == '1' ? 1:0;
	            result.append(String.valueOf((char)(sum%2+'0')));
	            sum =sum/2;
	            i--;
	        }

	        
	        while(j>=0){
	            sum+= B.charAt(j) == '1' ? 1:0;
	            result.append(String.valueOf((char)(sum%2+'0')));
	            sum =sum/2;
	            j--;
	        }
	        
	        if(sum>0) {
	        	result.append('1');
	        }

	        return result.reverse().toString();
	    }
}
