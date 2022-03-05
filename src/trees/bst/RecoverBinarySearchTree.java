package trees.bst;

import java.util.ArrayList;

import trees.TreeNode;

/*
 * Q1. Recover Binary Search Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Two elements of a binary search tree (BST),represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree,A



Output Format
Return the 2 elements which need to be swapped.



Example Input
Input 1:

 
         1
        / \
       2   3
Input 2:

 
         2
        / \
       3   1



Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:

Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 

 */
public class RecoverBinarySearchTree {

	static TreeNode first, second , prev;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		for(Integer i: recoverTree(root)) {
			System.out.print(i+",");
		}

	}

	public static ArrayList<Integer> recoverTree(TreeNode A) {
		first =null; second = null; prev = null;
		findSwapped(A);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(first.val);
		ans.add(second.val);
		return ans;
	}

	private static void findSwapped(TreeNode a) {
		if(a== null) {
			return;
		}
		
		findSwapped(a.left);
		if(prev != null && prev.val > a.val) {
			if(first == null)
				first = prev;
			second = a;
		}
		
		prev = a;
		findSwapped(a.right);
		
	}
}
