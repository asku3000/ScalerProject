package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q2. Reverse Level Order
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree, return the reverse level order traversal of its nodes values. (i.e, from left to right and from last level to starting level).



Problem Constraints

1 <= number of nodes <= 5 * 105

1 <= node value <= 105



Input Format

First and only argument is a pointer to the root node of the Binary Tree, A.



Output Format

Return an integer array denoting the reverse level order traversal from left to right.



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

 [15, 7, 9, 20, 3] 
Output 2:

 [3, 6, 2, 1]


Example Explanation

Explanation 1:

 Nodes as level 3 : [15, 7]
 Nodes at level 2: [9, 20]
 Nodes at level 1: [3]
 Reverse level order traversal will be: [15, 7, 9, 20, 3]
Explanation 2:

 Nodes as level 3 : [3]
 Nodes at level 2: [6, 2]
 Nodes at level 1: [1]
 Reverse level order traversal will be: [3, 6, 2, 1]
 */
public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		
		for(Integer i: solve(root)) {
			System.out.print(i+",");
		}
	}
	
	public static ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> q = new LinkedList();
		q.add(A);
		ArrayList<Integer> ans = new ArrayList();
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			ans.add(temp.val);
			if(temp.right != null) {
				q.add(temp.right);
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			
			
		}
		Collections.reverse(ans);
		return ans;
    }

}
