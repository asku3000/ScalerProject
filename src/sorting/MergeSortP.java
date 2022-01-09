package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer[] {45, 10, 15, 25, 50});
		mergeSort(a, 0, a.size()-1);
		for(Integer i: a) {
			System.out.print(i+",");
		}
	}

	static void mergeSort(List<Integer> a, int l, int r) {
		if (l < r) {
			int mid = l + ((r - l) / 2);
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private static void merge(List<Integer> a, int l, int mid, int r) {
		int i = l, j=mid+1;
		ArrayList<Integer> temp = new ArrayList();
		while(i<= mid && j<=r) {
			if(a.get(i)<a.get(j)) {
				temp.add(a.get(i));
				i++;
			}else {
				temp.add(a.get(j));
				j++;
			}
		}
		
		while(i<= mid) {
			temp.add(a.get(i));
			i++;
		}
		
		while(j<=r) {
			temp.add(a.get(j));
			j++;
		}
		
		for(int k=l; k<=r; k++) {
			a.set(k, temp.get(k-l));
		}
	}

}
