package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Q2. Vertical Order traversal
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints

0 <= number of nodes <= 105



Input Format

First and only arument is a pointer to the root node of binary tree, A.



Output Format

Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input

Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output

Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation

Explanation 1:

 First row represent the verical line 1 and so on.

 */

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(6);
		A.left = new TreeNode(3);
		A.right = new TreeNode(7);
		A.left.left = new TreeNode(2);
		A.left.right = new TreeNode(5);
		A.right.right = new TreeNode(9);

		for(ArrayList<Integer> list: verticalOrderTraversal(A)) {
			System.out.print("\n");
			for(Integer i: list) {
				System.out.print(i+",");
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<List<Object>> q = new LinkedList();
		int minLevel = 0;
		int maxLevel = 0;
		q.add(Arrays.asList(new Object[] {A, 0}));
		while(!q.isEmpty()) {
			
			List<Object> curr = new ArrayList<Object>( q.poll());
			TreeNode currNode = (TreeNode) curr.get(0);
			Integer currLevel = (Integer) curr.get(1);
			ArrayList<Integer> levelList = map.getOrDefault(curr.get(1), new ArrayList<Integer>());
			levelList.add(currNode.val);
			map.put(currLevel, levelList);
			if(currNode.left != null) {
				q.add(Arrays.asList(new Object[] {currNode.left, currLevel-1}));
			}
			if(currNode.right != null) {
				q.add(Arrays.asList(new Object[] {currNode.right, currLevel+1}));
			}
			minLevel = Math.min(minLevel, currLevel);
			maxLevel = Math.max(maxLevel, currLevel);
			
		}
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(int i=minLevel; i<=maxLevel; i++) {
			ans.add(map.get(i));
		}
		
		return ans;
    }

}
