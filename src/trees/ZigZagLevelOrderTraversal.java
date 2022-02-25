package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q1. ZigZag Level Order Traversal BT
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input

Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [2, 6]
   [3]
 ]


Example Explanation

Explanation 1:

 Return the 2D array. Each row denotes the zigzag traversal of each level.


 */
public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
//		root.right.right.right = new TreeNode(1);
//		root.right.right.right.right = new TreeNode(2);
		for (ArrayList<Integer> list : zigzagLevelOrder(root)) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(A);
		q.add(null);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner = new ArrayList<>();
		int level = 1;
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			if (temp == null && q.isEmpty()) {
				 if (level % 2 == 0) {
						Collections.reverse(inner);
					}
					ans.add(inner);
					break;
			}

			if (temp == null) {
				if (level % 2 == 0) {
					Collections.reverse(inner);
				}
				ans.add(inner);
				level++;
				inner = new ArrayList<Integer>();
				q.add(null);
				continue;
			}

			inner.add(temp.val);
			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}

		}

		return ans;

	}
}
