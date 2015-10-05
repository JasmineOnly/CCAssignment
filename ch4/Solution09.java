
import java.util.ArrayList;
import java.util.LinkedList;

/* A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements,
 * print all possible arrays that could have led to this tree.
 */

public class Solution09 {
    
	public ArrayList<LinkedList<Integer>> BSTSequence(BSTreeNode root) {
		 ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		 
		 if(root == null) {
			 result.add(new LinkedList<Integer>());
			 return result;
		 }
		 
		 LinkedList<Integer> prefix = new LinkedList<Integer>();
		 prefix.add(root.getValue());
		 
		 ArrayList<LinkedList<Integer>> leftSeq = BSTSequence(root.getLeftChild());
		 ArrayList<LinkedList<Integer>> rightSeq = BSTSequence(root.getRightChild());
		 
		 for (LinkedList<Integer> left : leftSeq) {
			 for (LinkedList<Integer> right : rightSeq) {
				 ArrayList<LinkedList<Integer>> weaved = 
						 new ArrayList<LinkedList<Integer>>();
				 weavelists(left,right,weaved,prefix);
				 result.addAll(weaved);
			 }
		 }
		 return result;
	}
	
    // Weave lists together in all possible way
	public void weavelists(LinkedList<Integer> first, LinkedList<Integer> second,
			               ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weavelists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int secondHead = second.removeFirst();
		prefix.addLast(secondHead);
		weavelists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(secondHead);
	}
    
    public static void main(String[] args) {
        TreeNode n=new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.left= new TreeNode(3);
        n.left.right=new TreeNode(4);
        n.left.left.left=new TreeNode(5);
        n.left.left.right=new TreeNo0de(6);
        n.right = new TreeNode(7);
        n.right.right=new TreeNode(8);
        n.right.right.left=new TreeNode(9);
        n.right.right.right=new TreeNode(10);
        ArrayList<LinkedList<Integer>> n2=sequences(n);
        print(n2);
        
    }
}
