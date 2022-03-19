package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q2. Finish Maximum Jobs
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

There are N jobs to be done but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish maximum number of jobs. Return the maximum number of jobs you can finish.



Problem Constraints

1 <= N <= 105

1 <= A[i] < B[i] <= 109



Input Format

First argument is an integer array A of size N denoting the start time of the jobs.
Second argument is an integer array B of size N denoting the finish time of the jobs.



Output Format

Return an integer denoting the maximum number of jobs you can finish.



Example Input

Input 1:

 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:

 A = [3, 2, 6]
 B = [9, 8, 9]


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:

 Since all three jobs collide with each other. We can do only 1 job.


See Expected Output
 */
public class FinishMaximumJobs {

	public static void main(String[] args) {
		System.out.println(
				solve(Arrays.asList(new Integer[] { 1, 5, 7, 1 }), Arrays.asList(new Integer[] { 7, 8, 8, 8 })));
	}

	public static int solve(List<Integer> A, List<Integer> B) {
		ArrayList<PairJobs> jobsTimings = new ArrayList<PairJobs>();
		for (int i = 0; i < A.size(); i++) {
			jobsTimings.add(new PairJobs(A.get(i), B.get(i)));
		}

		Collections.sort(jobsTimings, (PairJobs p1, PairJobs p2) -> {
			int end1 = p1.end;
			int end2 = p2.end;

			if (end1 > end2) {
				return 1;
			} else if (end1 == end2) {
				return 0;
			} else {
				return -1;
			}
		});

		int ans = 1;
		PairJobs currPair = jobsTimings.get(0);
		for (int i = 1; i < jobsTimings.size(); i++) {
			PairJobs nextPair = jobsTimings.get(i);
			if (nextPair.start >= currPair.end) {
				ans++;
				currPair = nextPair;
			}
		}

		return ans;

	}
}

class PairJobs {
	int start;
	int end;

	public PairJobs(int start, int end) {
		this.start = start;
		this.end = end;
	}

}
