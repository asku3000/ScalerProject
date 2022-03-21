package greedy;

import java.util.ArrayList;

/*
 * Q4. Binary Strings
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given a string A consisting of 1's and 0's. Now the task is to make the string consisting of only 1's. But you are allowed to perform only the following operation:

Take exactly B consecutive elements of string and change 1 to 0 and 0 to 1.
Each operation takes 1 unit time so you have to determine the minimum time required to make the string of 1's only. If not possible return -1.



Problem Constraints

2 ≤ length of A ≤ 105
2 ≤ B ≤ (length of A)



Input Format

First argument is a string A consisting if 1's and 0's.
Second argument is an integer B which represents the number of consecutive elements which can be changed.



Output Format

Return an integer which is the minimum time to make the string of 1's only or -1 if not possible.



Example Input

Input 1:

 A = "00010110"
 B = 3
Input 2:

 A = "011"
 B = 3


Example Output

Output 1:

 3
Output 2:

 -1


Example Explanation

Explanation 1:

 You can get 1 by first changing the leftmost 3 elements, getting to 11110110, then the rightmost 3, getting to 11110001, 
 and finally the 3 left out 0's to 11111111; In 3 unit time.
Explanation 2:

It's not possible to convert the string into string of all 1's.

 */
public class BinaryStrings {

	public static void main(String[] args) {
		System.out.println(solve(
				"1110001101011111100101010010000101111011000111111011011111111110010000100101001100100011100011110111000000001111001111100000111100001101100001100011000000100110111111110010000000011101110110101000101001010001100010110000000110001111011001111101101101100001000000110011000011111011001000101011010001100001110010010011011110100110011001011111110110011011111100011110111000110010100111100011101100110011000110111101010101110011001111111100010100101101101110011110011111111001000100010100010111100101100010101001111111111111010111111111000110011110000010011111100000011100110001001",
				160));// TODO Auto-generated method stub

	}

	public static int solve(String A, int B) {
		int ans = 0;
		ArrayList<Integer> a = new ArrayList();
		for (int i = 0; i < A.length(); i++) {
			a.add(0);
		}
		int xr = 0;
		int i = 0;
		for (i = 0; i <= A.length() - B; i++) {
			xr ^= a.get(i);

			if ((xr == 0 && A.charAt(i) == '0') || (xr == 1 && A.charAt(i) == '1')) {
				ans++;
				if (i + B < A.length()) {
					a.set(i + B, 1);
				}
				xr = 1 - xr;
			}

		}

		while (i < a.size()) {
			xr ^= a.get(i);
			int val = A.charAt(i) - '0';
			if ((val ^ xr) == 0) {
				return -1;
			}
			i++;
		}

		return ans;
	}
}
