/*
 * * This method is to create a minimal BST based on a sorted array.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution02 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return bstHelper(nums, 0, nums.length);
    }
    
    public static TreeNode bstHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        
        int len = end - start;
        TreeNode root = new TreeNode(nums[start + len / 2]);

        //Create sub-tree for both left array and right array.
        root.left = bstHelper(nums, start, start + len / 2);
        root.right = bstHelper(nums, start + len / 2 + 1,  end);
        return root;    
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        TreeNode root = sortedArrayToBST(nums);
    }
}