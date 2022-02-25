package trees;

/*
 * Q4. Symmetric Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is the root node of the binary tree.



Output Format

Return 0 / 1 ( 0 for false, 1 for true ).



Example Input

Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The above binary tree is symmetric. 
Explanation 2:

The above binary tree is not symmetric.
 */
public class SymetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root) == 1 ? "Symmetric" : "Non-Symmetric");
	}

	public static int isSymmetric(TreeNode A) {
		if (checkSymmetry(A, A)) {
			return 1;
		} else {
			return 0;
		}
	}

	private static boolean checkSymmetry(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 != null && node2 != null && node1.val == node2.val) {
			return checkSymmetry(node1.left, node2.right) && checkSymmetry(node1.right, node2.left);
		}

		return false;
	}

}
