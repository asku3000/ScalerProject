package combinatorics;

public class Summation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4));

	}
	

    public static int solve(int A) {
        long mod = 1000000007;
        long ans = (A%mod)*((A-1)%mod);
        long a = A;
        return (int) ((ans * calcThroughFastPower(3, a-2, mod))%mod);
    }

    public static int calcThroughFastPower(long n, long b, long m){
        if(b==0) return 1;
        if((b&1)==0){
            return (int) calcThroughFastPower((n*n)%m, b/2, m);
        }else{
            return (int) ((n*calcThroughFastPower((n*n)%m, (b-1)/2, m))%m);
        }
    }

}
