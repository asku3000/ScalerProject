package modulararithmetic;

import java.util.ArrayList;
import java.util.Collections;

public class PowersOf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Integer a: solve(411)) {
			System.out.print(a+" ");
		}
	}
	

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> baseConverted = new ArrayList();
        while (A >0){
            baseConverted.add(A%3);
            A = A/3;
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int i =0; i<baseConverted.size(); i++){
            for(int j = 1; j<=baseConverted.get(i); j++){
                ans.add((int)Math.pow(3,i));
            }
        }
        return ans;
    }

}
