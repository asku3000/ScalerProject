package trees.bst;

import trees.TreeNode;

public class ValidBinarySearchTreeApproach2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
//		root.left = new TreeNode(35);
		root.right = new TreeNode(5);
//		root.left.left = new TreeNode(34);
//		root.left.right = new TreeNode(37);
		root.right.left = new TreeNode(3);
//		TreeNode root = new TreeNode(40);
//		root.left = new TreeNode(35);
//		root.right = new TreeNode(41);
//		root.left.left = new TreeNode(34);
//		root.left.right = new TreeNode(37);
//		root.right.right = new TreeNode(46);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		System.out.println(isValidBST(root));

	}

	public static int isValidBST(TreeNode A) {
		if (checkValidBst(A, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return 1;
		}

		return 0;
	}

	private static boolean checkValidBst(TreeNode A, int minValue, int maxValue) {
		if (A == null) {
			return true;
		}

		if (A.val >= minValue && A.val <= maxValue) {

			boolean left = checkValidBst(A.left, minValue, A.val - 1);
			boolean right = checkValidBst(A.right, A.val + 1, maxValue);

			return left && right;
		}

		return false;
	}

}
