package recurrsion;

import java.util.Arrays;
import java.util.List;

/*
 * Q3. SIXLETS
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence


 */
public class Sixlets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 2, 8 }), 2));
	}

	static List<Integer> a;

	public static int solve(List<Integer> A, int B) {
		int sum = 0;
		int i = 0;
		a = A;
		return find(i, sum, B);
	}

	static int find(int i, int sum, int b) {
		if (sum > 1000)
			return 0;
		if (0 == b)
			return 1;
		if (i >= a.size())
			return 0;
		return find(i + 1, sum + a.get(i), b - 1) + find(i + 1, sum, b);
	}

}
