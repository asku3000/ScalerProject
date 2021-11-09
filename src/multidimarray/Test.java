package multidimarray;

public class Test {
	
	public static void main(String [] args) {
		int A =15;
		int count = 0;
		while(A>0) {
			if((A&1) == 1) {
				count++;
			}
			A = A>>1;
		}
		System.out.println(count);
	}

}
