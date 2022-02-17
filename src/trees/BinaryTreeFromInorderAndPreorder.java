package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(new Integer[] { 1, 2, 3 });
		List<Integer> B = Arrays.asList(new Integer[] { 2, 1, 3 });
		
		TreeNode root = buildTree(A, B);
		
		for(ArrayList<Integer> list: LevelOrderTraversal.levelOrder(root)) {
			System.out.print("\n");
			for(Integer i: list) {
				System.out.print(i+",");
			}
		}
	}

	public static TreeNode buildTree(List<Integer> A, List<Integer> B) {
		HashMap<Integer, Integer> index = new HashMap();
		for(int i=0; i<B.size(); i++) {
			index.put(B.get(i), i);
		}
		
		TreeNode root = constructTree(A, 0, A.size()-1, B, 0, B.size()-1, index);
		return root;
	}

	private static TreeNode constructTree(List<Integer> a, int preStart, int preEnd, List<Integer> b, int inStart, int inEnd,
			HashMap<Integer, Integer> index) {
		// TODO Auto-generated method stub
		return null;
	}

}
