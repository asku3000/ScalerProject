package trees;

public class DiameterOfTree {
	static int diameter;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		solve(root);
		System.out.println(diameter);
		
	}

	public static int solve(TreeNode A) {
		diameter = 0;
		diameter(A);
		return diameter;
	}
	
	static int diameter(TreeNode A) {
		if (A == null) {
			return -1;
		}

		int l = diameter(A.left);
		int r = diameter(A.right);
		diameter = Math.max(diameter, l+r+2);
		return 1 + Math.max(l, r);
	}

}
