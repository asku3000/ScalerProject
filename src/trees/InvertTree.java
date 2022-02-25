package trees;

import java.util.ArrayList;

/*
 * Q6. Invert the Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree A, invert the binary tree and return it.

Inverting refers to making left child as the right child and vice versa.



Problem Constraints

1 <= size of tree <= 100000



Input Format

First and only argument is the head of the tree A.



Output Format

Return the head of the inverted tree.



Example Input

Input 1:

 
     1
   /   \
  2     3
Input 2:

 
     1
   /   \
  2     3
 / \   / \
4   5 6   7


Example Output

Output 1:

 
     1
   /   \
  3     2
Output 2:

 
     1
   /   \
  3     2
 / \   / \
7   6 5   4


Example Explanation

Explanation 1:

Tree has been inverted.
Explanation 2:

Tree has been inverted.
 */
public class InvertTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeNode A = invertTree(root);

		for (ArrayList<Integer> list : LevelOrderTraversal.levelOrder(A)) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}
	}

	public static TreeNode invertTree(TreeNode A) {

		if (A == null) {
			return null;
		}
		
		TreeNode temp = A.left;
		A.left = A.right;
		A.right = temp;
		
		invertTree(A.left);
		invertTree(A.right);
		return A;
	}

}
