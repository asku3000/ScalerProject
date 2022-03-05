package trees;

public class LeastCommonAncestorLCA {

	static boolean v1 = false, v2 = false;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(lca(root, 2, 5));
	}

	public static int lca(TreeNode A, int B, int C) {
		v1 = false;
		v2 = false;
		TreeNode ans = findLca(A, B, C);
		if (v1 && v2)
			return ans.val;
		return -1;
	}

	static TreeNode findLca(TreeNode A, int B, int C) {
		if (A == null) {
			return null;
		}

		TreeNode temp = null;

		if (A.val == B) {
			v1 = true;
			temp = A;
		}
		if (A.val == C) {
			v2 = true;
			temp = A;
		}
		TreeNode l = findLca(A.left, B, C);
		TreeNode r = findLca(A.right, B, C);

		if (temp != null) {
			return temp;
		}

		if (l != null && r != null) {
			return A;
		}

		return l != null ? l : r;

	}

}
