
public class Solution02 {
	public static void main(String[] args){
		int[] arry = {1,2,3,4,5};
		TreeNode n = sortedArrayToBST(arry);
		
	}
	
	public static TreeNode sortedArrayToBST(int arry[]){
		return createMinimalBST(arry, 0, arry.length-1);
	}
	
	public static TreeNode createMinimalBST(int arry[], int left, int right){
		if(left < right){
			return null;
		}
		
		int mid = left + (left-right)/2;
		// The middle of each subsection of the array becomes the root the node
		TreeNode root = new TreeNode(arry[mid]);
		root.left = createMinimalBST(arry, left, mid-1);
		root.right = createMinimalBST(arry, mid+1, right);
		
		return root;
		
	}

}
