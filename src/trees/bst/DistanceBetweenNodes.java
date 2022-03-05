package trees.bst;

import trees.TreeNode;

/*
 * Q1. Distance between Nodes of BST
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.



Problem Constraints

1 <= Number of nodes in binary tree <= 1000000

0 <= node values <= 109



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.



Output Format

Return an integer denoting the distance between two nodes with given two keys B and C



Example Input

Input 1:

    
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:

    
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:

 Path between 2 and 6 is: 2 -> 6. Distance will be 1

 */
public class DistanceBetweenNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(32);
		root.left = new TreeNode(25);
		root.right = new TreeNode(46);
		root.left.left = new TreeNode(17);
		root.left.right = new TreeNode(27);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(49);
		root.left.left.left = new TreeNode(9);
		System.out.println(solve(root, 32, 9));

	}

	public static int solve(TreeNode A, int B, int C) {
		if (A == null)
			return 0;

		// Both keys lie in left
		if (A.val > B && A.val > C)
			return solve(A.left, B, C);

		// Both keys lie in right
		if (A.val < B && A.val < C) // same path
			return solve(A.right, B, C);

		// Lie in opposite directions (Root is
		// LCA of two nodes)
		if (A.val >= B && A.val <= C)
			return distanceFromRoot(A, B) + distanceFromRoot(A, C);
		
		if (A.val <= B && A.val >= C)
			return distanceFromRoot(A, B) + distanceFromRoot(A, C);

		return 0;
	}

	static int distanceFromRoot(TreeNode root, int x) {
		if (root.val == x)
			return 0;
		else if (root.val > x)
			return 1 + distanceFromRoot(root.left, x);
		return 1 + distanceFromRoot(root.right, x);
	}
}
