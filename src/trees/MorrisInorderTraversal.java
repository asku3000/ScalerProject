package trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		for (Integer i : morrisInorderTraversal(root)) {
			System.out.println(i + ",");
		}
	}

	public static ArrayList<Integer> morrisInorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeNode curr = A;
		while (curr != null) {
			if (curr.left == null) {
				ans.add(curr.val);
				curr = curr.right;
			} else {
				// find inorder predecessor to connect to curr
				TreeNode temp = curr.left;
				while (temp != null && temp.right != null && temp.right != curr) {
					temp = temp.right;
				}

				if (temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				} else {
					temp.right = null;
					ans.add(curr.val);
					curr = curr.right;
				}

			}
		}
		
		return ans;
	}

}
