package trees;

public class MaxPathSum {

	/*
	 * Q1. Max Sum Path in Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints

1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



Input Format

The first and the only argument contains a pointer to the root of T, A.



Output Format

Return an integer representing the maximum sum path.



Example Input

Input 1:

  
    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50


Example Output

Output 1:

 6
Output 2:

 40


Example Explanation

Explanation 1:

     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:

     The path with maximum sum is: 20 -> 20
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-100);
		root.left = new TreeNode(-200);
//		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-300);
		root.left.right = new TreeNode(-400);
		System.out.println(maxPathSum(root));
	}

	static long ans;

	public static int maxPathSum(TreeNode A) {
		ans = Integer.MIN_VALUE;
		findMaxPathSum(A);
		return (int) ans;
	}

	private static long findMaxPathSum(TreeNode A) {
		if (A == null) {
			return 0;
		}

		long l = findMaxPathSum(A.left);
		long r = findMaxPathSum(A.right);

		
		ans = Math.max(ans, A.val + Math.max(l, 0) + Math.max(r, 0));
        // ans = Math.max(ans, A.val+l);
        // ans = Math.max(ans, A.val+r);
        // ans = Math.max(ans, A.val+l+r);

		// if (l <= 0 && r <= 0) {
		// 	ans = Math.max(ans, A.val);
		// 	return A.val;
		// }

		return Math.max(Math.max(l, r)+A.val, A.val);
	}

}
