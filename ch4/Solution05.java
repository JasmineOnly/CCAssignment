/*
 *  This file is to check whether a tree is a BST or not
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution05 {
    
    //Check the tree by definition of BST
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        inorder(inorder, root);
        
        int cur = inorder.get(0);
        for (int i = 1; i < inorder.size(); i ++) {
            if (inorder.get(i) <= cur) {
                return false;
            }
            cur = inorder.get(i);
        }
        return true;
    }
    
    
    public static void inorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public static void main(String[] args) {
    	TreeNode[] nodes = new TreeNode[7];
    	for (int i = 0; i < 7; i ++) {
    		nodes[i] = new TreeNode(i);
    	}

    	nodes[3].left = nodes[2];
    	nodes[2].left = nodes[1];
    	nodes[3].right = nodes[5];
    	nodes[5].left = nodes[4];
    	nodes[5].right = nodes[6];

    	System.out.println((isValidBST(nodes[3]) == true)? "true": "false");
    }
}
