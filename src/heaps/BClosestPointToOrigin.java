package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q1. B Closest Points to Origin
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
We have a list A of points(x, y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */
public class BClosestPointToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, 3 }));
		A.add(Arrays.asList(new Integer[] { -2, 2 }));
		for (ArrayList<Integer> list : solve(A, 1)) {
			System.out.println("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> solve(ArrayList<List<Integer>> A, int B) {

		PriorityQueue<EDPair> minHeap = new PriorityQueue<>(new EDPairComparator());
		for (int i = 0; i < A.size(); i++) {
			long edDistance = (long) (Math.pow(A.get(i).get(0), 2) + Math.pow(A.get(i).get(1), 2));
			minHeap.add(new EDPair(edDistance, i));
		}

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < B; i++) {
			EDPair pair = minHeap.poll();
			ans.add(new ArrayList<Integer>(A.get(pair.index)));
		}

		return ans;

	}

}

class EDPair {
	long edDistance;
	int index;

	public EDPair(long edDistance, int index) {
		this.edDistance = edDistance;
		this.index = index;
	}

}

class EDPairComparator implements Comparator<EDPair> {

	@Override
	public int compare(EDPair o1, EDPair o2) {
		if (o1.edDistance > o2.edDistance)
			return 1;
		if (o1.edDistance == o2.edDistance)
			return 0;
		else
			return -1;
	}

}