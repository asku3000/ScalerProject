package trees.bst;

import trees.TreeNode;

public class ValidBinarySearchTreeApproach3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(35);
		root.right = new TreeNode(41);
		root.left.left = new TreeNode(34);
		root.left.right = new TreeNode(37);
		root.right.right = new TreeNode(46);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		System.out.println(isValidBST(root));

	}

	public static int isValidBST(TreeNode A) {
		if (checkValidBst(A).isValidBst) {
			return 1;
		}

		return 0;
	}

	private static Pair checkValidBst(TreeNode A) {
		if (isLeafNode(A)) {
			return new Pair(A.val, A.val, true);
		}

		if (A == null) {
			return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}

		Pair left = checkValidBst(A.left);
		Pair right = checkValidBst(A.right);

		int max = Math.max(A.val, Math.max(left.max, right.max));
		int min = Math.min(A.val, Math.min(left.min, right.min));
		
		if (left.isValidBst == false || right.isValidBst == false ) {
			return new Pair(max, min, false);
		}
		
		if( left.max >= A.val || right.min <= A.val ) {
			return new Pair(max, min, false);
		}
		
		
		return new Pair(min, max, true);
	}

	static boolean isLeafNode(TreeNode A) {
		if (A == null)
			return false;
		if (A.left == null && A.right == null)
			return true;
		return false;
	}

	static class Pair {
		Integer min;
		Integer max;
		boolean isValidBst;

		public Pair(Integer min, Integer max, boolean isValidBst) {
			this.min = min;
			this.max = max;
			this.isValidBst = isValidBst;
		}

	}

}
