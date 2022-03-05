package trees.bst;

import java.util.ArrayList;

import trees.LevelOrderTraversal;
import trees.TreeNode;

/*
 * Q1. Sorted Array To Balanced BST
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints

1 <= length of array <= 100000



Input Format

First argument is an integer array A.



Output Format

Return a root node of the Binary Search Tree.



Example Input

Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output

Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation

Explanation 1:

 You need to return the root node of the Binary Tree.


 */
public class BalancedBstFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int[] A = { 1, 3, 5, 8, 10, 15, 18, 20 };
		ArrayList<ArrayList<Integer>> ans = LevelOrderTraversal.levelOrder(sortedArrayToBST(A));

		for (ArrayList<Integer> list : ans) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}

	}

	public static TreeNode sortedArrayToBST(final int[] A) {
		TreeNode root = construct(A, 0, A.length - 1);
		return root;
	}

	private static TreeNode construct(int[] a, int l, int r) {

		if (l > r)
			return null;
		int mid = l + (r - l) / 2;

		TreeNode temp = new TreeNode(a[mid]);

		temp.left = construct(a, l, mid - 1);
		temp.right = construct(a, mid + 1, r);
		return temp;
	}

}
