import java.util.Arrays;

public class Solution01 {
	public static void main(String[] args){
		Solution01 s = new Solution01();
		int[] a = new int[10];
		for(int i = 0; i< 5; i++){
			a[i] = i;
		}
		int[] b = {2,4,6,8};
		int[] result = s.merge(a,b);
		for(int i : result){
			System.out.print(i + " ");
		}
		
	}

	/*
	 * This function is used to merge two sorted array Assume that a has a large
	 * enough buffer at the end to hold b
	 */

	public int[] merge(int[] a, int[] b) {
		int aLast = findLast(a);
		int bLast = b.length - 1;
		int last = a.length - 1;

		while (aLast >= 0) {
			if (bLast >= 0 && a[aLast] < b[bLast]) {
				a[last] = b[bLast];
				bLast--;
			} else {
				a[last] = a[aLast];
				aLast--;
			}

			last--;
		}
		
		return a;

	}

	/*
	 * Method to find the last element of the array Assumption: when traverse
	 * the array from back to front, the first non-zero element is considered as
	 * the last element of the array
	 */
	public int findLast(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] != 0) {
				return i;
			}
		}
		return 0;
	}
}
