package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q4. Right View of Binary tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



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

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.


 */
public class RightViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

			if (temp.right != null) {
				q.add(temp.right);
			}
			
			if (temp.left != null) {
				q.add(temp.left);
			}
			
		}

		return ans;

	}

}
