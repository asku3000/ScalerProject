package trees;

/*
 * Q3. Sum binary tree or not
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.



Problem Constraints

1 <= length of the array <= 100000

0 <= node values <= 50



Input Format

The only argument given is the root node of tree A.



Output Format

Return 1 if it is sum-binary tree else return 0.



Example Input

Input 1:

       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 All leaf nodes are considered as SumTree. 
 Value of Node 10 = 4 + 6.
 Value of Node 3 = 0 + 3 
 Value of Node 26 = 20 + 6 
Explanation 2:

 Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.


 */
public class SumBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
//		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(solve(root));
	}

	public static int solve(TreeNode A) {
		if(isSumTree(A).isSumTree)
			return 1;
		return 0;
	}

	static Pair isSumTree(TreeNode A) {

		if(isLeaf(A)==1) {
			return new Pair(A.val, true);
		}
		if (A == null) {
			return new Pair(0, true);
		}
		Pair lsPair = isSumTree(A.left);
		Pair rsPair = isSumTree(A.right);
		if(!lsPair.isSumTree || !rsPair.isSumTree)
			return new Pair(0, false);
		
		long lsSum = lsPair.sum;
		long rsSum = rsPair.sum;
		if(lsSum+rsSum != A.val) {
			return new Pair(0, false);
		}
		return new Pair(lsSum+rsSum+A.val, true);

	}

	static class Pair {
		long sum;
		boolean isSumTree;

		public Pair(long sum, boolean isSumTree) {
			super();
			this.sum = sum;
			this.isSumTree = isSumTree;
		}

	}
	
	static int isLeaf(TreeNode node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return 0;
    }

}
