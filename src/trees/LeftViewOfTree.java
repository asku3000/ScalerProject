package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q3. Left View of Binary tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format
First and only argument is a root node of the binary tree, A.



Output Format
Return an integer array denoting the left view of the Binary tree.



Example Input
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8]
Output 2:

 [1, 2, 4, 5]


Example Explanation
Explanation 1:

 The Left view of the binary tree is returned.

 */
public class LeftViewOfTree {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.right = new TreeNode(4);
		A.left.right.right = new TreeNode(5);

		System.out.print("\n");
		for (Integer i : solve(A)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList();

		Queue<TreeNode> q = new LinkedList();
		q.add(A);
		q.add(null);
		ans.add(A.val);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			if (temp == null && q.isEmpty()) {
				break;
			}

			if (temp == null) {
				ans.add(q.peek().val);
				q.add(null);
				continue;
			}

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
