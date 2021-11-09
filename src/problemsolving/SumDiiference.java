package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumDiiference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a = {5, 4, 2 };
		System.out.println(solve(Arrays.asList(a)));

	}

	public static int solve(List<Integer> A) {
		ArrayList<Long> power = new ArrayList();
        power.add((long) 1);
        
        for(int i=1; i<A.size(); i++){
            power.add((long)(2*power.get(i-1))%1000000007);
        }
        
		
		Collections.sort(A);
		int max = 0;

		for (int i = 0; i < A.size(); i++) {
			max += (1 << i) * A.get(i);
		}

		int min = 0;

		for(int i=A.size()-1; i>=0; i--){
            min += (power.get((A.size()-i)-1)* A.get(i))%1000000007;
                
        }

		return max - min;
	}

}
