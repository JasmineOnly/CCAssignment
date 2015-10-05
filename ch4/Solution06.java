/*
 *  This java file is to find the next node of a given node.
 */
public class Solution06 {
	
	// Here use the in-order traversal
	public BSTreeNode inOrderSucc(BSTreeNode root) {
		if(root == null) return null;
		
		if(root.getRightChild() != null) {
			return leftMost(root.getRightChild());
		}else {
			BSTreeNode node = root;
			BSTreeNode parent = root.parent;
			
			while(parent != null && parent.getLeftChild()!=node) { 
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	public BSTreeNode leftMost(BSTreeNode node) {
		if(node == null) return null;
		while(node.getLeftChild()!=null) {
			node = node.getLeftChild();
		}
		return node;
	}
	
	
	// Inner class :BSTreeNode
	class BSTreeNode {
		private int value;
		private BSTreeNode leftChild;
		private BSTreeNode rightChild;
		public BSTreeNode parent;
		private int size = 0;
		
		public BSTreeNode(int d) {
			value = d;
			size = 1;
		}
		public BSTreeNode(){}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getSize() {
			return size;
		}
		public BSTreeNode getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(BSTreeNode leftChild) {
			this.leftChild = leftChild;
		}
		public BSTreeNode getRightChild() {
			return rightChild;
		}
		public void setRightChild(BSTreeNode rightChild) {
			this.rightChild = rightChild;
		}
		
	}
}
