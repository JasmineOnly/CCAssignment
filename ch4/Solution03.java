import java.util.*;

/*
 * This java file is used to creates a linked list of all the nodes at each depth of a binary tree
 * In this method, we iterator through the root first, then level 2, level 3 and so on
 **/

public class Solution03 {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		TreeNode n4 = new TreeNode(4);
		n2.left = n4;
		
		ArrayList<LinkedList<TreeNode>> result = nodeLevel(n1);
		int index = 0;
		for(LinkedList list : result){
			for(TreeNode node : result.get(index)){
				System.out.print(node.val + " ");
			}
			
			System.out.println("");
			index++;
		}
	}
	public static ArrayList<LinkedList<TreeNode>> nodeLevel(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		// add the root to the first level

		curr.add(root);

		while (curr.size() > 0) {
			result.add(curr);

			// save the current node and go to the next level
			LinkedList<TreeNode> parents = curr;
			curr = new LinkedList<TreeNode>();

			for (TreeNode node : parents) {
				if (node.left != null) {
					curr.add(node.left);
				}

				if (node.right != null) {
					curr.add(node.right);
				}
			}
		}
		
		return result;

	}

}
