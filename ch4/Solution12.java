import java.util.HashMap;

/* You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the number of paths that
 * sum to a given value. The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 */

public class Solution12 {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
	}

	public static int countPathsWithSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		HashMap<Integer, Integer> pathCount = new HashMap<Integer, Integer>();
		incrementHashTable(pathCount, 0, 1);
		return countPathsWithSum(root, targetSum, 0, pathCount);
	}

	public static int countPathsWithSum(TreeNode node, int targetSum,
			int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) {
			return 0;
		}
		runningSum += node.data;
		incrementHashTable(pathCount, runningSum, 1);

		int sum = runningSum - targetSum;
		int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;
		// use the recursive way 
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum,
				pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum,
				pathCount);

		incrementHashTable(pathCount, runningSum, -1);
		return totalPaths;
	}

	public static void incrementHashTable(HashMap<Integer, Integer> hashTable,
			int key, int t) {
		// key is the runningsum while value is the count
		if (!hashTable.containsKey(key)) {
			hashTable.put(key, 1);
		} else {
			hashTable.put(key, hashTable.get(key) + t);
		}
	}
}
