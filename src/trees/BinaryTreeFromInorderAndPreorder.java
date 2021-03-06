package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q5. Binary Tree From Inorder And Preorder
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format

Return the root node of the binary tree.



Example Input

Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


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
public class BinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 1, 2, 3 });
		List<Integer> B = Arrays.asList(new Integer[] { 2, 1, 3 });

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
		for (int i = 0; i < B.size(); i++) {
			index.put(B.get(i), i);
		}

		TreeNode root = constructTree(A, 0, A.size() - 1, B, 0, B.size() - 1, index);
		return root;
	}

	private static TreeNode constructTree(List<Integer> pre, int preStart, int preEnd, List<Integer> in, int inStart,
			int inEnd, HashMap<Integer, Integer> index) {
		if (preStart > preEnd)
			return null;

		// System.out.println(preStart + ", " + preEnd);
		TreeNode temp = new TreeNode(pre.get(preStart));

		int indexRoot = index.get(pre.get(preStart));
		int lstLength = indexRoot - inStart;
		// creating lst

		temp.left = constructTree(pre, preStart + 1, preStart + lstLength, in, inStart, indexRoot - 1, index);
		temp.right = constructTree(pre, preStart + lstLength + 1, preEnd, in, indexRoot + 1, inEnd, index);
		return temp;
	}

}
