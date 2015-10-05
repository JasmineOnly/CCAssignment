/*
 * You are implementing a binary tree class from scratch, which, in addition to insert,
 * find, and delete, has a method getRandomNode() which returns a random node from the tree.
 * All nodes should be equally likely to be chosen. Design and implement an algorithm for
 * getRandomNode, and explain how you would implement the rest of the methods.
 */

import java.util.Random;

import org.omg.CORBA.TRANSACTION_REQUIRED;

public class Solution11 {
	public class TreeNode {
		private int data;
		public TreeNode left;
		public TreeNode right;
		private int size = 0;
		
		public TreeNode(int d) {
			data = d;
			size = 1;
		}
		
		public TreeNode getRandomNode() {
			int leftSize = left == null ? 0:left.getSize();
            
			Random random = new Random();
			int index = random.nextInt(leftSize);
			if(index<leftSize) {
				return left.getRandomNode();
			}else if(index == leftSize) {
				return this;
			}else {
				return right.getRandomNode();
			}
		}
		
        // in recusive way
		public void insertInOrder(int d) {
			if(d<=data) {
				if(left == null) {
					left = new TreeNode(d);
				}else {
					left.insertInOrder(d);
				}
			}else {
				if(right == null) {
					right = new TreeNode(d);
				}else {
					right.insertInOrder(d);
				}
			}
			size++;
		}
		
		public int getSize() {
			return size;
		}
		
		public TreeNode find(int d) {
			if(d == data) {
				return this;
			}else if(d <= data) {
				return left != null ? left.find(d) : null;
			}else if (d > data) {
				return right != null ? right.find(d) : null;
			}
			return null;
		}
	}
}
