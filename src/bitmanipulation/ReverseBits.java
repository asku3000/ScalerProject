package bitmanipulation;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(3l));
	}
	
	public static long reverse(long a) {
        long ans =0;
        for(int i =0; i<31; i++){
        	long ithBit = a&1;
        	a = a>>1;
            ans = ans | ithBit;
            ans = ans<<1;
        }
        return ans;
	}

}
