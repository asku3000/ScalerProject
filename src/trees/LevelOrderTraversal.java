package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q1. Level Order
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



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
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation

Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(6);
		A.right = new TreeNode(2);
		A.right.left = new TreeNode(3);

		for(ArrayList<Integer> list: levelOrder(A)) {
			System.out.print("\n");
			for(Integer i: list) {
				System.out.print(i+",");
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList();

		Queue<TreeNode> q = new LinkedList();
		q.add(A);
		q.add(null);
		ArrayList<Integer> inner = new ArrayList();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			
			if(temp == null && q.isEmpty()) {
				ans.add(inner);
				break;
			}
			
			if(temp == null) {
				ans.add(inner);
				inner = new ArrayList<Integer>();
				q.add(null);
				continue;
			}
			
			inner.add(temp.val);
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
		return ans;
	}

}
