package trees;

import java.util.ArrayList;

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
