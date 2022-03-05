package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q2. Serialize Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints

1 <= number of nodes <= 105



Input Format

Only argument is a A denoting the root node of a Binary Tree.



Output Format

Return an integer array denoting the Level Order Traversal of the given Binary Tree.



Example Input

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:

 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2:

 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Explanation

Explanation 1:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class SerializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		for (Integer i : solve(root)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList();
		q.add(A);
		ans.add(A.val);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			TreeNode left = temp.left;
			TreeNode right = temp.right;
			if (left == null) {
				ans.add(-1);
			} else {
				q.add(left);
				ans.add(left.val);
			}

			if (right == null) {
				ans.add(-1);
			} else {
				q.add(right);
				ans.add(right.val);
			}
		}

		return ans;

	}

}
