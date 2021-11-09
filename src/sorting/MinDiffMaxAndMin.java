package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinDiffMaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer [] arr = {1, 1, 7 };
		System.out.println(solve(Arrays.asList(arr), 7));

	}
	

    public static int solve(List<Integer> A, int B) {
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i =0; i < A.size(); i++){
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
            if(map.get(A.get(i)) != null){
                map.put(A.get(i), map.get(A.get(i))+1);
            }else{
                map.put(A.get(i), 1);
            }
        }
        
        
        while((min<max) && B!=0){
            if( map.get(min) < map.get(max)){
                if(B<map.get(min)){
                    break;
                }
                
                map.put(min+1,  map.get(min+1) == null ? map.get(min) : map.get(min+1) + map.get(min));
                B=B-map.get(min);
                min++;
                
            }else{
                if(B<map.get(max)){
                    break;
                }
                
                map.put(max-1, map.get(max-1) == null ? map.get(max) : map.get(max-1) + map.get(max));
                B = B-map.get(max);
                max--;
            }
        }
        
        return max-min;
    }


}
