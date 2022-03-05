package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Q1. Deserialize Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints

1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format

Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format

Return the root node of the Binary Tree.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output

Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


Example Explanation

Explanation 1:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.


 */
public class DeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = solve(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1}));
		
		for(ArrayList<Integer> list : LevelOrderTraversal.levelOrder(root)) {
			System.out.print("\n");
			for(Integer i: list) {
				System.out.print(i+",");
			}
		}
		
	}
	
	public static TreeNode solve(List<Integer> A) {
		TreeNode root = new TreeNode(A.get(0));
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		int i = 1;
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr == null) {
				continue;
			}
			
			int leftVal = A.get(i);
			int rightVal = A.get(i+1);
			i+=2;
			
			if(leftVal == -1) {
				curr.left = null;
			}else {
				curr.left = new TreeNode(leftVal);
			}
			
			if(rightVal == -1) {
				curr.right = null;
			}else {
				curr.right = new TreeNode(rightVal);
			}
			q.add(curr.left);
			q.add(curr.right);
		}
		
		return root;
    }

}
