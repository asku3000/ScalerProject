package trees.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import trees.TreeNode;

/*
 * Q3. Floor and Ceil in BST
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a Binary Search Tree rooted at A.

Given an integer array B of size N. Find the floor and ceil of every element of the array B.

Floor(X) is the highest element in the tree <= X, while the ceil(X) is the lowest element in the tree >= X.

NOTE: If floor or ceil of any element of B doesn't exists, output -1 for the value which doesn't exists.



Problem Constraints

0 <= Number of nodes in the tree <= 1000000
0 <= node values <= 109
0 <= N <= 100000
0 <= B[i] <= 109



Input Format

First argument represents the root of binary tree A.
Second argument is an integer array B.



Output Format

Return an integer array C of size N*2. C[i][0] denotes the floor value of B[i] and C[i][1] represents the ceil value of B[i] in the given tree.



Example Input

Input 1:

Given Tree A:
           10
         /    \
        4      15
       / \
      1   8
B = [4, 19]
Input 2:

Given Tree A:
            8
          /   \
         5     19
        / \     \
       4   7     100
B = [1, 11]       


Example Output

Output 1:

[
    [4, 4]
    [15, -1]
]
Output 2:

[
    [-1, 4]
    [8, 19]
]


Example Explanation

Explanation 1:

Take all elements of given tree in sorted form: [1, 4, 8, 10, 15].
4 is present in the tree. So, for B[0] = 4, output is [4, 4] as both floor and ceil value is 4.

For B[1] = 19,
Highest element <= 19 is 15. So the floor value of 19 is 15. 
19 is greater than all elements in the tree. So, the ceil value of 19 doesn't exists.
So, output is [15, -1].
Explanation 2:

All elements of tree in sorted form: [4, 5, 7, 8, 19, 100].

For B[0] = 1, 
There is no element in the tree <= 1. So, the floor value doesn't exists.
Lowest element >= 1 is 4. So, the ceil value is 4.
So, output is [-1, 4]

Similarily for B[1] = 11, output is [8, 19].

 */
public class FloorAndCeilInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(4);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);

		for (ArrayList<Integer> list : solve(root, Arrays.asList(new Integer[] { 4, 19 }))) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> solve(TreeNode A, List<Integer> B) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(Integer i: B) {
			ans.add(findFloorCiel(A, i));
		}
		return ans;
	}
	
	static ArrayList<Integer> findFloorCiel(TreeNode root, int key){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int floor = -1;
		int ceil = -1;
		while(root!= null) {
			if(root.val == key) {
				floor = root.val;
				ceil = root.val;
				break;
			}
			
			if(root.val > key) {
				ceil = root.val;
				root = root.left;
			}else {
				floor = root.val;
				root = root.right;
			}
		}
		
		ans.add(floor);
		ans.add(ceil);
		return ans;
	}

}
