package problemsolving;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
	        
	        Collections.sort(arrive);
	        Collections.sort(depart);
	        int arrival =0, depar= 0, countOfRooms = 0;
	        int ans = Integer.MIN_VALUE;
	        
	        while(arrival<arrive.size() && depar<arrive.size()){
	            
	            if(arrive.get(arrival) <= depart.get(depar)){
	                arrival++;
	                countOfRooms++;
	            }else{
	                countOfRooms--;
	                depar++;
	            }
	            ans = Math.max(ans, countOfRooms);
	        }
	        
	        if(K<ans){
	            return false;
	        }
	        
	        return true;
	        
	    }

}
