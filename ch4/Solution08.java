public class Solution08 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// node is not in the tree  or one covers the other.
		if (!covers(root, p) || !covers(root, q)) { 
			return null;
		} else if (covers(p, q)) { 

			return p;
		} else if (covers(q, p)) {
			return q;
		}
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) { 
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	public static boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return covers(root.left, p) || covers(root.right, p);
	}

	// find the sibling of the node
	public static TreeNode getSibling(TreeNode node) { 
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;

	}
}
