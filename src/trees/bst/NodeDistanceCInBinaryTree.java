package trees.bst;

import java.util.ArrayList;

import trees.TreeNode;

/**
 * Q1. Node distance C in binary tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B.

You have to find all the nodes that are at a distance of exactly C from the node containing value B.

Return an array of integers consisting all the nodes that are C distance from node containing value B.

Note:

You may return the nodes in any order.

Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .

Constraints

1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9 
0 <= B <= 10^9
0 <= C <= 100
For Example

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

     B = 3
     C = 3
Output 1:
    [4, 5]

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
        B = 4
        C = 1
Output 2:
    [2, 5]
 * @author ASHISH KUMAR
 *
 */
public class NodeDistanceCInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(46);
		root.right = new TreeNode(97);
		root.left.left = new TreeNode(32);
		root.left.right = new TreeNode(44);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(94);
		root.left.left.left = new TreeNode(29);
		root.left.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(35);
		root.left.right.right = new TreeNode(81);
		for (Integer i : solve(root, 7, 4)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(TreeNode A, int B, int C) {
		ArrayList<TreeNode> path = new ArrayList<>();
		findPathToB(A, B, path);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		countNodesAtDistanceK(path.get(0), C, ans);
		C = C-1;
		for(int i=1; i<path.size(); i++) {
			if(C==0) {
				ans.add(path.get(i).val);
				break;
			}
			
			if(path.get(i-1) == path.get(i).left) {
				countNodesAtDistanceK(path.get(i).right, C-1, ans);
			}else {
				countNodesAtDistanceK(path.get(i).left, C-1, ans);
			}
			C=C-1;
		}
		return ans;
	}

	static int countNodesAtDistanceK(TreeNode A, int k, ArrayList<Integer> ans) {
		if (A == null) {
			return 0;
		}

		if (k == 0) {
			ans.add(A.val);
			return 1;
		}
		int l = countNodesAtDistanceK(A.left, k - 1, ans);
		int r = countNodesAtDistanceK(A.right, k - 1, ans);

		return l + r;
	}

	private static boolean findPathToB(TreeNode A, int B, ArrayList<TreeNode> path) {
		if (A == null) {
			return false;
		}

		if (A.val == B) {
			path.add(A);
			return true;
		}

		if (findPathToB(A.left, B, path) || findPathToB(A.right, B, path)) {
			path.add(A);
			return true;
		}

		return false;
	}

}
