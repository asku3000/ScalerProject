package trees;

/*
 * Q5. Balanced Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints

1 <= size of tree <= 100000



Input Format

First and only argument is the root of the tree A.



Output Format

Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input

Input 1:

    1
   / \
  2   3
Input 2:

 
       1
      /
     2
    /
   3


Example Output

Output 1:

1
Output 2:

0


Example Explanation

Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
Difference = 2 > 1. 


 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
//		root.right.right.right = new TreeNode(1);
//		root.right.right.right.right = new TreeNode(2);
		System.out.println(isBalanced(root) == 1 ? "Balanced" : "Not Balanced");

	}

	public static int isBalanced(TreeNode A) {
		if (A == null) {
			return 1;
		}

		int l = height(A.left);
		int r = height(A.right);

		if (Math.abs(r - l) <= 1 && isBalanced(A.left) == 1 && isBalanced(A.right) == 1) {
			return 1;
		}
		return 0;
	}

	private static int height(TreeNode A) {
		if (A == null) {
			return 0;
		}
		int l = height(A.left);
		int r = height(A.right);
		return 1 + Math.max(l, r);

	}
}
