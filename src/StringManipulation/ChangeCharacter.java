package StringManipulation;

import java.util.Arrays;

public class ChangeCharacter {

	public static void main(String[] args) {
		System.out.println(solve("ircvscxggbwkfnqd", 2));

	}
	

    public static int solve(String A, int B) {
        
        int freq [] = new int[26];
        
        for(int i =0; i< A.length(); i++){
            
            freq[A.charAt(i) - 'a'] = freq[A.charAt(i) - 'a'] +1;
            
        }
        
        Arrays.sort(freq);
        
        if(B==0) {
        	return A.length();
        }
        
        for(int i =0; i< freq.length; i++){
            
        	
        	if(B>=freq[i] && B>0){
        		B = B-freq[i];
        		freq[i] =0;
            }
        }
        int ans =0;
        for(int i = 0; i<freq.length; i++) {
        	if(freq[i] != 0) {
        		ans++;
        	}
        }
        
        return ans;
    }


}
