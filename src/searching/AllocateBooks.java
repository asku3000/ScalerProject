package searching;

import java.util.Arrays;
import java.util.List;

/*
 * Q2. Allocate Books
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array of integers A of size N and an integer B.

College library has N books,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.



NOTE: Return -1 if a valid assignment is not possible.



Problem Constraints

1 <= N <= 105
1 <= A[i], B <= 105



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return that minimum possible number



Example Input

A = [12, 34, 67, 90]
B = 2


Example Output

113


Example Explanation

There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
        Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(books(Arrays.asList(new Integer[] { 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36,
				85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24 }), 26));
	}

	public static int books(List<Integer> A, int B) {
		if (B > A.size()) {
			return -1;
		}

		long max = A.get(0);
		long sum = 0;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, A.get(i));
			sum += A.get(i);
		}

		long l = max, r = sum;
		long ans = 0, mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (check(mid, A, B)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return (int) ans;

	}

	static boolean check(long mid, List<Integer> A, int B) {
		long pages = A.get(0);
		long students = 1;
		for (int i = 1; i < A.size(); i++) {
			pages += A.get(i);
			if (pages > mid) {
				pages = A.get(i);
				students++;
			}
		}

		if (students <= B) {
			return true;
		} else {
			return false;
		}
	}

}
