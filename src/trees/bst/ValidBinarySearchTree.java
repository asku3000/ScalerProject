package trees.bst;

import java.util.ArrayList;

import trees.TreeNode;

/*
 * Q2. Valid Binary Search Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return 0 if false and 1 if true.



Example Input

Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.

 */
public class ValidBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		System.out.println(isValidBST(root));

	}

	public static int isValidBST(TreeNode A) {

		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		inOrderTraversal(A, inOrder);
		for (int i = 1; i < inOrder.size(); i++) {
			if (inOrder.get(i) <= inOrder.get(i - 1)) {
				return 0;
			}
		}
		return 1;
	}

	private static void inOrderTraversal(TreeNode A, ArrayList<Integer> inOrder) {
		if (A == null) {
			return;
		}
		inOrderTraversal(A.left, inOrder);
		inOrder.add(A.val);
		inOrderTraversal(A.right, inOrder);
	}

}
