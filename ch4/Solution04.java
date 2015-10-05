/*
 * This file is use to check whether a tree is a balance tree
 */
public class Solution04 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int left = countNode(root.left);
		int right = countNode(root.right);
		// the subtrees also should be balance tree
		return ((Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right));

	}

	//This method is used to get the depth of root
	public int countNode(TreeNode root) {
		if (root == null) {
			return 0;
		}

		
		int countleft = countNode(root.left) + 1;
		int countright = countNode(root.right) + 1;

		return Math.max(countleft, countright);

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
