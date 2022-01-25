package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		Integer [] a = {10, 5, 3, 4, 3, 5, 6};
		List<Integer> list = Arrays.asList(a);
		
		System.out.println(solve(list));

	}

	public static int solve(List<Integer> A) {
		int result = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i<A.size(); i++) {
			if(map.get(A.get(i)) != null) {
				result = Math.min(result, map.get(A.get(i)));
			}else {
				map.put(A.get(i), i);
			}
		}
		
		
		
		
		return result == Integer.MAX_VALUE ? -1: A.get(result);
	}

}
