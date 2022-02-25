package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q6. Binary Tree From Inorder And Postorder
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format

Return the root node of the binary tree.



Example Input

Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output

Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation

Explanation 1:

 Create the binary tree and return the root node of the tree.

 */
public class BinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 6, 1, 3, 2 });
		List<Integer> B = Arrays.asList(new Integer[] { 6, 3, 2, 1 });

		TreeNode root = buildTree(A, B);

		for (ArrayList<Integer> list : LevelOrderTraversal.levelOrder(root)) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}
	}

	public static TreeNode buildTree(List<Integer> A, List<Integer> B) {
		HashMap<Integer, Integer> index = new HashMap();
		for (int i = 0; i < A.size(); i++) {
			index.put(A.get(i), i);
		}

		TreeNode root = constructTree(B, 0, B.size() - 1, A, 0, A.size() - 1, index);
		return root;
	}

	private static TreeNode constructTree(List<Integer> post, int postStart, int postEnd, List<Integer> in, int inStart,
			int inEnd, HashMap<Integer, Integer> index) {
		if (postStart > postEnd)
			return null;

		// System.out.println(preStart + ", " + preEnd);
		TreeNode temp = new TreeNode(post.get(postEnd));
		if (inStart == inEnd)
			return temp;
		int indexRoot = index.get(post.get(postEnd));
		int lstLength = indexRoot - inStart;
		// creating lst

		temp.left = constructTree(post, postStart, postStart + lstLength - 1, in, inStart, indexRoot - 1, index);
		temp.right = constructTree(post, postStart + lstLength, postEnd - 1, in, indexRoot + 1, inEnd, index);
		return temp;
	}

}
