package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Q3. Free Cars
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given two arrays A and B of size N. A[i] represents the time by which you can buy ith car without paying any money.

B[i] represents the profit you can earn by buying ith car. It takes 1 minute to buy a car so, you can only buy the ith car when the current time <= A[i] - 1.

Your task is to find maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:

You can stary buying from time = 0.
Return you answer modulo 109 + 7.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109



Input Format

First argument is an integer array A represents the deadline of buying the cars.
Second argument is an integer array B represents the profit obtained after buying the cars.



Output Format

Return an integer denoting the maximum profit you can earn.



Example Input

Input 1:

 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
Input 2:

 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]


Example Output

Output 1:

 20
Output 2:

 30


Example Explanation

Explanation 1:

 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
Explanation 2:

 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.


 */
public class FreeCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				solve(Arrays.asList(new Integer[] { 1, 3, 2, 3, 3 }), Arrays.asList(new Integer[] { 5, 6, 1, 3, 9 })));
	}

	public static int solve(List<Integer> A, List<Integer> B) {
		ArrayList<PairCars> cars = new ArrayList<PairCars>();
		for (int i = 0; i < A.size(); i++) {
			cars.add(new PairCars(A.get(i), B.get(i)));
		}

		Collections.sort(cars, (PairCars p1, PairCars p2) -> {
			if (p1.time > p2.time)
				return 1;
			else if (p1.time == p2.time) {
				if (p1.profit > p2.profit)
					return 1;
				else if (p1.profit < p2.profit) {
					return -1;
				}
				return 0;
			} else
				return -1;
		});

		int t = 0;
		PriorityQueue<PairCars> minHeap = new PriorityQueue<PairCars>(new PairCarProfitComparator());
		for (int i = 0; i < cars.size(); i++) {
			if (t < cars.get(i).time) {
				minHeap.add(cars.get(i));
				t++;
			} else {
				if (cars.get(i).profit > minHeap.peek().profit) {
					minHeap.poll();
					minHeap.add(cars.get(i));
				}
			}
		}
		long profit = 0;
		long mod = 1000000007;
		while (!minHeap.isEmpty()) {
			profit =  ((profit%mod) + (minHeap.poll().profit%mod))%mod;
		}

		return (int) profit;
	}

}

class PairCars {
	int time;
	int profit;

	public PairCars(int time, int profit) {
		this.time = time;
		this.profit = profit;
	}

}

class PairCarProfitComparator implements Comparator<PairCars> {

	@Override
	public int compare(PairCars o1, PairCars o2) {
		if (o1.profit > o2.profit) {
			return 1;
		} else if (o1.profit == o2.profit) {
			return 0;
		} else {
			return -1;
		}
	}

}
