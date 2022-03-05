package trees;

import java.util.ArrayList;

/*
 * Q2. Boundary Traversal Of Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Given a binary tree. Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from the root to the left-most node. Right boundary is defined as the path from the root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Return an array of integers denoting the boundary values of tree in anti-clockwise order.

For Example

Input 1:
               _____1_____
              /           \
             2             3
            / \            / 
           4   5          6   
              / \        / \
             7   8      9  10  
Output 1:
    [1, 2, 4, 7, 8, 9, 10, 6, 3]
    Explanation 1:
        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
        The leaves are node 4,7,8,9,10.
        The right boundary are node 1,3,6,10. (10 is the right-most node).
        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

Input 2:
                1
               / \
              2   3
             / \  / \
            4   5 6  7
Output 2:
     [1, 2, 4, 5, 6, 7, 3] 
 */
public class BoundaryTraversalOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		for (Integer i : solve(root)) {
			System.out.print(i + ",");
		}
	}

	public static ArrayList<Integer> solve(TreeNode A) {

		ArrayList<Integer> ans = new ArrayList<>();
		if (A == null)
			return new ArrayList<>();

		ans.add(A.val);
		if (isLeafNode(A)) {
			return ans;
		}
		// Print the left boundary
		ArrayList<Integer> left = new ArrayList<Integer>();
		printLeftBoundary(A.left, left);
		// Print all leaf nodes
		printLeaves(A.left, left);
		ArrayList<Integer> right = new ArrayList<Integer>();
		printLeaves(A.right, right);
		// Print the right boundary
		printRightBoundary(A.right, right);
		ans.addAll(left);
		ans.addAll(right);
		return ans;
	}

	private static void printRightBoundary(TreeNode A, ArrayList<Integer> right) {
		if (A == null)
			return;
		if (A.right != null) {
			printRightBoundary(A.right, right);
			right.add(A.val);
		} else if (A.left != null) {
			printRightBoundary(A.left, right);
			right.add(A.val);
		}

	}

	private static void printLeftBoundary(TreeNode A, ArrayList<Integer> left) {
		if (A == null)
			return;
		if (A.left != null) {
			left.add(A.val);
			printLeftBoundary(A.left, left);
		} else if (A.right != null) {
			left.add(A.val);
			printLeftBoundary(A.right, left);
		}

	}

	private static boolean isLeafNode(TreeNode A) {
		if (A == null)
			return true;
		if (A.left == null && A.right == null)
			return true;
		return false;
	}

	static void printLeaves(TreeNode node, ArrayList<Integer> leaves) {
		if (node == null)
			return;
		printLeaves(node.left, leaves);
		// Print it if it is a leaf node
		if (isLeafNode(node))
			leaves.add(node.val);
		printLeaves(node.right, leaves);
	}

}
