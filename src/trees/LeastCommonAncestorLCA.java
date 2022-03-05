package trees;

/*
 * Q3. Least Common Ancestor
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Find the lowest common ancestor in an unordered binary tree A given two values B and C in the tree.

Lowest common ancestor : the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.



Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109



Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.



Output Format

Return the LCA.



Example Input

Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.
 */
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
