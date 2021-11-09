package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] {186, 256, 102, 377, 186, 377});
		for(Integer a: solve(A)) {
			System.out.println(a);
		}

	}
	public static ArrayList<Integer> solve(List<Integer> A) {
        int xor = A.get(0);
        for(int i=1; i<A.size(); i++){
            xor = xor^A.get(i);
        }

        int firstSetBit = xor - (xor & (xor-1));

        int setBitSet = 0;
        int unsetBitSet = 0;

        for(int i=0; i<A.size(); i++){
            if((A.get(i) & firstSetBit) == firstSetBit){
                setBitSet = setBitSet^A.get(i);
            }else{
                unsetBitSet = unsetBitSet^A.get(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(setBitSet<unsetBitSet){
            ans.add(setBitSet);
            ans.add(unsetBitSet);
        }else{
            ans.add(unsetBitSet);
            ans.add(setBitSet);
        }

        return ans;
    }

}
