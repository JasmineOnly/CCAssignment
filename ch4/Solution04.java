
public class TreeNode {
    int val;
    TreeNode left;     
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

public class Solution04 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }
    
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (Math.abs(left - right) > 1) {
            return -1;
        } else if (left == -1 || right == -1) {
            return -1;
        }
        else return 1 + Math.max(left, right);
    }
    
}