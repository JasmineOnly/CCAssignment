
class TreeNode {
    int val;
    TreeNode left; 
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution03 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode> ();
        nodes.offer(root);
        ArrayList<Integer> firstlevel = new ArrayList<Integer> ();
        firstlevel.add(root.val);
        result.add(firstlevel);

        while(!nodes.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer> ();
            int size = nodes.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = nodes.poll();
                if (node.left != null) {
                    level.add(node.left.val);
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    level.add(node.right.val);
                    nodes.offer(node.right);
                }
            }
            if (level.size() > 0){
                result.add(level);}
        }
        
        return result;
    }
}