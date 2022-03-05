package trees;

import java.util.HashSet;

/*
 * Q4. Equal Tree Partition
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.

 */
public class EqualTreePartition {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(solve(root));
	}

	static HashSet<Long> set;

	public static int solve(TreeNode A) {
		set = new HashSet();
		long totalSum = findSumOfNodes(A);
		if (totalSum % 2 != 0) {
			return 0;
		}
		findDiffSum(A);
		if (set.contains(totalSum / 2)) {
			return 1;
		} else {
			return 0;
		}

	}

	static long findDiffSum(TreeNode A) {
		if (A == null) {
			return 0;
		}
		long curr = A.val + findDiffSum(A.left) + findDiffSum(A.right);
		set.add(curr);
		return curr;
	}

	static long findSumOfNodes(TreeNode A) {
		if (A == null) {
			return 0;
		}

		long l = findSumOfNodes(A.left);
		long r = findSumOfNodes(A.right);

		return A.val + l + r;
	}

}
