/*
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of T1.
 */

public class Solution10 {
	public boolean containsTree(BSTreeNode t1, BSTreeNode t2) {
		if(t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	
	public boolean subTree(BSTreeNode t1, BSTreeNode t2) {
        // The empty tree is a subtree of every tree.
		if(t1 == null) {
			return false;
		}else if(t1.getValue() == t2.getValue() && matchTree(t1, t2)) {
			return true;
		}
		return subTree(t1.getLeftChild(), t2) || subTree(t1.getRightChild(), t2);
	}
	
	public boolean matchTree(BSTreeNode t1, BSTreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}else if(t1 == null || t2 == null) {
			return false;
		}else if(t1.getValue() != t2.getValue()) {
			return false;
		}else {
			return (matchTree(t1.getLeftChild(), t2.getLeftChild()) && matchTree(t1.getRightChild(), t2.getRightChild()));
		}
	}
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(50);
        n1.left = new TreeNode(10);
        n1.left.left = new TreeNode(10);
        n1.left.right = new TreeNode(30);
        n1.left.left.left = new TreeNode(0);
        n1.left.left.right = new TreeNode(90);
        n1.right = new TreeNode(60);
        n1.right.right = new TreeNode(70);
        n1.right.right.left = new TreeNode(65);
        n1.right.right.right = new TreeNode(80);
        TreeNode n2 = new TreeNode(20);
        n2.left = new TreeNode(10);
        n2.left.left = new TreeNode(0);
        n2.left.right = new TreeNode(90);
        n2.right = new TreeNode(30);
        System.out.println(isSubTree(n1, n2));
        
    }
}
